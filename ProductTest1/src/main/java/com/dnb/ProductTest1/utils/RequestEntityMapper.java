package com.dnb.ProductTest1.utils;

import org.springframework.stereotype.Component;

import com.dnb.ProductTest1.dto.Product;
import com.dnb.ProductTest1.payloadRequest.ProductRequest;

import jakarta.persistence.Entity;
@Component //allows Spring to detect our custom beans automatically
public class RequestEntityMapper {
	public Product getProductEntityObject(ProductRequest productRequest)
	{
		Product product = new Product();
		product.setProductName(productRequest.getProductName());
		product.setProductPrice(productRequest.getProductPrice());
		product.setProductDesc(productRequest.getProductDesc());
		product.setProductExpiry(productRequest.getProductExpiry());
		product.setProductCategory(productRequest.getProductCategory());
		return product;
		
	}

}
