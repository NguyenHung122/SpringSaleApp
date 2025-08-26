/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnh.formatters;

import com.vnh.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Nguyen Hung
 */
public class CategoryFormatter implements Formatter<Category>{

    @Override
    public String print(Category c, Locale locale) {
        return String.valueOf(c.getId());
    }

    @Override
    public Category parse(String cateId, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.valueOf(cateId));
        return c;
    }
    
}
