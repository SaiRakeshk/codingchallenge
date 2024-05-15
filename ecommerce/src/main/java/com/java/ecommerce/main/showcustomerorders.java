package com.java.ecommerce.main;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.ecommerce.dao.ordersdao;
import com.java.ecommerce.dao.ordersdaoimpl;
import com.java.ecommerce.model.orders;

public class showcustomerorders {

	public static void main(String[] args) {
		int custId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Id  ");
		custId = sc.nextInt();
		ordersdao dao = new ordersdaoimpl();
		try {
			List<orders> ordersList = dao.showCustomerOrders(custId);
			for (orders orders : ordersList) {
				System.out.println(orders);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
