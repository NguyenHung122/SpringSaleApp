package com.vnh.repositories.impl;


import com.vnh.hibernatedemo.HibernateUtils;
import com.vnh.pojo.Product;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {
    public List<Product> getProducts(Map<String, String> params) {
        try(Session s = HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> query = b.createQuery(Product.class);
            Root root = query.from(Product.class);
            query.select(root);
            
            
            if (params!= null) {
                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()) {
                    query.where(b.like(root.get("name"), String.format("%%%s%%" ,kw)));
                }
                
            }
            
            
            Query q = s.createQuery(query);
            return q.getResultList();
        }
    }
}
