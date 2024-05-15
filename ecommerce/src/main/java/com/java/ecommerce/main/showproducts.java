package com.java.ecommerce.main;

import java.sql.SQLException;
import java.util.List;

import com.java.ecommerce.dao.productsdao;
import com.java.ecommerce.dao.productsdaoimpl;
import com.java.ecommerce.model.products;

public class showproducts {

    public static void main(String[] args) {
        productsdao productsDao = new productsdaoimpl();
        
        try {
            List<products> productList = productsDao.showProductsDao();
            if (productList.isEmpty()) {
                System.out.println("No products available.");
            } else {
                System.out.println("List of all products:");
                for (products product : productList) {
                    System.out.println(product);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
