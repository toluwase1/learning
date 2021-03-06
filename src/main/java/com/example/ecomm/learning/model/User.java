package com.example.ecomm.learning.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;
}
