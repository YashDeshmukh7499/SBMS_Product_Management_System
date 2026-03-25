 package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.entity.Product;
import com.yash.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	
	@GetMapping({"/","/product"})
	public String productForm(Model model) {
		
		Product product=new  Product();
		
		model.addAttribute("prod", product);
		
		
		return "product-form";
	}
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("prod") @Valid Product product,BindingResult bindingResult, Model model) {
//		System.err.println(product);
		if(bindingResult.hasErrors()) {
			
			return "product-form";
		}
		String msg = productService.saveProduct(product);
		model.addAttribute("msg", msg);
		model.addAttribute("prod", product);
		return "product-form";
	}
	@GetMapping("/products")
	public String AllProduct(Model model) {
		List<Product> getallproduct = productService.getallproduct();
		model.addAttribute("products", getallproduct);
		return "products";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("id") int id,Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		
		model.addAttribute("prod", product);
		return "product-form";
		
	}
	
	@GetMapping("/delete")
		public String delete(@RequestParam("id") int id, Model model) {
		
		productService.deletebyId(id);
		
		
		return "redirect:/products";
	}

}
