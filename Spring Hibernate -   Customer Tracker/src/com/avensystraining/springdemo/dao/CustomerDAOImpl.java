package com.avensystraining.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avensystraining.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Inject hibernate session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// Execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// Return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save customer to session
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Retrieve from DB via primary key
		Customer customer = currentSession.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Delete customer via primary key
		Query<Customer> query = currentSession.createQuery("DELETE FROM Customer WHERE id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
