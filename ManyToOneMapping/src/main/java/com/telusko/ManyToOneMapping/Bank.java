package com.telusko.ManyToOneMapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank 
{
	   @Id
	   private int ifsc;
	   private String name;
	   private long pincode;
	   
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
