package com.example.jwt.domain.user;

import com.example.jwt.core.generic.ExtendedEntityAudit;
import com.example.jwt.domain.rank.Rank;
import com.example.jwt.domain.role.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends ExtendedEntityAudit {


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "notLocked")
    private boolean notLocked;

    @ManyToOne
    @JoinColumn(name = "rank_id", nullable = true)
    private Rank rank;

    @Column(name = "seeds")
    private int seeds;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();



    public User(UUID uuid, String firstName, String lastName, int age, String email, String password, boolean notLocked, Rank rank, int seeds, Set<Role> roles) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.notLocked = notLocked;
        this.rank = rank;
        this.seeds = seeds;
        this.roles = roles;
        super.setId(uuid);
    }
    public User( String firstName, String lastName, int age, String email, String password, boolean notLocked, Rank rank, int seeds, Set<Role> roles) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.notLocked = notLocked;
        this.rank = rank;
        this.seeds = seeds;
        this.roles = roles;

    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getSeeds() {
        return seeds;
    }

    public void setSeeds(int seeds) {
        this.seeds = seeds;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isNotLocked() {
        return notLocked;
    }

    public void setNotLocked(boolean locked) {
        this.notLocked = locked;
    }
}
