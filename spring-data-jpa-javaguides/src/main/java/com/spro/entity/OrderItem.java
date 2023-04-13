package com.spro.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_item_id")
	private Long id;
	private String imageUrl;
	private BigDecimal price = new BigDecimal(0.00);
	private int quantity = 1;
	
	@OneToOne
	@JoinColumn(name = "fk_product_id")
	private Product product;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_order_id", referencedColumnName = "order_id")
	private Order order;
	
	public OrderItem() {}
	
	public OrderItem(String imageUrl, BigDecimal price, int quantity, Product product) {
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
		this.product = product;
	}

	public OrderItem(String imageUrl, BigDecimal price, int quantity) {
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
	}
	public OrderItem(String imageUrl, int quantity) {
		this.imageUrl = imageUrl;
		this.quantity = quantity;
	}
	public OrderItem(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void calculateAndSetPrice() {
		BigDecimal totalPrice = new BigDecimal(0.00);
		if(product !=null)
			totalPrice =
					product.getPrice().multiply(new BigDecimal(quantity));
		setPrice(totalPrice);
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", imageUrl=" + imageUrl + ", price=" + price + ", quantity=" + quantity
				+ ", product=" + product + "]";
	}
	
	
}
