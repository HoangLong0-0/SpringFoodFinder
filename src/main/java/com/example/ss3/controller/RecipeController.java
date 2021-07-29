package com.example.ss3.controller;

import com.example.ss3.entity.CategoryEntity;
import com.example.ss3.entity.RecipeEntity;
import com.example.ss3.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    @GetMapping
    public String index(Model model) {
        List<RecipeEntity> productList = recipeService.getAll();
        model.addAttribute("productList", productList);
        return findPaginated(1, model);
    }

    @GetMapping("/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<RecipeEntity> page = recipeService.findPaginated(pageNo, pageSize);
        List< RecipeEntity > listProducts = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("productList", listProducts);
        return "/recipe/list";
    }
}
