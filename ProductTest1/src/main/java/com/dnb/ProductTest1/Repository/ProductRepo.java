package com.dnb.ProductTest1.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.ProductTest1.dto.Product;

public interface ProductRepo extends CrudRepository<Product, String>{
	
	public Optional<Product> findByProductName(String productId);

}