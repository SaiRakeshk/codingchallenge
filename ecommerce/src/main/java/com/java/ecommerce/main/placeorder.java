package com.java.ecommerce.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.ecommerce.dao.orderdetailsdao;
import com.java.ecommerce.dao.orderdetailsdaoimpl;

public class placeorder {

    public static void main(String[] args) {
        int custId, productId, quantityOrd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Id  ");
        custId = sc.nextInt();
        System.out.println("Enter Product Id  ");
        productId = sc.nextInt();
        System.out.println("Enter Quantity Ordered  ");
        quantityOrd = sc.nextInt();
        orderdetailsdao dao = new orderdetailsdaoimpl();
        try {
            System.out.println(dao.placeOrder(custId, productId, quantityOrd));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
