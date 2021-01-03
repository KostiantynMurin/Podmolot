/**
 * 
 */
package com.a.k.podmolot.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

/**
* <h4>Description</h4>
* Role entity
* 
* @author kosta
*/
@Table("ROLE")
public class UserRole
{
    @Id
    private long id;
    
    private String name;
    
    @MappedCollection(idColumn = "ROLE_ID")
    private Set<UserRoleReference> users = new HashSet<UserRoleReference>();
    
    /**
     * Constructor
     */
    public UserRole()
    {
    }

    /**
     * Constructor
     * 
     * @param name - name of role
     */
    public UserRole(String name)
    {
        this.name = name;
    }

    /**
     * @return the id
     */
    public long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the users
     */
    public Set<UserRoleReference> getUsers()
    {
        return users;
    }
    
    public void addUser(User user)
    {
        users.add(new UserRoleReference(user.getId()));
    }
}
