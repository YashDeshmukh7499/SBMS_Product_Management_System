package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
