package com.ContentAlchemy.UserManagement.Services;


import com.ContentAlchemy.UserManagement.Models.UserDetails;

public interface UserService {
    public UserDetails createUser(UserDetails user);

    public boolean checkEmail(String email);
    
    
}
