package com.a.k.podmolot.exception;

public class ProfileNotFoundException extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final long userId;
    
    
    
    public ProfileNotFoundException(long id) {
        this.userId = id;
      
    }
    
    
    
    @Override
    public String getMessage() {
        return "Profile with id = " + userId + " not found";
    }
}
