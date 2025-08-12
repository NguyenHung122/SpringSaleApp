/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.vnh.hibernatedemo;

import com.vnh.pojo.Product;
import com.vnh.repositories.impl.CategoryRepositoryImpl;
import com.vnh.repositories.impl.ProductRepositoryImpl;
import com.vnh.repositories.impl.StatsRepositoryImpl;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
        CategoryRepositoryImpl s2 = new CategoryRepositoryImpl();
//        s2.getCates().forEach(c -> System.out.println(c.getName()));

        ProductRepositoryImpl s = new ProductRepositoryImpl();
        
//        Map<String, String> params = new HashMap<>();
//        params.put("orderBy", "price");
//        params.put("page", "2");
//        s.getProducts(params).forEach(p -> System.out.printf("%s - %.1f\n", p.getName(), p.getPrice()));

        Product p = new Product();
        p.setName("ABC");
        p.setPrice(123l);
        p.setCategoryId(s2.getCateById(1));
        
        s.addOrUpdate(p);

//        StatsRepositoryImpl s3 = new StatsRepositoryImpl();
//        s3.getRevenueByTime("QUARTER", 2020).forEach(o -> System.out.printf("%d: %d\n", o[0], o[1]));
    }
}
