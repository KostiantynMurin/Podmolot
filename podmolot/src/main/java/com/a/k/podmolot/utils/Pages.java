/**
 * 
 */
package com.a.k.podmolot.utils;

/**
* <h4>Description</h4>
* Static names for pages
* 
* @author kosta
*/
public enum Pages
{
    LOGIN("login"), 
    REGISTRY("registry");
    
    private String pageName;
    
    Pages(String pageName)
    {
        this.pageName = pageName;
    }

    /**
     * @return the pageName
     */
    public String getPageName()
    {
        return pageName;
    }
}
