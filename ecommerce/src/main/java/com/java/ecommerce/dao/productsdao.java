package com.java.ecommerce.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecommerce.model.products;

public interface productsdao {
	List<products> showProductsDao() throws ClassNotFoundException, SQLException;
	List<products> getAllProducts() throws ClassNotFoundException, SQLException;
    products searchByProductId(int productId) throws ClassNotFoundException, SQLException;
}