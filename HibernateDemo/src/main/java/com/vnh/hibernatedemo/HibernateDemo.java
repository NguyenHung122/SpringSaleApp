/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.vnh.hibernatedemo;

import com.vnh.repositories.impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s = new CategoryReprositoryImpl();
//        s.getCates().forEach(c -> System.out.println(c.getName()));
          ProductRepositoryImpl p = new ProductRepositoryImpl();
          Map<String, String> params = new HashMap<>();
          params.put("kw", "galaxy");
          p.getProducts(params).forEach(s -> System.out.println(s.getName()));
    }
}
