package com.telusko.OneToManyManyToOneMapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank 
{
   @Id
   private int ifsc;
   private String name;
   private long pincode;
   
   @OneToMany(mappedBy = "bank")
   private List<Customer> customers;
   
	public List<Customer> getCustomers() {
	    return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public int getIfsc() {
		return ifsc;
	}
	public void setIfsc(int ifsc) {
		this.ifsc = ifsc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
    
}
