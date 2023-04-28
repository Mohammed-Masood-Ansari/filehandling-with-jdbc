package com.jsp.jdbc_statement_crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.jdbc_statement_crud.dto.Customer;
import com.mysql.cj.jdbc.Driver;

/*
 * 
 * @author Mo Masood Ansari
 *
 */
public class CustomerDao {

	/*
	 * save method for customer
	 */
	public void saveCustomer(Customer customer) {

		Connection connection = null;

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbc-njja12";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String insertCustomerQuery = "insert into customer values" + "(" + customer.getCustomerId() + ",'"
					+ customer.getCustomerName() + "','" + customer.getCustomerEmail() + "')";

			statement.execute(insertCustomerQuery);

			System.out.println("...Data-Stored...");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * getByIdMethod
	 */

	public Customer getCustomerById(int customerId) {

		Connection connection = null;

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbc-njja12";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String selectQuery = "SELECT * FROM customer WHERE id=" + customerId;

			ResultSet resultSet = statement.executeQuery(selectQuery);

			if (resultSet.next()) {

				Customer customer = new Customer();

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");

				customer.setCustomerId(id);
				customer.setCustomerName(name);
				customer.setCustomerEmail(email);

				return customer;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * deleteById method
	 */
	public void deleteById(int customerId) {

		Connection connection = null;

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbc-njja12";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String deleteQuery = "DELETE FROM customer where id=" + customerId;

			statement.executeUpdate(deleteQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * updateCustomerById
	 */
	public void updateCustomerDetails(String name, int customerId) {
		Connection connection = null;

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbc-njja12";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String updateQuery = "UPDATE customer  set name = '"+name+"' WHERE id=" + customerId;

			statement.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 */
	public List<Customer> getAllCustomer(){
	
		Connection connection = null;

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbc-njja12";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String selectQuery = "SELECT * FROM customer";

			List<Customer> customers = new ArrayList<Customer>();
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				
				Customer customer = new Customer();
				
				customer.setCustomerId(resultSet.getInt("id"));
				customer.setCustomerName(resultSet.getString("name"));
				customer.setCustomerEmail(resultSet.getString("email"));
				
				customers.add(customer);
			}
			
			return customers;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
