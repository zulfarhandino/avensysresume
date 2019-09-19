package com.avensystraining.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avensystraining.springboot.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeRepository {
	
	private EntityManager em;
	
	@Autowired
	public EmployeeDaoJpaImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Employee> findAll() {

		Query query = em.createQuery("FROM Employee");
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Employee employee = em.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		Employee e = em.merge(employee);
		employee.setId(e.getId());

	}

	@Override
	public void delete(int id) {
		
		Query query = em.createQuery("DELETE FROM Employee WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

}
