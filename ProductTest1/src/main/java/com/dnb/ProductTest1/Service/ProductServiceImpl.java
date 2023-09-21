package com.dnb.ProductTest1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.ProductTest1.Repository.ProductRepo;
import com.dnb.ProductTest1.dto.Product;
import com.dnb.ProductTest1.exceptions.UniqueNameException;
@Service //@Service annotation is used with classes that provide some business functionalities
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductRepo productRepo;
	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public Optional<Product> getProductById(String productId) {
		// TODO Auto-generated method stub
		return productRepo.findById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return  (List<Product>) productRepo.findAll();
	}
    @Override
	public Boolean deleteProduct(String productId) {
		// TODO Auto-generated method stub
				if(productRepo.existsById(productId)==true) {
					 productRepo.deleteById(productId);
					 return true;
				}
				else
					return false;
	}



//	@Override
//	public Product updateProduct(String productId, Product newupdateProduct) throws UniqueNameException {
//		// TODO Auto-generated method stub
//		Product presentexistingProduct = productRepo.findById(productId).orElseThrow();
//		if(!presentexistingProduct.getProductName().equals(newupdateProduct.getProductName())) {
//			if(productRepo.findByProductName(newupdateProduct.getProductName()).isPresent()) {
//				throw new UniqueNameException("Product Name must be unique");
//			}
//		}
//		newupdateProduct.setProductId(productId);
//		return productRepo.save(newupdateProduct);	
//	}
    
    
    
    
    
    
    
    
	}


