package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.ecommerce.model.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    default User saveUser(User user) {
        return save(user);
    }

    default List<User> getAllUsers() {
        return findAll();
    }

    default User getUserById(Long id) {
        return findById(id).orElse(null);
    }

    default void deleteUser(Long id) {
        deleteById(id);
    }

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findUserByUsername(@Param("username") String username);

}
