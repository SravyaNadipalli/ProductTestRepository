package com.dnb.ProductTest1.Service;

import java.util.List;
import java.util.Optional;

import com.dnb.ProductTest1.dto.Product;
import com.dnb.ProductTest1.exceptions.UniqueNameException;

import jakarta.validation.Valid;

public interface ProductService {
	public  Product createProduct(Product product);
	public  Optional<Product> getProductById(String productId) ;
	public  List<Product> getAllProducts();
	public   Boolean deleteProduct(String productId);
	
}
