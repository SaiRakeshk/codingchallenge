package com.java.ecommerce.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecommerce.model.orders;

public interface ordersdao {
	String placeOrder(int customerId, int productId, int quantityOrdered) throws ClassNotFoundException, SQLException;
	List<orders> showCustomerOrders(int custId) throws ClassNotFoundException, SQLException;
}