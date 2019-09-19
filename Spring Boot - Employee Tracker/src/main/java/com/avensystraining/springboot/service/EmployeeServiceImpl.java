package com.avensystraining.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avensystraining.springboot.dao.EmployeeRepository;
import com.avensystraining.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeDao;
	
	public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl") EmployeeRepository employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDao.delete(id);
	}
	
}
