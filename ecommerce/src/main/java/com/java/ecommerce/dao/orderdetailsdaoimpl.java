package com.java.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ecommerce.model.orderdetails;
import com.java.ecommerce.model.products;
import com.java.ecommerce.util.DBConnUtil;
import com.java.ecommerce.util.DBPropertyUtil;

public class orderdetailsdaoimpl implements orderdetailsdao {

    Connection connection;
    PreparedStatement pst;
    
    
    public int generateOrderId() throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "SELECT MAX(order_id) + 1 AS mid FROM orders";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        rs.next();
        int oid = rs.getInt("mid");
        return oid;
    }
    
    public int generateOrderDetailsId() throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "SELECT MAX(orderDetailsId) + 1 AS mid FROM order_details";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        rs.next();
        int oid = rs.getInt("mid");
        return oid;    
    }
    
    @Override
    public List<orderdetails> showCustomerOrderDetails(int custId) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "SELECT * FROM order_items WHERE order_id IN "
                + " (SELECT order_id FROM orders WHERE customer_id=?)";

        pst = connection.prepareStatement(cmd);
        pst.setInt(1, custId);
        ResultSet rs = pst.executeQuery();
        List<orderdetails> listOrderDetails = new ArrayList<orderdetails>();
        orderdetails orderDetails = null;
        while(rs.next()) {
            orderDetails = new orderdetails();
            orderDetails.setOrder_id(rs.getInt("order_id"));
            orderDetails.setProduct_id(rs.getInt("productId"));
            orderDetails.setQuantity(rs.getInt("quantity"));
            listOrderDetails.add(orderDetails);
        }
        return listOrderDetails;
    }

    @Override
    public String placeOrder(int custId,int productId, int quantityOrdered) throws ClassNotFoundException, SQLException {
        productsdao dao = new productsdaoimpl();
        products products = dao.searchByProductId(productId);
        double price = products.getPrice();
        double billAmount = quantityOrdered * price;
        int orderId = generateOrderId();
        int orderDetailsId = generateOrderDetailsId();
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "INSERT INTO order_items(order_item_id, order_id, product_id, "
                + "quantity, item_amount) VALUES(?,?,?,?,?)";

        pst = connection.prepareStatement(cmd);
        pst.setInt(1, orderId);
        pst.setInt(2, custId);
        pst.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
        pst.setDouble(4, billAmount);
        pst.executeUpdate();
        cmd = "INSERT INTO orders( order_id, product_id, "
                + "quantity) VALUES(?,?,?,?)";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, orderDetailsId);
        pst.setInt(2, orderId);
        pst.setInt(3, productId);
        pst.setInt(4, quantityOrdered);
        pst.executeUpdate();
        return "Order Placed Successfully. BillAmount Calculated.";
    }

}
