package com.ContentAlchemy.UserManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ContentAlchemy.UserManagement.Models.UserDetails;

@Repository
public interface UserRepository extends MongoRepository<UserDetails,String>{

    public boolean existsByEmail(String email);
    // You can add custom queries or methods here if needed

}
