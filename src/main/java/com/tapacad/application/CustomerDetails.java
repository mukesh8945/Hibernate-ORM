package com.tapacad.application;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "customer_Details")
public class CustomerDetails {
	
	@Id
	@Column (name = " id")
	private int id;
	
	@Column (name = " email")
    private String email;
	
	@Column (name = "phone")
    private String phone;
	
	@Column (name = "address")
    private String address;
	
	@OneToOne (mappedBy = "customerDetails",cascade = CascadeType.ALL)
	private Customer customer;
	
    
    
    public CustomerDetails() {
		
	}


	public CustomerDetails(int id, String email, String phone, String address) {
		super();
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "CustomerDetails [" + id + ", " + email + ", " + phone + ", " + address + "]";
	}


	
    
    
	

}
