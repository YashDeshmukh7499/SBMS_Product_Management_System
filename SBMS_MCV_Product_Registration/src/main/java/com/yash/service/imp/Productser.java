package com.yash.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.entity.Product;
import com.yash.repository.ProductRepo;
import com.yash.service.ProductService;
@Service
public class Productser implements ProductService {

	@Autowired
	ProductRepo productRepo;
	@Override
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		productRepo.save(product);
		return "Student save Successfully";
	}
	@Override
	public List<Product> getallproduct() {
		
		return productRepo.findAll();
	}
	@Override
	public Product findById(int id) {
		Product product=null;
		Optional<Product> byId = productRepo.findById(id);
		
		if(byId.isPresent()) {
			 product = byId.get();
		}
		return product;
	}
	@Override
	public void deletebyId(int id) {
		
		productRepo.deleteById(id);
		
	}

}
