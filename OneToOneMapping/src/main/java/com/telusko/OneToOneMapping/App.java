package com.telusko.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
	In this example one employee can have one office laptop. Here Mapping done by 
	OneToOne element using annotation. ForeignKey(lid) created in emp table.
	
	Here Two table will be created emp and laptop
	laptop have columns lid, lname
	emp have cloumns id, domain, name, laptop_lid --> here laptop_lid is foreignkey
*/
public class App 
{
    public static void main( String[] args )
    {
       Laptop l = new Laptop();
       l.setLid(121);
       l.setLname("Lenovo");
       
       Emp e = new Emp();
       e.setId(5231);
       e.setName("Sharath goud");
       e.setDomain("Web Development");
       e.setLaptop(l);
       
       Configuration cfg = new Configuration().configure().addAnnotatedClass(Emp.class).addAnnotatedClass(Laptop.class);
       SessionFactory sf = cfg.buildSessionFactory();
       Session s = sf.openSession();
       Transaction txn = s.beginTransaction();
       s.save(l);
       s.save(e);
       txn.commit();
    }
}
