package com.a.k.podmolot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.k.podmolot.entity.Category;
import com.a.k.podmolot.repository.UserCategoryRepository;
import com.a.k.podmolot.service.interfaces.UserCategoryService;

@Service
public class UserCategoryServiceImpl implements UserCategoryService
{

    @Autowired
    UserCategoryRepository userCategoryRepository;

    @Override
    public List<Category> getUserCategoriesByUserId(long userId, long parentCategoryId)
    {
        
        return userCategoryRepository.getUserCategoriesByUserId(userId, parentCategoryId);
    }

   

    

}
