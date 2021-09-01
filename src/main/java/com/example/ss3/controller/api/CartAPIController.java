package com.example.ss3.controller.api;

import com.example.ss3.dto.CartDto;
import com.example.ss3.dto.ItemDto;
import com.example.ss3.model.BaseResponse;
import com.example.ss3.service.CartService;
import com.example.ss3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/cart")
public class CartAPIController {
    @Autowired
    CartService cartService;
    @Autowired
    ItemService itemService;
    @GetMapping()
    public ResponseEntity getCartPage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "limit", required = false, defaultValue = "0") Integer limit) {
        BaseResponse res = new BaseResponse();
        if(limit==0){
            res.data = cartService.getAll();
        }
        else {
            res.data = cartService.findPaginated(page,limit).getContent();
        }
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CartDto cartDto){
        BaseResponse res = new BaseResponse();
        res.data = cartService.add(cartDto);
        Integer cartId = cartService.getCartId();
        Collection<ItemDto> itemDtos = cartDto.getItems();
        if(!itemDtos.isEmpty()){
            for (ItemDto itemDto : itemDtos
                 ) {
                itemDto.setCart_id(cartId);
                itemService.add(itemDto);
            }
        }
        return  ResponseEntity.ok(res);
    }

    @GetMapping("/user")
    public ResponseEntity getCartByUserPage(
            @RequestParam(value = "id", required = false, defaultValue = "6") Integer id,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "0") Integer limit) {
        BaseResponse res = new BaseResponse();
        if(limit==0){
           res.data = cartService.findAllByUser(id);
        }
        else {
            res.data = cartService.findByUser(id,page,limit).getContent();
        }

        return ResponseEntity.ok(res);
    }

    @GetMapping("/status")
    public ResponseEntity getCartByStatusPage(
            @RequestParam(value = "id", required = false, defaultValue = "1") Integer id,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "4") Integer limit) {
        BaseResponse res = new BaseResponse();
        res.data = cartService.findByStatus(id,page,limit).getContent();
        return ResponseEntity.ok(res);
    }
}
