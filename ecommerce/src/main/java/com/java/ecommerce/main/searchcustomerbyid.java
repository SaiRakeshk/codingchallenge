package com.java.ecommerce.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.ecommerce.dao.customersdao;
import com.java.ecommerce.dao.customersdaoimpl;
import com.java.ecommerce.model.customers;

public class searchcustomerbyid {

    public static void main(String[] args) {
        int custId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Id: ");
        custId = sc.nextInt();
        
        customersdao dao = new customersdaoimpl();
        
        try {
            customers customer = dao.searchByCustomerId(custId);
            if (customer != null) {
                System.out.println(customer);
            } else {
                System.out.println("*** Customer Record Not Found ***");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        sc.close();
    }
}
