package com.spro.entity.onoToOneUnidirectional;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Entity
@Table(name="orders")
public class UniOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private Long id;
	private String orderTrackingNumber;
	private int totalQuantity;
	private BigDecimal totalPrice;
	private String status;
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	@OneToOne(cascade = {
			CascadeType.PERSIST, 
			CascadeType.REMOVE,
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.DETACH
			})
	@JoinColumn(name="billing_address_id", referencedColumnName = "address_id")
	private UniAddress billingAddress;

	public UniOrder() {}
	
	public UniOrder(String orderTrackingNumber, int totalQuantity, BigDecimal totalPrice, String status,
			UniAddress billingAddress) {
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.billingAddress = billingAddress;
	}
	
	
}
