package com.tapacad.application;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.tapacad.model.Orders;

@Entity
@Table (name = "customer")
public class Customer {
	@Id
	@Column (name = "id")
	private int id;
	
	@Column (name= "name")
	private String name;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_detail_id")
	private CustomerDetails  customerDetails;
	
	@OneToMany (mappedBy  = "customer", cascade = CascadeType.ALL)
	private List<Orders> orders;
	
	
	
	public Customer() {
		
	}


	public Customer(int id, String name) {
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


	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}


	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}


	@Override
	public String toString() {
		return  + id + ", " + name + ", " + customerDetails;
	}
	
	
	
	
	
	
	
	
	

}
