package com.a.k.podmolot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.a.k.podmolot.entity.Category;
import com.a.k.podmolot.entity.User;
import com.a.k.podmolot.entity.UserCategoryReference;
import com.a.k.podmolot.repository.CategoryRepository;
import com.a.k.podmolot.repository.UserRepository;
import com.a.k.podmolot.repository.UserRoleRepository;
import com.a.k.podmolot.service.interfaces.CategoryService;
import com.a.k.podmolot.service.interfaces.SecurityService;
import com.a.k.podmolot.service.interfaces.UserCategoryService;
import com.a.k.podmolot.service.interfaces.UserService;
import com.a.k.podmolot.utils.Pages;

@Controller
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserCategoryService userCategoryService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/user/profile")
    public String userSettingsPage(Model model, @AuthenticationPrincipal UserDetails currentUser)
    {
        model.addAttribute("user", userRepository.findByEmail(currentUser.getUsername()));
        // return null;
        return "userSettings";
    }

    @GetMapping("/user/profile/portfolio")
    public String userSettingsPagePortfolio(Model model, @AuthenticationPrincipal UserDetails currentUser)
    {
        model.addAttribute("user", userRepository.findByEmail(currentUser.getUsername()));
        // return null;
        return "portfolio";
    }

    @GetMapping("/user/profile/userCategory")
    public String userSettingsPageCategories(Model model, @AuthenticationPrincipal UserDetails currentUser)
    {
        User user = userRepository.findByEmail(currentUser.getUsername());
        model.addAttribute("user", user);

        // Список категорий и подкатегорий
        Map<Category, List<Category>> map = new HashMap<>();
        for (Category parentCategory : categoryService.getParentCategory())
        {
            map.put(parentCategory, (categoryService).getChildCategory(parentCategory.getId()));
        }
        model.addAttribute("categoryes", map);

        // user.addCategory(category);
        // Список категорий на которые подписан пользователь
        Map<Category, List<Category>> myCategories = new HashMap<>();
        for (Category parentCategory : categoryService
                .getUserParentCategory(userRepository.findByEmail(currentUser.getUsername()).getId()))
        {

            myCategories.put(parentCategory, userCategoryService.getUserCategoriesByUserId(
                    userRepository.findByEmail(currentUser.getUsername()).getId(), parentCategory.getId()));
        }
        model.addAttribute("myCategories", myCategories);
        return "userCategory";
    }

    @PostMapping("/user/profile/save")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateUserProfile(@ModelAttribute("user") User user, @AuthenticationPrincipal UserDetails currentUser)
    {
        userService.updateUserByEmail(user, currentUser);
        return "redirect:/user/profile";

    }
      // рабочий контроллер добавление кнопкой
    /*
     * @PostMapping("/user/profile/userCategory") public String
     * updateUserCategories(@ModelAttribute("user") User user,
     * 
     * @AuthenticationPrincipal UserDetails currentUser,
     * 
     * @RequestParam(value = "checkboxcategories", required = false) long[]
     * categoriesIds) { System.out.println("Контроллер начал работу"); user =
     * userRepository.findByEmail(currentUser.getUsername()); if (categoriesIds !=
     * null) { // UserCategoryReference categoryReference = null; for (int i = 0; i
     * < categoriesIds.length; i++) { // categoryReference = new
     * UserCategoryReference(categoriesIds[i]);
     * user.addCategory(categoryRepository.getCategoryById(categoriesIds[i]));
     * userRepository.save(user); System.out.println("юзеру" + user.getFirstName() +
     * "добавлена категория" + categoriesIds[i]);
     * System.out.println(categoryRepository.getCategoryById(categoriesIds[i])); } }
     * else { System.out.println("sdcksjndkcjskjzdjk66556456456"); } return
     * "redirect:/user/profile/userCategory"; }
     */
    @PostMapping("/user/profile/userCategory")
    public String updateUserCategories(@ModelAttribute("user") User user,
            @AuthenticationPrincipal UserDetails currentUser,
           // @RequestParam(value = "checkboxcategories", required = false) long[] categoriesIds,
            @RequestBody long categoriesIds)
    {
        System.out.println("Контроллер начал работу" + categoriesIds);
        user = userRepository.findByEmail(currentUser.getUsername());
        
            // UserCategoryReference categoryReference = null;
            
                // categoryReference = new UserCategoryReference(categoriesIds[i]);
                user.addCategory(categoryRepository.getCategoryById(categoriesIds));
                userRepository.save(user);
                System.out.println("юзеру" + user.getFirstName() + "добавлена категория" + categoriesIds);
                System.out.println(categoryRepository.getCategoryById(categoriesIds));
            
        
        return "userCategory";
    }
}
