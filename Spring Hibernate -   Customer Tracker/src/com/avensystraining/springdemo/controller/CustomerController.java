package com.avensystraining.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avensystraining.springdemo.entity.Customer;
import com.avensystraining.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		// Get customers from service
		List<Customer> customers = customerService.getCustomers();
		
		// Add customers to model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		// Save customer using service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		// Get customer from DB
		Customer customer = customerService.getCustomer(id);
		
		// Set customer as a model attribute (to pre-populate form)
		model.addAttribute("customer", customer);
		
		// Send to form
		return "customer-form";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("customerId") int id) {
		
		// Delete customer
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
}
