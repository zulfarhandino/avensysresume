package com.avensystraining.springboot.service;

import java.util.List;

import com.avensystraining.springboot.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void delete(int id);

}
