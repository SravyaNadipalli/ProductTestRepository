package com.dnb.ProductTest1.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.ProductTest1.utils.CustomIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //1) It generates the getter methods for all the fields. 2)@Data is a convenient shortcut annotation that bundles the features of @ToString , @EqualsAndHashCode , @Getter / @Setter together.
@Entity // @Entity annotation defines that a class can be mapped to a table


public class Product {  
	@Id //indicating the member field below is the primary key of the current entity
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")// @GeneratedVaue provides for the specification of generation strategies for the values of primary keys 
	@GenericGenerator(name = "product_seq", strategy = "com.dnb.ProductTest1.utils.CustomIdGenerator", //@GenericGenerator annotation is  used to denote a custom generator, which can be a class.
	parameters = { @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"), 
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROD_"), 
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String productId;
	@Column (unique = true)//used for Adding the column  name in the table and here we says that productName must be unique 
	private String productName;
	private String productDesc;
	private LocalDate productExpiry;
	@NotNull //elements cannot be null
	@Min(value = 0,message="price should not be negative")//specifying that producprice should no t be negative
	private float productPrice;
	private String productCategory;
	
	

}
