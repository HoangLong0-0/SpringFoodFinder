package com.example.ss3.service;

import com.example.ss3.entity.CategoryEntity;
import com.example.ss3.entity.DishEntity;
import com.example.ss3.entity.IngredientEntity;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface IngredientService  {
    List<IngredientEntity> getAllIngredient();

    DishEntity getDish();

    Collection<IngredientEntity> getIngredients();

    Collection<DishEntity> getDishes();

    Page<IngredientEntity> findPaginated(int pageNo, int pageSize);

    Page<IngredientEntity> findByName(String ingredient,int pageNo, int pageSize);


}
