package com.a.k.podmolot.repository;

import java.util.Objects;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.a.k.podmolot.entity.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest
{
    @Autowired
    private CategoryRepository categoryRepository;

    /*
     * @Test public void contextLoads() { Category parentCategory = new Category();
     * parentCategory.setName("Category 1"); for (int i = 1; i < 10; i++) { Category
     * childCategory = new Category(); childCategory.setName("Child Category " + i);
     * parentCategory.addChildCategory(childCategory);
     * 
     * } categoryRepository.save(parentCategory);
     * 
     * Assert.assertTrue(Objects.nonNull(parentCategory) &&
     * categoryRepository.existsById(parentCategory.getId()));
     * categoryRepository.delete(parentCategory); }
     */
    /*
     * @Test public void newCategory() { Category category = new Category();
     * 
     * category.setName("hjvjh88888"); categoryRepository.save(category);
     * 
     * }
     */

}
