package com.example.jwt.domain.order;

import com.example.jwt.core.exception.ProductNotInStockException;
import com.example.jwt.core.exception.UserNot18Exception;
import com.example.jwt.core.exception.UserHaveToBeDiamondException;
import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.core.generic.ExtendedServiceImpl;
import com.example.jwt.domain.category.Category;
import com.example.jwt.domain.category.CategoryService;
import com.example.jwt.domain.placeorder.PlaceOrder;
import com.example.jwt.domain.product.Product;
import com.example.jwt.domain.product.ProduktService;
import com.example.jwt.domain.rank.Rank;
import com.example.jwt.domain.rank.RankService;
import com.example.jwt.domain.user.User;
import com.example.jwt.domain.user.UserDetailsImpl;
import com.example.jwt.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl extends ExtendedServiceImpl<Order> implements OrderService {


    private final ProduktService produktService;
    private final RankService rankService;
    private final UserService userService;
    private final OrderRepository orderRepository;
    private final CategoryService categoryService;

    @Autowired
    public OrderServiceImpl(ExtendedRepository<Order> repository, ProduktService produktService, RankService rankService, UserService userService, OrderRepository orderRepository, CategoryService categoryService) {
        super(repository);

        this.produktService = produktService;
        this.rankService = rankService;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
    }


    public Set<Order> findallOrdersbyUser() {

        //Get User
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = ((UserDetailsImpl) principal).user();

        return orderRepository.findAllByAppuser(user);
    }


    @Transactional
    public Order placeOrder(Order order) {

        User user = userService.getCurrentUser();

        order.setAppuser(user);

        //All ordert Products
        Set<Product> products = new HashSet<>();
        for (PlaceOrder placeOrder : order.getPlaceOrders()) {
            products.add(produktService.findById(placeOrder.getProduct().getId()));
        }




        Map<Product,Long> productLongMap = new HashMap<>();
        for (PlaceOrder placeOrder : order.getPlaceOrders()) {
            productLongMap.put(produktService.findById(placeOrder.getProduct().getId()),placeOrder.getQuantity());
        }
        if(isProductOnStock(productLongMap));


        //Set new nummer
        for (PlaceOrder placeOrder : order.getPlaceOrders()) {

            // update new product nummber
                Product product = produktService.findById(placeOrder.getProduct().getId());

                product.setNummber(product.getNummber()-placeOrder.getQuantity());

                produktService.updateById(placeOrder.getProduct().getId(),product);

        }






        //Check if user is old enough
        if (!isProductOver18(products)){
            throw new UserNot18Exception("You have to be 18 to order the strong leafs baby");
        }

        //Check if Category is allowed
        if (!allowedToOrderCathegory(products)){
            throw new UserHaveToBeDiamondException("You have to be at least rank Diamond, to Order this kind of Category");
        }


        //Total Price
        double priceSum = 0;

        for (PlaceOrder placeOrder : order.getPlaceOrders()) {
            priceSum += produktService.findById(placeOrder.getProduct().getId()).getSellingprice100g();
        }
        order.setTotalPrice(priceSum);


        //discount
        Rank currentRank = rankService.findById(user.getRank().getId());
        int discountinpercent = currentRank.getDiscountInPercent();
        order.setDiscount(discountinpercent);
        double calcDiscount = (priceSum / 100) * discountinpercent;
        order.setTotalPriceWithDiscount(priceSum - calcDiscount);


        // Set new UserRank
        long currentSeeds = user.getSeeds();
        double newSeeds = priceSum * 0.5; // 1Seed = 2Fr
        double newtotalSeeds = currentSeeds + newSeeds;
        user.setSeeds((int) newtotalSeeds);


        // set new rank via Query
        user.setRank(rankService.getRankBetweenFromSeeds(newtotalSeeds));

        //update user
        userService.updateById(user.getId(), user); // update current user to new rank

        //status
        order.setStatus(true);

        //update order_id in placeOrder
        Order savedOrder = save(order);

        savedOrder.setPlaceOrders(order.getPlaceOrders().stream().map(placeOrder -> {
            placeOrder.setOrder(savedOrder);
            return placeOrder;
        }).collect(Collectors.toSet()));

        updateById(savedOrder.getId(), savedOrder);

        return findById(savedOrder.getId());

    }

    public boolean allowedToOrderCathegory(Set<Product> products){

        User user = userService.getCurrentUser();

        Boolean allowed = false;

        for (Product product : products) {

            Category category = categoryService.findById(product.getCategory().getId());
            int neededSeedsForRank = category.getMin_UserRank_Required().getNeededSeedForRank();

            int userRankSeeds = user.getSeeds();

             if(userRankSeeds >= neededSeedsForRank){
                 allowed = true;
             }else{
                 allowed = false;
                 break;
             }
        }
        return allowed;

    }

    //rename to doesUserComplyWithAgeRestrictions
    public boolean isProductOver18(Set<Product> products){


       User user = userService.getCurrentUser();

        Boolean allowedTOOrder = false;

        for (Product product : products) {

            if(user.getAge() >= categoryService.findById(product.getCategory().getId()).getRequired_age()){
                allowedTOOrder = true;
            }else{
                allowedTOOrder = false;
                break;
            }

        }
        return allowedTOOrder;

    }

    public boolean isProductOnStock(Map<Product,Long> productLongMap){
        boolean onStock = false;

        for (Map.Entry<Product,Long> entry : productLongMap.entrySet())

            if(entry.getKey().getNummber() < entry.getValue() && entry.getKey().getNummber() > 1){
                onStock = false;
                onStock = false;
                throw new ProductNotInStockException
                        ("Your Quantity is to High max Products awayable: "+ entry.getKey().getDescription()  + " " + entry.getKey().getNummber());

            }else if (entry.getKey().getNummber() < 1){
                throw new ProductNotInStockException("Product is out of order");

            }
            else {
                onStock = true;
            }
        return onStock;

    }




    }







