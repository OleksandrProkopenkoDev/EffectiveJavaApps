package net.javaguides.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_id")
	private Long id;
	private String title;
	
	@JsonIgnore
	@OneToOne(mappedBy = "project",cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private ProjectInfo projectInfo;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="employees_projects",
			joinColumns = @JoinColumn(name = "proj_id"),
			inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private Set<Employee> employees = new HashSet<>();
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	private Client client;
	
	public Project() {}
	
	public Project(String title) {
		this.title = title;
	}
	public Project(String title, ProjectInfo projectInfo, Set<Employee> employees, Client client) {
		this.title = title;
		this.projectInfo = projectInfo;
		this.employees = employees;
		this.client = client;
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
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Project \n[title=" + title + ",\n " + projectInfo + ",\n employees=" + employees + ",\n "
				+ client + "]";
	}
	
	
}
