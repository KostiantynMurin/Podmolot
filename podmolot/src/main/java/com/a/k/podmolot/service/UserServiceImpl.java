package com.a.k.podmolot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.a.k.podmolot.dao.UserDao;
import com.a.k.podmolot.entity.User;
import com.a.k.podmolot.exception.ProfileNotFoundException;
import com.a.k.podmolot.repository.UserRepository;
import com.a.k.podmolot.repository.UserRoleRepository;
import com.a.k.podmolot.service.interfaces.UserService;

@Primary
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(long id)
    {
        return userDao.getUserById(id).orElseThrow(() -> new ProfileNotFoundException(id));
    }

    @Override
    public void updateUserByEmail(User user, UserDetails currentUser)
    {
        userDao.updateUser(user, currentUser);
    }

    

    

}
