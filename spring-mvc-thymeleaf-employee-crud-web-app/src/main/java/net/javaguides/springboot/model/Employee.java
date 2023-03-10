package net.javaguides.springboot.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="employees_crud")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="dob")
	private Date dob; //date of birth
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "position_id", referencedColumnName = "id")
	private Position position;
	
	public Employee() {}
	
	public Employee(String firstName, Date dob, Position position) {
		this.firstName = firstName;
		this.dob = dob;
		this.position = position;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", dob=" + dob + ", position=" + position.getTitle() + "]";
	}

	
	
	

	
	
}
