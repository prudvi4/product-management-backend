package com.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanagement.model.Product;
import com.productmanagement.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		
		return productRepository.findById(id).get();
	}

	@Override
	public String deleteProdcut(Integer id) {
		Product product=productRepository.findById(id).get();
		if(product != null) {
			productRepository.delete(product);
			return "Product Delete Successfully";
		}
		return "Something wrong on server";
	}

	@Override
	public Product editProduct(Product product, Integer id) {
		Product oldproduct=productRepository.findById(id).get();
		oldproduct.setProductName(product.getProductName());
		oldproduct.setDescription(product.getDescription());
		oldproduct.setPrice(product.getPrice());
		oldproduct.setStatus(product.getStatus());
		return productRepository.save(oldproduct);
	}

}
