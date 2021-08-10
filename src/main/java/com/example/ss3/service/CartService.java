package com.example.ss3.service;

import com.example.ss3.dto.CartDto;
import com.example.ss3.dto.CategoryDto;
import com.example.ss3.entity.CartEntity;
import com.example.ss3.entity.CategoryEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CartService {
    List<CartEntity> getAll();
    Page<CartEntity> findPaginated(int pageNo, int pageSize);
    CartEntity findByID(Integer id);
    void updateStatus(int cart_id,int status_id,String comment);
    String  add(CartDto cartDto);
    Page<CartEntity> findByUser(Integer id, int pageNo, int pageSize);
    Page<CartEntity> findByStatus(Integer id, int pageNo, int pageSize);
}
