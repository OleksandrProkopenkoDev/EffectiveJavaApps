package net.javaguides.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="employee_id")
	private Long id;
	
	@Column(name = "employee_name")
	private String name;

	@Column(name = "offer_date")
	private Date offerDate;

	private int salary;
	
	@JsonIgnore //this solves recursive reference problem
	@ManyToMany(mappedBy = "employees")
	private Set<Project> projects = new HashSet<>(); // what projects works this employee
	
	public Employee() {}
	
	
	
	public Employee(String name, Date offerDate, int salary, Set<Project> projects) {
		this.name = name;
		this.offerDate = offerDate;
		this.salary = salary;
		this.projects = projects;
	}



	public Employee(String name, Date offerDate, int salary) {
		this.name = name;
		this.offerDate = offerDate;
		this.salary = salary;
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
	public Date getOfferDate() {
		return offerDate;
	}
	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}



	@Override
	public String toString() {
		return "Employee [name=" + name + ", offerDate=" + offerDate + ", salary=" + salary + "]";
	}
	
	
}
