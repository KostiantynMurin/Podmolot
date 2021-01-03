/**
 * 
 */
package com.a.k.podmolot.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
* <h4>Description</h4>
* Role for user
*
* @a
import java.util.Optional;uthor kosta
*/
public enum Role
{
    NONE(-1),
    USER(1), 
    ADMIN(2);
    
    private static final Map<Integer, Role> ID_TO_ROLE;
    
    static
    {
        ID_TO_ROLE = new HashMap<>();
        for(Role role : Role.values())
        {
            ID_TO_ROLE.put(role.getId(), role);
        }
    }
    
    private int id;
    
    Role(int id)
    {
        this.id = id;
    }

    /**
     * Getter for id
     * 
     * @return the id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Returns Role by id
     * 
     * @param id - id of Role
     * @return Role by id
     */
    public static Role getRoleById(int id)
    {
        return Optional.ofNullable(ID_TO_ROLE.get(id)).orElse(NONE);
    }
}
