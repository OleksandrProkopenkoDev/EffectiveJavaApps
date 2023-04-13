package com.spro.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_categories")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_category_id")
	private Long id;
	private String categoryName;
	private String categoryDescription;
	
	@OneToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.DETACH
			}, fetch = FetchType.LAZY,
			mappedBy = "category")
	private List<Product> products = new ArrayList<>();

	public ProductCategory() {}
	
	public ProductCategory(String categoryName, String categoryDescription) {
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public ProductCategory(String categoryName, String categoryDescription, List<Product> products) {
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.products = products;
	}

	@Override
	public String toString() {
		StringBuilder prodIds= new StringBuilder();
		products.forEach(p->prodIds.append(p.getId().toString() +", ") ); 
		
		return "ProductCategory [id=" + id + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", products Ids=" +prodIds+ "]";
	}
	
	
}
