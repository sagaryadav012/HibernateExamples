package com.telusko.EmbeddedObjectExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	Address ad = new Address();
    	ad.setCity("Kamareddy");
    	ad.setState("Telangana");
    	
    	Employee emp = new Employee();
    	emp.setId(1004);
    	emp.setName("Aravind");
    	emp.setAddress(ad);
    	
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction txn = session.beginTransaction();
//         session.save(emp); // save method inserts data in table
        
        Employee e = (Employee)session.get(Employee.class, 1002); // get(Entity type, Identifier)
        System.out.println(e);
        
        txn.commit();
    }
}
