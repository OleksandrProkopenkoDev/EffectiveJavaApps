package com.spro.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(
		name = "products", 
		schema = "ecommerce",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "sku_unique", 
						columnNames = { "stock_keeping_unit" })
		}
		)
public class Product {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "product_generator")
	@SequenceGenerator(
			name = "product_generator",
			sequenceName = "product_sequence_name",
			allocationSize = 1
			)
	private Long id;
	
	@Column(name = "stock_keeping_unit", nullable = false)
	private String sku; // stockKeepingUnit
	
	@Column(nullable = false)
	private String name;
	private String description;
	private BigDecimal price;
	private String imageUrl;
	private boolean active;
	
	@CreationTimestamp //automatic populate value for this stamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp  //automatic populate value for this stamp
	private LocalDateTime lastUpdated;

	public Product() {
	}

	
	
	public Product(String name, String sku) {
		this.name = name;
		this.sku = sku;
	}



	public Product(String sku, String name, String description, BigDecimal price, String imageUrl,
			LocalDateTime dateCreated, LocalDateTime lastUpdated) {
		super();
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
	}

	

}
