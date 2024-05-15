package com.java.ecommerce.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecommerce.model.orderdetails;

public interface orderdetailsdao {
	List<orderdetails> showCustomerOrderDetails(int custId) throws ClassNotFoundException, SQLException;
	String placeOrder(int custId,int productId, int quantityOrderd) throws ClassNotFoundException, SQLException;
}