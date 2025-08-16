/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnh.controllers;

import com.vnh.repositories.impl.CategoryRepositoryImpl;
import com.vnh.repositories.impl.ProductRepositoryImpl;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen Hung
 */
@Controller
public class IndexController {
    
    @Autowired
    private CategoryRepositoryImpl cateRepo;
    @Autowired
    private ProductRepositoryImpl prodRepo;
    
      @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        
        model.addAttribute("categories", cateRepo.getCates());
        model.addAttribute("products", prodRepo.getProducts(params));
        return "index";
    }
}
