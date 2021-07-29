package com.example.ss3.repository;

import com.example.ss3.entity.DishEntity;
import com.example.ss3.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DishRepo extends JpaRepository<DishEntity, Integer> {
    @Query(value = "SELECT r FROM DishEntity r  WHERE r.category.name=:category")
    public Page<DishEntity> findDishByCategory(@Param("category") String category, Pageable pageable);

//    @Query("select d from DishEntity d left join d.ingredients i WHERE i.name LIKE %:ingredient%")
//    public Page<DishEntity> findDishByIngredient(@Param("ingredient") String ingredient, Pageable pageable);
    @Query(value = "SELECT r FROM DishEntity r  WHERE r.ingredient_des LIKE %:ingredient% ")
    public Page<DishEntity> findDishByIngredient(@Param("ingredient") String ingredient, Pageable pageable);
}
