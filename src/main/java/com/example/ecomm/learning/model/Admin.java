package com.example.ecomm.learning.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter
@Entity
public class Admin extends BaseModel{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
