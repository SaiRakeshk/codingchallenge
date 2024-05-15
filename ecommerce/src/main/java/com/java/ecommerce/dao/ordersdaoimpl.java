package com.java.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ecommerce.model.customers;
import com.java.ecommerce.model.orders;
import com.java.ecommerce.util.DBConnUtil;
import com.java.ecommerce.util.DBPropertyUtil;

public class ordersdaoimpl implements ordersdao {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<orders> showCustomerOrders(int custId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from Orders where customer_id = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, custId);
		ResultSet rs = pst.executeQuery();
		List<orders> ordersList = new ArrayList<orders>();
		orders order = null;
		while(rs.next()) {
			order = new orders();
			order.setCustomer_id(rs.getInt("customer_id"));
			order.setOrder_id(rs.getInt("order_id"));
			order.setOrder_date(rs.getDate("order_date"));
			order.setTotal_amount(rs.getDouble("total_amount"));
			ordersList.add(order);
		}
		return ordersList;
	}
	@Override
    public String placeOrder(int customerId, int productId, int quantityOrdered)
            throws ClassNotFoundException, SQLException {
        try {
            
            String connStr = DBPropertyUtil.connectionString("db");
            connection = DBConnUtil.getConnection(connStr);

            
            String checkCmd = "SELECT stockQuantity FROM products WHERE product_id = ?";
            pst = connection.prepareStatement(checkCmd);
            pst.setInt(1, productId);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                return "Product with ID " + productId + " does not exist.";
            }
            int stockQuantity = rs.getInt("stockQuantity");
            if (quantityOrdered > stockQuantity) {
                return "Insufficient stock for product with ID " + productId + ".";
            }

            
            String cmd = "INSERT INTO orders (customer_id, order_date, total_amount, shipping_address) VALUES (?, CURRENT_DATE(), ?, ?)";
            pst = connection.prepareStatement(cmd);
            pst.setInt(1, customerId);
            double totalAmount = getProductPrice(productId) * quantityOrdered;
            pst.setDouble(2, totalAmount);
            pst.setString(3, getCustomerAddress(customerId));
            pst.executeUpdate();

            
            int remainingStock = stockQuantity - quantityOrdered;
            String updateCmd = "UPDATE products SET stockQuantity = ? WHERE product_id = ?";
            pst = connection.prepareStatement(updateCmd);
            pst.setInt(1, remainingStock);
            pst.setInt(2, productId);
            pst.executeUpdate();

            return "Order placed successfully!";
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            if (pst != null) {
                pst.close();
            }
        }
    }

    private double getProductPrice(int productId) throws SQLException {
        
        String cmd = "SELECT price FROM products WHERE product_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, productId);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getDouble("price");
    }

    private String getCustomerAddress(int customerId) throws SQLException {
        
        String cmd = "SELECT address FROM customers WHERE customer_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, customerId);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getString("address");
    }
}

