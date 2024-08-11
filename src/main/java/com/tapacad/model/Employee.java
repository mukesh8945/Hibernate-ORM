package com.tapacad.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table (name="employee")
public class Employee {
	@Id
	@Column(name ="id")
	private int id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name="email")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY,
			               cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.
			               PERSIST,CascadeType.REFRESH})
	
	@JoinTable(name = "employee_project",joinColumns = @JoinColumn(name="emp_id"),
	                   inverseJoinColumns = @JoinColumn(name="project_id"))
	 
	private java.util.List<Project> projects;
	
	
	
	public Employee() {
		
	}

	public Employee(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public java.util.List<Project> getProjects() {
		return projects;
	}

	public void setProjects(java.util.List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [" + id + ", " + name + ", " + email + "]";
	}
	
}
