package com.example.ss3.service;

import com.example.ss3.entity.CategoryEntity;
import com.example.ss3.entity.DishEntity;
import com.example.ss3.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Page<CategoryEntity> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.categoryRepo.findAll(pageable);
    }
}
