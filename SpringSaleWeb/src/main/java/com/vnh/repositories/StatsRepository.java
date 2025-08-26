/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vnh.repositories;

import java.util.List;

/**
 *
 * @author Nguyen Hung
 */
public interface StatsRepository {
    List<Object[]> getRevenueByProduct();
    List<Object[]> getRevenueByTime(String time, int year);
}
