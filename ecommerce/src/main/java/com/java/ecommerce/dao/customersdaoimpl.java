package com.java.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ecommerce.model.customers;
import com.java.ecommerce.util.DBConnUtil;
import com.java.ecommerce.util.DBPropertyUtil;

public class customersdaoimpl implements customersdao {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<customers> showCustomerDao() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from Customers";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<customers> customerList = new ArrayList<customers>();
		customers customer = null;
		while(rs.next()) {
			customer = new customers();
			customer.setCustomer_id(rs.getInt("CustomerId"));
			customer.setFirstName(rs.getString("FirstName"));
			customer.setLastName(rs.getString("lastName"));
			customer.setEmail(rs.getString("email"));

			customer.setAddress(rs.getString("address"));
			customerList.add(customer);
		}
		return customerList;
	}
	@Override
	public customers searchByEmail(String email) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "SELECT * FROM Customers WHERE Email = ?";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        customers customer = null;
        if (rs.next()) {
            customer = new customers();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setFirstName(rs.getString("firstName"));
            customer.setLastName(rs.getString("lastName"));
            customer.setEmail(rs.getString("Email"));
            customer.setAddress(rs.getString("address"));
        }
        return customer;
    }
	@Override
    public List<customers> getAllCustomers() throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "SELECT * FROM Customers";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        List<customers> customersList = new ArrayList<>();
        while (rs.next()) {
            customers customer = new customers();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setFirstName(rs.getString("firstName"));
            customer.setLastName(rs.getString("lastName"));
            customer.setEmail(rs.getString("Email"));
            customer.setAddress(rs.getString("address"));
            customersList.add(customer);
        }
        return customersList;
    }
	@Override
	public customers searchByCustomerId(int custId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from customers where customer_id = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, custId);
		ResultSet rs = pst.executeQuery();
		customers customer = null;
		if(rs.next()) {
			customer = new customers();
			customer.setCustomer_id(rs.getInt("customer_id"));
			customer.setFirstName(rs.getString("FirstName"));
			customer.setLastName(rs.getString("lastName"));
			customer.setEmail(rs.getString("email"));

			customer.setAddress(rs.getString("address"));
		}
		return customer;
	}
	@Override
    public boolean exists(int customerId) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "SELECT * FROM customers WHERE customer_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, customerId);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }

}
