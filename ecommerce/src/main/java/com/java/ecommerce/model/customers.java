package com.java.ecommerce.model;


public class customers {
    private int customer_id;
    private String firstName;
    private String lastName;
    private String Email;
    private String address;

    
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public customers(int customer_id, String firstName, String lastName, String email, String address) {
		super();
		this.customer_id = customer_id;
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
		this.address = address;
	}
	public customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "customers [customer_id=" + customer_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", Email=" + Email + ", address=" + address + "]";
	}
	
}