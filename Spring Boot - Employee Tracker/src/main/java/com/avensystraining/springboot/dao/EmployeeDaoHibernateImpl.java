package com.avensystraining.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avensystraining.springboot.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeRepository {

	private EntityManager em;

	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Employee> findAll() {
		
		Session currentSession = em.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Session currentSession = em.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		Session currentSession = em.unwrap(Session.class);

		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		
		Session currentSession = em.unwrap(Session.class);
		Query query = currentSession.createQuery("DELETE FROM Employee WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
