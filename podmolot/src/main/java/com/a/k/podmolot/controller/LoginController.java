/**
 * 
 */
package com.a.k.podmolot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a.k.podmolot.entity.Role;
import com.a.k.podmolot.entity.User;
import com.a.k.podmolot.entity.UserRole;
import com.a.k.podmolot.repository.UserRepository;
import com.a.k.podmolot.repository.UserRoleRepository;
import com.a.k.podmolot.service.interfaces.SecurityService;
import com.a.k.podmolot.utils.Pages;

/**
* <h4>Description</h4>
*
* @author kosta
*/
@Controller
public class LoginController
{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private UserRoleRepository userRoleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @GetMapping("/user/login")
    public String loginPage()
    {
        return Pages.LOGIN.getPageName();
    }
    
    @GetMapping("/user/registry")
    public String registryPage(Model model)
    {
        model.addAttribute("userForm", new User());
        return Pages.REGISTRY.getPageName();
    }
    
    @PostMapping("/user/registry/save")
    public ModelAndView registryNewUser(@ModelAttribute("userForm") User userForm, ModelMap modelMap)
    {
        userForm.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        userRepository.save(userForm);
        UserRole role = Optional.ofNullable(userRoleRepository.findByName(Role.USER.toString())).orElse(new UserRole(Role.USER.toString()));
        role.addUser(userForm);
        userRoleRepository.save(role);
        securityService.autoLogin(userForm.getEmail(), userForm.getPasswordCopy());
        return new ModelAndView("redirect:/home", modelMap);
    }
}
