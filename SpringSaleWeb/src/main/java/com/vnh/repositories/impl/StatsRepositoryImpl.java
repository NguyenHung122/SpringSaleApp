///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.vnh.repositories.impl;
//
//import com.vnh.hibernatedemo.HibernateUtils;
//import com.vnh.pojo.OrderDetail;
//import com.vnh.pojo.Product;
//import com.vnh.pojo.SaleOrder;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Join;
//import jakarta.persistence.criteria.Root;
//import java.util.List;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//
///**
// *
// * @author Nguyen Hung
// */
//public class StatsRepositoryImpl {
//    public List<Object[]> getRevenueByProduct() {
//        try (Session s = HibernateUtils.getFACTORY().openSession()) {
//            CriteriaBuilder b = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> query = b.createQuery(Object[].class);
//            
//            Root root = query.from(OrderDetail.class);
//            Join<OrderDetail, Product> join = root.join("productId");
//            
//            query.select(b.array(join.get("id"), join.get("name"), b.sum(b.prod(root.get("unitPrice"), root.get("quantity")))));
//            query.groupBy(join.get("id"));
//            
//            Query q = s.createQuery(query);
//            return q.getResultList();
//        }
//    }
//    
//    public List<Object[]> getRevenueByTime(String time, int year) {
//        try (Session s = HibernateUtils.getFACTORY().openSession()) {
//            CriteriaBuilder b = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> query = b.createQuery(Object[].class);
//            
//            Root root = query.from(OrderDetail.class);
//            Join<OrderDetail, SaleOrder> join = root.join("orderId");
//            
//            query.select(b.array(b.function(time, Integer.class, join.get("createdDate")), b.sum(b.prod(root.get("unitPrice"), root.get("quantity")))));
//            query.where(b.equal(b.function("YEAR", Integer.class, join.get("createdDate")), year));
//            query.groupBy(b.function(time, Integer.class, join.get("createdDate")));
//            
//            Query q = s.createQuery(query);
//            return q.getResultList();
//        }
//    }
//}
