package com.example.ss3.controller.api;

import com.example.ss3.model.BaseResponse;
import com.example.ss3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemAPIController {
    @Autowired
    ItemService itemService;
    @GetMapping()
    public ResponseEntity getOrdersById(@RequestParam(value = "id", required = true) Integer id) {
        BaseResponse res = new BaseResponse();
        res.data = itemService.findByID(id);
        return ResponseEntity.ok(res);
    }

}
