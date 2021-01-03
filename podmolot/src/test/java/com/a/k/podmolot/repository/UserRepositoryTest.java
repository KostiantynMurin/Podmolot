/**
 * 
 */
package com.a.k.podmolot.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.a.k.podmolot.entity.Category;
import com.a.k.podmolot.entity.User;
import com.a.k.podmolot.entity.UserRole;

/**
* <h4>Description</h4>
* Test for {@link UserRepository}
*
* @author kosta
*/
@SpringBootTest
public class UserRepositoryTest
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private UserRoleRepository userRoleRepository;
    
    @Test
    public void testCRUDOperations()
    {
        User user = userRepository.save(defaultUser());
        Assert.assertTrue(Objects.nonNull(user) && userRepository.existsById(user.getId()));
        userRepository.delete(user);
    }
    
    @Test
    public void testUserRoleReference()
    {
        User user = userRepository.save(defaultUser());
        UserRole userRole = new UserRole("Some ROLE");
        userRole.addUser(user);
        userRoleRepository.save(userRole);
        Assert.assertTrue(Objects.nonNull(userRole) && userRoleRepository.existsById(userRole.getId()));
        userRepository.delete(user);
        userRoleRepository.delete(userRole);
    }
    
    
    @Test
    public void testFindUserByMail()
    {
        User user = userRepository.save(defaultUser());
        user = userRepository.findByEmail(user.getEmail());
        Assert.assertTrue(Objects.nonNull(user) && userRepository.existsById(user.getId()));
        userRepository.delete(user);
    }
    
    @Test
    public void testFindRolesByUserId()
    {
        User user = userRepository.save(defaultUser());
        List<UserRole> roles = Arrays.asList(new UserRole("Some ROLE1"), new UserRole("Some ROLE2"));
        roles.forEach(role -> {
            role.addUser(user);
            userRoleRepository.save(role);
        });
        Set<UserRole> userRoles = userRoleRepository.findByUserId(user.getId());
        Assert.assertTrue(Objects.nonNull(userRoles) && !userRoles.isEmpty() && userRoles.size() == roles.size());
        userRepository.delete(user);
        userRoleRepository.deleteAll(userRoles);
    }
    
    private User defaultUser()
    {
        User user = new User();
        user.setFirstName("Kosta");
        user.setMiddleName("Murin");
        user.setLastName("Olegovich");
        user.setPassword("I am Grud");
        user.setEmail("Some mail");
        user.setPhoneNumber("Some phone number");
        return user;
    }
    
    @Test
    public void testAddCategoryToUser() {
        User user = userRepository.save(defaultUser());
        Category category = new Category();
        category.setName("hjvjh88888");
        categoryRepository.save(category);
        user.addCategory(category);
        userRepository.save(user);
        userRepository.delete(user);
        categoryRepository.delete(category);
    }
}
