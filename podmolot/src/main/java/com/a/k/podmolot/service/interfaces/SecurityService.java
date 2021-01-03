/**
 * 
 */
package com.a.k.podmolot.service.interfaces;

/**
* <h4>Description</h4>
*
* @author kosta
*/
public interface SecurityService
{
    /**
     * Auto login of User
     * 
     * @param email - email of User
     * @param rawPassword - clear User password, NOT encoded 
     */
    void autoLogin(String email, String rawPassword);
}
