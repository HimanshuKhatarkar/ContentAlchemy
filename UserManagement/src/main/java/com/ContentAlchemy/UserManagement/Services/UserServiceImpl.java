package com.ContentAlchemy.UserManagement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ContentAlchemy.UserManagement.Models.UserDetails;
import com.ContentAlchemy.UserManagement.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    

    @Override
    public UserDetails createUser(UserDetails user) {
        try {
            return userRepo.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to SignUp");
        }
    }


    @Override
    public boolean checkEmail(String email) {
        return userRepo.existsByEmail(email);
        
    }
    

}
