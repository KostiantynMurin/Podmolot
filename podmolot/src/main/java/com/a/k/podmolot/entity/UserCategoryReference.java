package com.a.k.podmolot.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("user_category")
public class UserCategoryReference
{
    
    private Long categoryId;
    //private String name;

    public UserCategoryReference(Long categoryId/* , String name */)
    {
        this.categoryId = categoryId;
        //this.name = name;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }

    /*
     * public void setUser(Long user) { this.categoryId = categoryId; }
     */

    /*
     * public String getName() { return name; }
     * 
     * public void setName(String name) { this.name = name; }
     */
    
    

}
