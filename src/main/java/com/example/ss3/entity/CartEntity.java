package com.example.ss3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "dish_id")
    private Integer dish_id;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "sum")
    private Float sum;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "comment")
    private String comment;


    @Column(name = "status_id",columnDefinition = "integer default 1")
    private Integer status_id;


    @JsonIgnore
    @ManyToOne() //EAGER
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private UserEntity user;

    @JsonIgnore
    @ManyToOne() //EAGER
    @JoinColumn(name = "dish_id", insertable = false, updatable = false)
    private DishEntity dish;

    @JsonIgnore
    @ManyToOne() //EAGER
    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    private StatusEntity status;

    public CartEntity(Integer user_id, Integer dish_id, Integer qty, Float sum, String phone, String address, String comment, Integer status_id) {
        this.user_id = user_id;
        this.dish_id = dish_id;
        this.qty = qty;
        this.sum = sum;
        this.phone = phone;
        this.address = address;
        this.comment = comment;
        this.status_id = status_id;
    }
}
