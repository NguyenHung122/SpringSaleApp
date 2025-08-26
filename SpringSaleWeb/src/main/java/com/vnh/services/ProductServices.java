/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vnh.services;

import com.vnh.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nguyen Hung
 */
public interface ProductServices {

    List<Product> getProducts(Map<String, String> params);

    void deleteProduct(int id);

    Product getProductById(int id);

    void addOrUpdate(Product p);
}
