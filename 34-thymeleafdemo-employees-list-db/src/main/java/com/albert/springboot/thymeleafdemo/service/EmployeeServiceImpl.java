package com.albert.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albert.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.albert.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = employeeRepository.findAllByOrderByLastNameAsc();
		return employees;
	}

	@Override
	public Employee finidById(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
			return theEmployee;
		} else {
			// didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
	}

	@Override
	public Employee save(Employee theEmployee) {
		Employee employeeDB = employeeRepository.save(theEmployee);

		return employeeDB;

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

	@Override
	public List<Employee> searchBy(String theName) {
		List<Employee> results = null;

		if (theName != null && (theName.trim().length() > 0)) {
			results = employeeRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
		} else {
			results = findAll();
		}

		return results;
	}

}
