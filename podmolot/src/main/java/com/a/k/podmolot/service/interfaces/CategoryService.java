package com.a.k.podmolot.service.interfaces;

import java.util.List;

import com.a.k.podmolot.entity.Category;

public interface CategoryService
{
    public Iterable<Category> getParentCategory();
    
    public List<Category> getChildCategory(long id);
    
    public List<Category> getUserParentCategory(long userId);
}
