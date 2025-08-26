/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnh.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vnh.pojo.Product;
import com.vnh.repositories.ProductRepository;
import com.vnh.services.ProductServices;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Hung
 */
@Service
public class ProductServicesImpl implements ProductServices{
    @Autowired
    private ProductRepository proRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.proRepo.getProducts(params);
    }

    @Override
    public void deleteProduct(int id) {
        this.proRepo.deleteProduct(id);
    }

    @Override
    public Product getProductById(int id) {
        return this.proRepo.getProductById(id);
    }

    @Override
    public void addOrUpdate(Product p) {
        if (!p.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setImage((String) res.get("secure_url"));
            } catch (IOException ex) {
                p.setImage("https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg");
            }
        }
        
        this.proRepo.addOrUpdate(p);
    }
    
}
