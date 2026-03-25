package com.yash.service;

import java.util.List;

import com.yash.entity.Product;

public interface ProductService {
	
	public String saveProduct(Product product);
	
	 List<Product> getallproduct();
	 
	 Product findById(int id);
	 
	public void deletebyId(int id);

	

}
