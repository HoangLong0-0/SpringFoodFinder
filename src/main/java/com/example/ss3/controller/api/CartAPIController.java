package com.example.ss3.controller.api;

import com.example.ss3.dto.CartDto;
import com.example.ss3.model.BaseResponse;
import com.example.ss3.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartAPIController {
    @Autowired
    CartService cartService;
    @GetMapping()
    public ResponseEntity getCartPage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "limit", required = false, defaultValue = "4") Integer limit) {
        BaseResponse res = new BaseResponse();
        res.data = cartService.findPaginated(page,limit).getContent();
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CartDto cartDto){
        BaseResponse res = new BaseResponse();
        res.data = cartService.add(cartDto);
        return  ResponseEntity.ok(res);

    }

    @GetMapping("/user")
    public ResponseEntity getCartByUserPage(
            @RequestParam(value = "id", required = false, defaultValue = "5") Integer id,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "4") Integer limit) {
        BaseResponse res = new BaseResponse();
        res.data = cartService.findByUser(id,page,limit).getContent();
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
