package com.a.k.podmolot.dao;

import org.springframework.security.core.userdetails.UserDetails;

import com.a.k.podmolot.entity.Category;

public interface CategoryDao
{
    void updateUserCategory(Category category, UserDetails currentUser);
}
