package com.albert.springboot.thymeleafdemo.service;

import java.util.List;

import com.albert.springboot.thymeleafdemo.entity.Employee;


public interface EmployeeService {

	public List<Employee> findAll();

	public Employee finidById(int theId);

	public Employee save(Employee theEmployee);

	public void deleteById(int theId);
	
	public List<Employee> searchBy(String theName);

}
