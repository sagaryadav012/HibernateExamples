package com.telusko.ManyToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Bank b = new Bank();
    	b.setIfsc(2041662);
    	b.setName("HDFC");
    	b.setPincode(507101);
    	
    	Customer c1 = new Customer();
    	c1.setId(17135);
    	c1.setName("Sagar Yadav");
    	c1.setBank(b);
    	
    	Customer c2 = new Customer();
    	c2.setId(17143);
    	c2.setName("Sharath Goud");
    	c2.setBank(b);
    	
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Bank.class).addAnnotatedClass(Customer.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction txn = s.beginTransaction();
        s.save(b);
        s.save(c1);
        s.save(c2);
        txn.commit();
    }
}
