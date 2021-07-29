package com.example.ss3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    private Integer id;

    private String name;

    private String description;

    private Integer category_id;
}
