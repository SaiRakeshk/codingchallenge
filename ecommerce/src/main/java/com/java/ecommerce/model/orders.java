package com.java.ecommerce.model;

import java.sql.Date;

public class orders {
    private int order_id;
    private int customer_id;
    private Date order_date;
    private double total_amount;
    private String shipping_address;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public orders(int order_id, int customer_id, Date order_date, double total_amount, String shipping_address) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.order_date = order_date;
		this.total_amount = total_amount;
		this.shipping_address = shipping_address;
	}
	public orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "orders [order_id=" + order_id + ", customer_id=" + customer_id + ", total_amount=" + total_amount
				+ ", shipping_address=" + shipping_address + "]";
	}
}