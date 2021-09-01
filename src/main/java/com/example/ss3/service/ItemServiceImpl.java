package com.example.ss3.service;

import com.example.ss3.dto.ItemDto;
import com.example.ss3.entity.ItemEntity;
import com.example.ss3.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo itemRepo;

    @Override
    public List<ItemEntity> getAll() {
        return itemRepo.findAll();
    }

    @Override
    public Page<ItemEntity> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.itemRepo.findAll(pageable);
    }

    @Override
    public ItemEntity findByID(Integer id) {
        return itemRepo.findById(id).get();
    }

    @Override
    public void add(ItemDto itemDto) {
        ItemEntity itemEntity = new ItemEntity(itemDto.getQuantity(),
                itemDto.getProduct_id(), itemDto.getCart_id());
        itemRepo.save(itemEntity);
    }

    @Override
    public ItemEntity save(ItemDto itemDto) {
        ItemEntity itemEntity = findByID(itemDto.getId());
        itemEntity.setQuantity(itemDto.getQuantity());
        return itemRepo.save(itemEntity);
    }

    @Override
    public void delete(Integer id) {
        ItemEntity itemEntity = findByID(id);
        if(itemEntity !=null)
            itemRepo.delete(itemEntity);

    }
}
