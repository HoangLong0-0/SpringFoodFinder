package com.example.ss3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private Integer id;

    @NotNull
    private Integer user_id;

    @NotNull
    private String phone;


    public Collection<ItemDto> items;

    @NotNull
    private String address;


    private String comment;


    private Integer status_id = 1;

    public CartDto(@NotNull Integer user_id, @NotNull Integer dish_id, @NotNull Integer qty, Float sum, @NotNull String phone, @NotNull String address, String comment, Integer status_id) {
        this.user_id = user_id;
        this.phone = phone;
        this.address = address;
        this.comment = comment;
        this.status_id = status_id;
    }

    public CartDto(@NotNull Integer user_id, @NotNull String phone, Collection<ItemDto> items, @NotNull String address, String comment, Integer status_id) {
        this.user_id = user_id;
        this.phone = phone;
        this.items = items;
        this.address = address;
        this.comment = comment;
        this.status_id = status_id;
    }
}
