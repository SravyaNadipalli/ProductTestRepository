package com.dnb.ProductTest1.payloadRequest;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data

public class ProductRequest {
	
	@NotBlank(message = "Product description must be filled")//@not blank used to specify that field mus not be null
	private String productDesc;
	private LocalDate productExpiry;
	private String productName;
	@Min(message = "price should not be negative", value = 0)
	private float productPrice;
	private String productCategory;
}
