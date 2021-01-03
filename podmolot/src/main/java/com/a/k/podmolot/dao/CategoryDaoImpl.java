package com.a.k.podmolot.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.a.k.podmolot.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao
{

    private CategoryMapper categoryMapper;
    
    @Override
    public void updateUserCategory(Category category, UserDetails currentUser)
    {
        // TODO Auto-generated method stub
        
    }

}
