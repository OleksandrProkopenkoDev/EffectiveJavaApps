package net.javaguides.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Long id;
	private String name;
	
	@JsonIgnore
	@OneToOne(mappedBy = "client",cascade =  CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ContactInfo contactInfo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private Set<Project> projects = new HashSet<>();
	
	public Client() {}
		
	public Client(String name) {
		this.name = name;
	}

	public Client(String name, ContactInfo contactInfo) {
		this.name = name;
		this.contactInfo = contactInfo;
	}

	public Client(String name, ContactInfo contactInfo, Set<Project> projects) {
		this.name = name;
		this.contactInfo = contactInfo;
		this.projects = projects;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", contactInfo=" + contactInfo + "]";
	}
	
	
}
