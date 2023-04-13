package com.spro.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private Long id;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="fk_order_id", referencedColumnName = "order_id")
	private Order order;
	
	public Address() {}
	
	public Address(String street, String city, String state, String country, String zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zipCode=" + zipCode + "]";
	}
	
	
}
