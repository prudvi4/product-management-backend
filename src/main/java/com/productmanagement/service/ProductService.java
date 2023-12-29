package com.productmanagement.service;

import java.util.List;

import com.productmanagement.model.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(Integer id);
	
	public String deleteProdcut(Integer id);
	
	public Product editProduct(Product product,Integer id);
}
