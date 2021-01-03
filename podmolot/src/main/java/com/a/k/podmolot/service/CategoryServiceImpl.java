package com.a.k.podmolot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.k.podmolot.entity.Category;
import com.a.k.podmolot.repository.CategoryRepository;
import com.a.k.podmolot.service.interfaces.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService
{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> getParentCategory()
    {

        return categoryRepository.getParrent();
    }

    @Override
    public List<Category> getChildCategory(long parentCategoryId)
    {
        return categoryRepository.getChildren(parentCategoryId);
    }

    @Override
    public List<Category> getUserParentCategory(long userId)
    {
        return categoryRepository.getUserParrentCategory(userId);
    }

}
