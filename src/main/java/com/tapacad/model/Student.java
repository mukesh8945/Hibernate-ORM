package com.tapacad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {

//	Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rollNo")
	private int rollNo;
	
	@Column(name = " name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "marks")
	private int marks;

//	Constructors
	public Student() {

	}

	public Student(int rollNo, String name, String email, int marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.email = email;
		this.marks = marks;
	}

//	Setter and getters
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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
	public int getMarks() {
		return marks;
	}
	public void setMarks(int  marks) {
		this.marks = marks;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return rollNo+", "+name+", "+email+", "+marks;
		}

}
