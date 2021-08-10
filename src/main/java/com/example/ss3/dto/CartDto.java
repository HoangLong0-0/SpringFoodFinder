package com.example.ss3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private Integer id;

    @NotNull
    private Integer user_id;

    @NotNull
    private Integer dish_id;


    @NotNull
    private Integer qty;


    private Float sum;

    @NotNull
    private String phone;


    @NotNull
    private String address;


    private String comment;


    private Integer status_id = 1;

    public CartDto(@NotNull Integer user_id, @NotNull Integer dish_id, @NotNull Integer qty, Float sum, @NotNull String phone, @NotNull String address, String comment, Integer status_id) {
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
