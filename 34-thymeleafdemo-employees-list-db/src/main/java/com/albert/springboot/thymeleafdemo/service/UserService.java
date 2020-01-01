package com.albert.springboot.thymeleafdemo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.albert.springboot.thymeleafdemo.entity.CrmUser;
import com.albert.springboot.thymeleafdemo.entity.User;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
