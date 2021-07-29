package com.example.ss3.service;

import com.example.ss3.entity.CategoryEntity;
import com.example.ss3.entity.DishEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAll();
    Page<CategoryEntity> findPaginated(int pageNo, int pageSize);
}
