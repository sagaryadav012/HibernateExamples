package com.telusko.HibernetCacheExample;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="contractor")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Contractor 
{
	   @Id
	   private int id;
	   private String name;
	   private String company;
	   
	   
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
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		@Override
		public String toString() {
			return "Contractor [id=" + id + ", name=" + name + ", company=" + company + "]";
		}
}
