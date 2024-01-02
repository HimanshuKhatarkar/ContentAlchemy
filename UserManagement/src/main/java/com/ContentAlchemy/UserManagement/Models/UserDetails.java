package com.ContentAlchemy.UserManagement.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="userdetails")
public class UserDetails {

    @Id
    private String id;

    private String fullName;

    private String email;

    private String password;
}
