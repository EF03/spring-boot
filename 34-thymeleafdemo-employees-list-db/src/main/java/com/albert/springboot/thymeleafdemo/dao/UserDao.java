package com.albert.springboot.thymeleafdemo.dao;

import com.albert.springboot.thymeleafdemo.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
}
