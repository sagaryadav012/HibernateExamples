package com.telusko.ManyToManyMapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer 
{
  @Id
  private int id;
  private String name;
  
  @ManyToMany
  private List<Bank> banks;
  
	
	public List<Bank> getBanks() {
	   return banks;
	}
	public void setBanks(List<Bank> banks) {
		this.banks = banks;
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
  
}