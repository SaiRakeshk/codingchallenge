package com.java.ecommerce.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.ecommerce.dao.customersdao;
import com.java.ecommerce.dao.customersdaoimpl;
import com.java.ecommerce.model.customers;

public class searchbymailid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Email: ");
        String email = sc.nextLine();
        
        customersdao dao = new customersdaoimpl();
        try {
            customers customer = dao.searchByEmail(email);
            if (customer != null) {
                System.out.println(customer);
            } else {
                System.out.println("Customer not found for email: " + email);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
