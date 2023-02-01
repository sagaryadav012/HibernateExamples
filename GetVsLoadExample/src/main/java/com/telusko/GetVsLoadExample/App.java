package com.telusko.GetVsLoadExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
	Both get() and load() seems similar because both of them fetch the data from database, 
	however there are few differences between them
	1. get() loads the data as soon as it’s called whereas load() returns a proxy object and loads data only 
	   when it’s actually required, so load() is better because it support lazy loading.
	2. Since load() throws exception when data is not found, we should use it only when we know data exists.
	3. We should use get() when we want to make sure data exists in the database.
*/
public class App 
{
    public static void main( String[] args )
    {
    	Worker w1 = null;
    	Worker w2 = null;
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Worker.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction txn = s.beginTransaction();
        
        // get() fires query even we don't use w1 object and get gives null if it don't find data
        w1 = (Worker)s.get(Worker.class, 507);
        System.out.println("get method called");
        System.out.println(w1);
        
        // load() don't fire query until we use w2 object and load gives object not found exception if it don't find data
        w2 = (Worker)s.load(Worker.class, 506);
        System.out.println("load method called");
        System.out.println(w2);
        
        txn.commit();
    }
}
