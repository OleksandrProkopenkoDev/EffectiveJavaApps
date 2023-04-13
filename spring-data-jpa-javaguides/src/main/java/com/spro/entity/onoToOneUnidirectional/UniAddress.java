package com.spro.entity.onoToOneUnidirectional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Entity
@Table(name="addresses")
public class UniAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private Long id;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	public UniAddress() {}
	
	public UniAddress(String street, String city, String state, String country, String zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	
	
}
