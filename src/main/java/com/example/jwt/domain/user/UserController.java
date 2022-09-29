package com.example.jwt.domain.user;

import com.example.jwt.domain.user.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/stat1")
    @PreAuthorize("hasAuthority('CAN_SEE_STATISTICS')")
    public ResponseEntity<UserIdNameAndPriceSpendDTO> getUserSpendTheMost() {
        return new ResponseEntity<>(userService.getUserSpendTheMost(), HttpStatus.OK);
    }

    @GetMapping(value = "/{date1}/{date2}")
    @PreAuthorize("hasAuthority('CAN_SEE_STATISTICS')")
    public ResponseEntity<List<NameSumDisxountDTO>> getUserDiscountSum(@PathVariable String date1, @PathVariable String date2) {

        return new ResponseEntity<>(userService.getUsersSumDiscount(date1, date2), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_READ')")
    public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('USER_READ') && @userPermissionEvaluator.isUserAboveAge(authentication.principal.user,18)")
    public @ResponseBody
    ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
    }



    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        User user = userService.register(userMapper.fromUserRegisterDTO(userRegisterDTO));
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_MODIFY')")
    public ResponseEntity<UserDTO> updateById(@PathVariable UUID id, @Validated @RequestBody UserDTO userDTO) {
        User user = userService.updateById(id, userMapper.fromDTO(userDTO));
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @PutMapping("/lockUser/{id}")
    @PreAuthorize("hasAuthority('USER_MODIFY')")
    public ResponseEntity<UserDTO> lockUser(@PathVariable UUID id) {
        User user = userService.lockUser(id);
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
