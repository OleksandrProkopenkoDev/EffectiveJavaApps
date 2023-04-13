package com.spro.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "users",
	   uniqueConstraints = @UniqueConstraint(
			   name = "unique_email",
			   columnNames = "email")	)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name = "users_roles",
				joinColumns = @JoinColumn(name = "user_id", 
				referencedColumnName = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id",
				referencedColumnName = "role_id")
			)
	private Set<Role> roles = new HashSet<>();
	
}

/* This is ManyToMany unidirectional mapping
 * On Role's side nothing.
 * 
 * 
 * 	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	@JoinTable(name = "users_roles",
				joinColumns = @JoinColumn(name = "user_id", 
				referencedColumnName = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id",
				referencedColumnName = "role_id")
			)
	private Set<Role> roles = new HashSet<>();
 * 
 * 
 * 
 * 
 */
