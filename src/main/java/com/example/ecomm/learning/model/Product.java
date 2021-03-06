package com.example.ecomm.learning.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String name;
    private Float price;
    private String description;
    private String image;
    //private int categoryId;
    @ManyToOne
    private Admin admin;

    @ManyToOne
    private User user;
}
