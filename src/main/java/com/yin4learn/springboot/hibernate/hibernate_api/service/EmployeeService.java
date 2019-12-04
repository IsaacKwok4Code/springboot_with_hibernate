package com.yin4learn.springboot.hibernate.hibernate_api.service;

import java.util.List;
import com.yin4learn.springboot.hibernate.hibernate_api.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
