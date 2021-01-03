package com.a.k.podmolot.dao;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import com.a.k.podmolot.entity.User;

public interface UserDao
{

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    void updateUser(User user, UserDetails currentUser);

}
