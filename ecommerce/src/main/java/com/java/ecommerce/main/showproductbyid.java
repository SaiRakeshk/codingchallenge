package com.java.ecommerce.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.ecommerce.dao.productsdao;
import com.java.ecommerce.dao.productsdaoimpl;
import com.java.ecommerce.model.products;

public class showproductbyid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID: ");
        int productId = scanner.nextInt();
        
       productsdao productsDao = new productsdaoimpl();
        
        try {
            products product = productsDao.searchByProductId(productId);
            if (product != null) {
                System.out.println("Product details:");
                System.out.println(product);
            } else {
                System.out.println("Product with ID " + productId + " not found.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

