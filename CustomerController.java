package com.jsp.jdbc_statement_crud.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.jsp.jdbc_statement_crud.dao.CustomerDao;
import com.jsp.jdbc_statement_crud.dto.Customer;
import com.jsp.jdbc_statement_crud.service.CustomerService;

public class CustomerController {

	public static void main(String[] args) {

		Customer customer = new Customer();

		CustomerService customerService = new CustomerService();
		
		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("1.Insert\n2.getOneData\n3.DeleteById\n4.UpdateData\n5.getAllData");
			System.out.println("enter your choice");

			int ch = scanner.nextInt();

			switch (ch) {

			case 1: {
					System.out.println("enter customerId");
					int id = scanner.nextInt();
					customer.setCustomerId(id);
					
					System.out.println("enter customerName");
					String name = scanner.next();
					customer.setCustomerName(name);
					
					System.out.println("enter customerEmail");
					String email = scanner.next();
					customer.setCustomerEmail(email);
					
					customerService.saveCustomer(customer);
					
			}
				break;
				
			case 2:{
				System.out.println("enter customerId");
				int id = scanner.nextInt();
				
				Customer customer1=customerService.getCustomerById(id);
				
				if(customer1!=null) {
					
					System.out.println("id = "+customer1.getCustomerId());
					System.out.println("name = "+customer1.getCustomerName());
					System.out.println("email = "+customer1.getCustomerEmail());
				}else {
					System.out.println("Given Id is not found....");
				}
			
			}break;
			
			case 3:{
				System.out.println("enter customerId to delete");
				int id = scanner.nextInt();
				customerService.deleteById(id);
			}break;
			
			case 4:{
				System.out.println("enter customerId to update customerName");
				int id = scanner.nextInt();
				
				System.out.println("enter new customerName");
				String name = scanner.next();
				
				customerService.updateCustomerDetails(name, id);
				
			}break;
			
			case 5:{
				
				
				int i=0;
				FileWriter fileWriter = null;
				for (Customer customer1: customerService.getAllCustomer()) {
					try {
						if(i==0) {
							fileWriter = new FileWriter("D:/software/MyData.doc");
							i++;
						}
						PrintWriter printWriter = new PrintWriter(fileWriter);
						printWriter.println(customer1.getCustomerId()+"\t"+customer1.getCustomerName()+"\t"+customer1.getCustomerEmail());
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}break;
			
			}

		}
	}
}
