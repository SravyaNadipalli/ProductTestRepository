package com.dnb.ProductTest1.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.ProductTest1.Repository.ProductRepo;
import com.dnb.ProductTest1.Service.ProductService;
import com.dnb.ProductTest1.dto.Product;
import com.dnb.ProductTest1.exceptions.IdNotFoundException;
import com.dnb.ProductTest1.exceptions.UniqueNameException;
import com.dnb.ProductTest1.payloadRequest.ProductRequest;
import com.dnb.ProductTest1.utils.RequestEntityMapper;

import jakarta.validation.Valid;

@RestController // @RestContoller is both @Controller and @ResponseBody--- @RestController annotation can be used to return JSON response
@RequestMapping("/api/product") //used to map HTTP requests to handler methods of MVC and REST controllers
public class ProductController 
{
	@Autowired  //This annotation automatically creates the object
	RequestEntityMapper mapper;
	@Autowired
	ProductService productService;
	@Autowired
	ProductRepo productRepo;
	

	@PostMapping("/create") //used to create product
	public ResponseEntity<?> createProduct (@Valid @RequestBody Product product) throws IdNotFoundException{
	//Product product2=mapper.getProductEntityObject(product);
	   Product product3 = productService.createProduct(product);
		return new ResponseEntity(product3,HttpStatus.CREATED); // for response  we use this ResponseEntitymethod
	}
	
	
	@DeleteMapping("/{productId}")//Deleting the record by selection productId in product
	 public ResponseEntity<?> deleteaccount (@PathVariable("accountId") String accountId) throws IdNotFoundException{
		if(productService.deleteProduct(accountId))
		{
			return ResponseEntity.noContent().build();
		}
			else
			{
				throw new IdNotFoundException("id not found");
			}
		}

	
	
	@GetMapping("/all")//retrieving all products
	public ResponseEntity<?> getAllProducts(){
		Iterable<Product> optional= productService.getAllProducts();
		 return ResponseEntity.ok(optional);
	}
	
	
	
	@GetMapping("/{productId}")//retrieving product details by Id
		public ResponseEntity<?> getProductById(@PathVariable("productId") String productId) throws IdNotFoundException
				{
			Optional<Product> optional = productService.getProductById(productId);
			if (optional.isPresent()) {
				return ResponseEntity.ok(optional.get());
			} else {
				throw new IdNotFoundException("Mentioned product id not found");
			}
		}
	

	
	@PutMapping("/update-product/{productId}")//this method allows us to update the product details by productId
		public ResponseEntity<String> updateProductName(@PathVariable("productId") String productId,
				@RequestBody ProductRequest product1) {
			Optional<Product> productOptional = productRepo.findById(productId);
			if (productOptional.isPresent()) {
				Product product = productOptional.get();
				// Check if the new name is unique among existing products
				Optional<Product> optional = productRepo.findByProductName(product1.getProductName());
				System.out.println(optional.isPresent());
				if (!optional.isPresent()) {
					product.setProductName(product1.getProductName());
					product.setProductDesc(product1.getProductDesc());
					product.setProductCategory(product1.getProductCategory());
					product.setProductPrice(product1.getProductPrice());
					product.setProductExpiry(product1.getProductExpiry());
					productRepo.save(product); // Save the updated product to the database
					return ResponseEntity.ok("Product Name Updated: " + product1.getProductName());
				} else {
					return ResponseEntity.badRequest().body("Product name must be unique.");
				}
			} else {
				return ResponseEntity.notFound().build();
			}
		}
}

