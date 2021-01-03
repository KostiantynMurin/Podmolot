package com.a.k.podmolot.service.interfaces;

import java.util.List;

import com.a.k.podmolot.entity.Category;

public interface UserCategoryService
{

    public List<Category> getUserCategoriesByUserId(long userId, long parentCategoryId);
    
    
}
