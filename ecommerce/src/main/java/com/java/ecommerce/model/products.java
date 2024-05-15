package com.java.ecommerce.model;

public class products {
    private int product_id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    
    
  

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


public products(int product_id, String name, String description, double price, int stockQuantity) {
    this.product_id = product_id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.stockQuantity = stockQuantity;
}

public products() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
    return "products [product_id=" + product_id + ", name=" + name + ", description=" + description + ", price="
            + price + ", stockQuantity=" + stockQuantity + "]";
}
}
