package com.spro.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@Table(name = "products", schema = "ecommerce", uniqueConstraints = {
		@UniqueConstraint(name = "sku_unique", columnNames = { "stock_keeping_unit" }) })

@NamedQueries({ 
		@NamedQuery(name = "Product.findAllOrderByNameDesc", 
					query = "select p from Product p order by p.name desc"),
		
		@NamedQuery(name = "Product.findAllOrderBySkuDesc", 
					query = "select p from Product p order by p.sku desc"),
		
		@NamedQuery(name = "Product.findAllOrderByPriceAsc", 
					query = "select p from Product p order by p.price asc"),
		
		@NamedQuery(name = "Product.findBySku", 
					query = "select p from Product p where p.sku = :sku"),
		
		@NamedQuery(name = "Product.findByPrice", 
					query = "select p from Product p where p.price = ?1")

})
@NamedNativeQueries({
	@NamedNativeQuery(name="Product.findByCreationDate",
	query="select * from products p where p.date_created like ?1",
	resultClass = Product.class),
	
	@NamedNativeQuery(name="Product.findAllOrderByAsc",
	query="select * from products order by date_created asc ",
	resultClass = Product.class)
})

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "product_generator", sequenceName = "product_sequence_name", allocationSize = 1)
	private Long id;

	@Column(name = "stock_keeping_unit", nullable = false)
	private String sku; // stockKeepingUnit

	@Column(nullable = false)
	private String name;
	private String description;
	private BigDecimal price;
	private String imageUrl;
	private boolean active;

	@CreationTimestamp // automatic populate value for this stamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp // automatic populate value for this stamp
	private LocalDateTime lastUpdated;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_category_id", 
	referencedColumnName = "prod_category_id")
	private ProductCategory category;
	
	
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", description=" + description + ", price="
				+ price + ", imageUrl=" + imageUrl + ", active=" + active + ", dateCreated=" + dateCreated
				+ ", lastUpdated=" + lastUpdated + " ProductCategory [id=" + category.getId() + ", categoryName=" + 
				category.getCategoryName() + ", categoryDescription="
						+ category.getCategoryDescription() + "] ]";
	}



	
}
