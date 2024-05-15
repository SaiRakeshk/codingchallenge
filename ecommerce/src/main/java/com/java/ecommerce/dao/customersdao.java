package com.java.ecommerce.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecommerce.model.customers;

public interface customersdao {

	List<customers> showCustomerDao() throws ClassNotFoundException, SQLException;
	customers searchByCustomerId(int custId) throws ClassNotFoundException, SQLException;
	List<customers> getAllCustomers() throws ClassNotFoundException, SQLException;
	public customers searchByEmail(String email) throws ClassNotFoundException, SQLException;
	boolean exists(int customerId) throws ClassNotFoundException, SQLException;
	int authenticateCustomer(String Email,String password) throws ClassNotFoundException, SQLException;
	void updatingpwd(String password,String Email) throws ClassNotFoundException, SQLException;
}

