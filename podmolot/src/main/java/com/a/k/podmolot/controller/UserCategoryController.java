package com.a.k.podmolot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.a.k.podmolot.service.interfaces.UserCategoryService;
import com.a.k.podmolot.service.interfaces.UserService;

@Controller
@RequestMapping
public class UserCategoryController
{
    @Autowired
    private UserCategoryService userCategoryService;
    
    @Autowired
    private UserService userService;
    
    

}
