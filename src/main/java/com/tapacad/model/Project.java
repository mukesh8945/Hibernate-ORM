package com.tapacad.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, 
			              CascadeType.PERSIST, CascadeType.REFRESH })

	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "project_id"), 
	                      inverseJoinColumns = @JoinColumn(name = "emp_id"))

    private	java.util.List<Employee> employees;

	public Project() {

	}

	public Project(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	

	public java.util.List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(java.util.List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [" + id + ", " + name + ", " +  "]";
	}
	
	

}
