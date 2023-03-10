package net.javaguides.springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title")
	private String title;

	@JsonIgnore
	@OneToMany(mappedBy = "position")
	private List<Employee> employees;
	
	public Position() {}
	
	public Position(String title, List<Employee> employees) {
		this.title = title;
		this.employees = employees;
	}
	public Position(String title) {
		this.title = title;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", title=" + title + "]";
	}
	
	
	
}
