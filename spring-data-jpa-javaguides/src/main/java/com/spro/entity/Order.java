package com.spro.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private Long id;
	private String orderTrackingNumber;
	private int totalQuantity = 0;
	private BigDecimal totalPrice = new BigDecimal(0.00);
	private String status = "New order";
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	//default fetch type for one-to-one mapping is Eager
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
	private Address billingAddress;
	
	//default fetch type for one to many is Lazy
	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER,
			mappedBy = "order")
	private Set<OrderItem> orderItems = new HashSet<>();

	public Order() {}
	
	public Order(String orderTrackingNumber, int totalQuantity, BigDecimal totalPrice, String status,
			Address billingAddress, Set<OrderItem> orderItems) {
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.billingAddress = billingAddress;
		this.orderItems = orderItems;
	}
	
	public Order(String orderTrackingNumber, int totalQuantity, BigDecimal totalPrice, String status,
			Address billingAddress) {
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.billingAddress = billingAddress;
	}
	
	public Order(String orderTrackingNumber, int totalQuantity, BigDecimal totalPrice, String status) {
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		
	}
	
	public Order(String orderTrackingNumber, String status) {
		this.orderTrackingNumber = orderTrackingNumber;
		this.status = status;	
	}

	public void calculateAndSetTotalPrice() {
		calculateAndSetTotalQuantity();
		BigDecimal total = new BigDecimal(0.00);
		
			for (OrderItem item : orderItems) {
				if(item.getProduct()!=null)
					if(item.getProduct().getPrice()!=null)
						total = total.add(
								item.getProduct().getPrice().multiply(
										new BigDecimal(totalQuantity))
						);
			}
		
		setTotalPrice(total);
	}

	public void calculateAndSetTotalQuantity() {
		int total = 0;
		for (OrderItem item : orderItems) {
			total = total + item.getQuantity();
		}
		setTotalQuantity(total);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", \norderTrackingNumber=" + orderTrackingNumber + ", \ntotalQuantity=" + totalQuantity
				+ ", \ntotalPrice=" + totalPrice + ", \nstatus=" + status + ", \ndateCreated=" + dateCreated
				+ ", \nlastUpdated=" + lastUpdated + ", \nbillingAddress=" + billingAddress + ", \norderItems=" + orderItems
				+ "]";
	}


	


}


/*
 * this is one to many unidirectional mapping. In orderItem class nothing.
 * 	//default fetch type for one to many is Lazy
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_order_id", referencedColumnName = "order_id")
	private Set<OrderItem> orderItems = new HashSet<>();
 * 
 * 
 * 
 * 
 */
