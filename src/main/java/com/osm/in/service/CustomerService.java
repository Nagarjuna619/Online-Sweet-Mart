package com.osm.in.service;

import java.util.List;

import com.osm.in.entity.Customer;



public interface CustomerService {
	
    public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer cancelCustomer(long customerId);
	
	public List<Customer> showAllCustomers();

	public Customer showAllcustomers(long customerId);
	
	
	

}
