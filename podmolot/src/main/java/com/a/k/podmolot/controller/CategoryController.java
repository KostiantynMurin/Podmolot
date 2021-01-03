package com.a.k.podmolot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a.k.podmolot.entity.Category;
import com.a.k.podmolot.repository.CategoryRepository;
import com.a.k.podmolot.service.interfaces.CategoryService;

@Controller
@RequestMapping
public class CategoryController
{

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    /*
     * @RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET) public
     * String Categories(ModelMap modelMap) { modelMap.put("categories",
     * categoryService.getParentCategory()); return "home"; }
     * 
     * @ResponseBody
     * 
     * @RequestMapping(value = "childCategory/{id}", method = RequestMethod.GET)
     * public String childCategory(@PathVariable("id") long id) { Gson gson = new
     * Gson(); return gson.toJson(categoryService.getChildCategory(id));
     * 
     * }
     */

    @RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
    public String getParentCategories(Model model)
    {
        Map<Category, List<Category>> map = new HashMap<>();
        for (Category parentCategory : categoryService.getParentCategory())
        {
            map.put(parentCategory, (categoryService).getChildCategory(parentCategory.getId()));
        }
        model.addAttribute("categoryes", map);
        return "home";
    }

    @RequestMapping("/test/1")
    public String getChildCategories(Model model)
    {
        model.addAttribute("categoryes", categoryRepository.getParrent());
        model.addAttribute("childCategoryes", categoryRepository.getChildren(1L));
        return "test";
    }

    @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.GET)
    public @ResponseBody List<Category> getAllChildCategories(@PathVariable("parentCategoryId") long parentCategoryId)
    {
        Category category = new Category();
        return categoryRepository.getChildren(category.getId());
    }
    
    

}
