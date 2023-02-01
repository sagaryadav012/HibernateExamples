package com.telusko.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Customer c1 = new Customer();
    	c1.setId(17135);
    	c1.setName("Sagar Yadav");
    	
    	Customer c2 = new Customer();
    	c2.setId(17143);
    	c2.setName("Sharath Goud");
    	
    	Customer c3 = new Customer();
    	c3.setId(17131);
    	c3.setName("Ashok Kumar");
    	
    	List<Customer> list = new ArrayList<Customer>();
    	list.add(c1);
    	list.add(c2);
    	list.add(c3);
    	
    	Bank b = new Bank();
    	b.setIfsc(2041662);
    	b.setName("HDFC");
    	b.setPincode(507101);
    	b.setCustomers(list);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Bank.class).addAnnotatedClass(Customer.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction txn = s.beginTransaction();
        s.save(b);
        s.save(c1);
        s.save(c2);
        s.save(c3);
        txn.commit();
    }
}
