package com.jsp.jdbc_statement_crud.service;

import java.util.List;

import com.jsp.jdbc_statement_crud.dao.CustomerDao;
import com.jsp.jdbc_statement_crud.dto.Customer;

public class CustomerService {

	CustomerDao customerDao = new CustomerDao();

	/*
	 * save method for customer in service class
	 */
	public void saveCustomer(Customer customer) {

		if ((customer.getCustomerId() > 99) && (customer.getCustomerId() < 1000)) {
			customerDao.saveCustomer(customer);
		} else {
			System.err.println("please pass your id with 3 digits only");
		}

	}

	/*
	 * getByIdMethod in Service class
	 */
	public Customer getCustomerById(int customerId) {
		return customerDao.getCustomerById(customerId);
	}

	/*
	 * deleteById method
	 */
	public void deleteById(int customerId) {

		Customer customer = getCustomerById(customerId);

		if (customer != null) {

			customerDao.deleteById(customerId);

			System.out.println("Data----Deleted---");
		} else {
			System.out.println("Idiot id is not found check once");
		}

	}

	/*
	 * updateCustomerById
	 */
	public void updateCustomerDetails(String name, int customerId) {
		
		Customer customer = getCustomerById(customerId);

		if (customer != null) {

			customerDao.updateCustomerDetails(name, customerId);

			System.out.println("Data----Updated---");
		} else {
			System.out.println("Idiot id is not found check once");
		}
	}
	
	/*
	 * 
	 */
	public List<Customer> getAllCustomer(){
		
		return customerDao.getAllCustomer();
	}

}
