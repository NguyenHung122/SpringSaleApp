/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vnh.repositories;

import com.vnh.pojo.User;

/**
 *
 * @author Nguyen Hung
 */
public interface UserRepository {
    public User getUserByUsername(String username);
    User addUser(User u);
}
