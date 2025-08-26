/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vnh.services;

import com.vnh.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Nguyen Hung
 */
public interface UserServices extends UserDetailsService{
    User getUserByUsername(String username);
}
