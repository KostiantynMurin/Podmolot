package com.a.k.podmolot.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

import com.a.k.podmolot.entity.User;

public interface UserService
{
    public User getUserById(long id);
    
    public void updateUserByEmail(User user, UserDetails currentUser);

}
