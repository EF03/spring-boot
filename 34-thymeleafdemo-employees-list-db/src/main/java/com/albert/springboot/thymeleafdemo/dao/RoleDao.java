package com.albert.springboot.thymeleafdemo.dao;

import com.albert.springboot.thymeleafdemo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
