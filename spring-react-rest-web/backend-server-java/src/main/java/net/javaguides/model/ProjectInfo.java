package net.javaguides.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_info")
public class ProjectInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="proj_info_id")
	private Long id;

	private int budget;
	
	@Column(name = "task_description")
	private String taskDescription;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name= "end_date")
	private Date endDate;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "proj_info_id")
	private Project project; //what projects info is this
	
	public ProjectInfo() {}	
	
	public ProjectInfo(int budget, String taskDescription, Date startDate, Date endDate, Project project) {
		this.budget = budget;
		this.taskDescription = taskDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.project = project;
	}



	public ProjectInfo(int budget, String taskDescription, Date startDate, Date endDate) {
		this.budget = budget;
		this.taskDescription = taskDescription;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "ProjectInfo [budget=" + budget + ", taskDescription=" + taskDescription + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
}
