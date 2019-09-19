package com.avensystraining.springboot.dao;

import java.util.List;

import com.avensystraining.springboot.entity.Employee;

public interface EmployeeRepository {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void delete(int id);

}
