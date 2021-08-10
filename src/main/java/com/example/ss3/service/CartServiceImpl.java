package com.example.ss3.service;

import com.example.ss3.dto.CartDto;
import com.example.ss3.entity.CartEntity;
import com.example.ss3.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepo cartRepo;

    @Override
    public List<CartEntity> getAll() {
        return cartRepo.findAll();
    }

    @Override
    public Page<CartEntity> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.cartRepo.findAll(pageable);
    }

    @Override
    public CartEntity findByID(Integer id) {
        return cartRepo.findById(id).get();
    }

    @Override
    public void updateStatus(int cart_id,int status_id,String comment) {
        CartEntity cart = findByID(cart_id);
        cart.setStatus_id(status_id);
        cart.setComment(comment);
        cartRepo.save(cart);
    }

    @Override
    public String add(CartDto cartDto) {
        CartEntity cartEntity = new CartEntity(
                cartDto.getUser_id(),cartDto.getDish_id(),cartDto.getQty(),cartDto.getSum(),
                cartDto.getPhone(),cartDto.getAddress(),cartDto.getComment(),cartDto.getStatus_id()
        );
        cartRepo.save(cartEntity);
        return "Add successfully";
    }

    @Override
    public Page<CartEntity> findByUser(Integer id, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return cartRepo.findCartByUser(id,pageable);
    }

    @Override
    public Page<CartEntity> findByStatus(Integer id, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return cartRepo.findByStatus_id(id,pageable);
    }
}
