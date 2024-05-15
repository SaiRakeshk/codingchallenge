package com.java.ecommerce.main;
 
import java.sql.SQLException; 
import java.util.Scanner; 
import com.java.ecommerce.dao.customersdao; 
import com.java.ecommerce.dao.customersdaoimpl;
public class authentication 
{ 
	public static void main(String[] args) { 
		String Email, password; 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter Email "); 
		Email = sc.next(); 
		System.out.println("Enter Password "); 
		password = sc.next(); 
		customersdao c = new customersdaoimpl(); 
		try 
		{ 
			int count = c.authenticateCustomer(Email, password); 
			if (count==1) 
			{ System.out.println("Correct Credentials..."); 
			} 
			else 
			{ 
				System.out.println("Invalid Credentials..."); 
				} 
			} catch (ClassNotFoundException | SQLException e) 
		{ // TODO Auto-generated catch block 
				e.printStackTrace(); } } 
		
	}
		