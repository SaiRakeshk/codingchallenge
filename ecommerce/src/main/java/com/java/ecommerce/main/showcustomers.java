package com.java.ecommerce.main;

import java.sql.SQLException;
import java.util.List;

import com.java.ecommerce.dao.customersdao;
import com.java.ecommerce.dao.customersdaoimpl;
import com.java.ecommerce.model.customers;

public class showcustomers {

    public static void main(String[] args) {
        customersdao dao = new customersdaoimpl();
        try {
            List<customers> customersList = dao.getAllCustomers();
            if (!customersList.isEmpty()) {
                System.out.println("List of Customers:");
                for (customers customer : customersList) {
                    System.out.println(customer);
                }
            } else {
                System.out.println("*** No Customers Found ***");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
