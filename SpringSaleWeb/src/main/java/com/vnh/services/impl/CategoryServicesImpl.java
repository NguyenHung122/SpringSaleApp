/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnh.services.impl;

import com.vnh.pojo.Category;
import com.vnh.repositories.CategoryRepository;
import com.vnh.services.CategoryServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Hung
 */
@Service
public class CategoryServicesImpl implements CategoryServices{
    @Autowired
    private CategoryRepository cateRepo;
    @Override
    public List<Category> getCates() {
        return this.cateRepo.getCates();
    }
}
