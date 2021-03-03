package com.example.ecomm.learning.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseModel{
    @ManyToOne()
    private Customer customer;
    @OneToMany
    private List<Product> product;
    private Double price;
    private Integer quantity;
}
