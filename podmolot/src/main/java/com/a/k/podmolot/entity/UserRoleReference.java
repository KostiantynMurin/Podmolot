/**
 * 
 */
package com.a.k.podmolot.entity;

import org.springframework.data.relational.core.mapping.Table;

/**
* <h4>Description</h4>
* User to role reference
*
* @author kosta
*/
@Table("USER_ROLE")
public class UserRoleReference
{
    private long userId;
    
    /**
     * Conscructor
     */
    public UserRoleReference()
    {
    }
    
    public UserRoleReference(long userId)
    {
        this.userId = userId;
    }

    /**
     * @return the userId
     */
    public long getUserId()
    {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId)
    {
        this.userId = userId;
    }
    
    
}
