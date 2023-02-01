package com.telusko.HQLExamples;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Worker.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction txn = s.beginTransaction();
        
        // Fetch All Data using HQL
//		Query q = s.createQuery("from Worker");
//		List<Worker> workers = q.list();
//		for(Worker w : workers)
//			System.out.println(w);
        
        // Get records with pagination
//        Query q = s.createQuery("from Worker");
//        q.setFirstResult(1);
//        q.setMaxResults(2);
//        List<Worker> workers = q.list(); // will return the records from 5 to 10th number
//        for(Worker w : workers)
//        	System.out.println(w);
        
        // Fetch Particular row
//        Query q = s.createQuery("from Worker where id = 510");
//        Worker w = (Worker)q.uniqueResult();
//        System.out.println(w);
        
        // Update data
//        Query q = s.createQuery("update Worker set name = :n where id = :id ");
//        q.setParameter("n", "Sagar Yadav");
//        q.setParameter("id", 512);
//        
//        int status = q.executeUpdate();
//        System.out.println(status);
        
        
        // Delete Data
//        Query q = s.createQuery("delete from Worker where id = :id ");
//        q.setParameter("id", 505);
//        
//        int status = q.executeUpdate();
//        System.out.println(status);
        
        
        // Fetch MAX salary
//        Query q = s.createQuery("select max(salary) from Worker");
//        Long l = (Long) q.uniqueResult();
//        System.out.println(l);
        
        
        // Fetch MIN salary
//        Query q = s.createQuery("select min(salary) from Worker");
//        Long l = (Long) q.uniqueResult();
//        System.out.println(l);
        
        
        // Fetch AVG salary
//        Query q = s.createQuery("select avg(salary) from Worker");
//        Double d = (Double) q.uniqueResult();
//        System.out.println(d);
        
        
        // Count number of id's
//        Query q = s.createQuery("select count(id) from Worker");
//        Long l = (Long) q.uniqueResult();
//        System.out.println(l);
        
        
//       Fetching Data with specific columns 
//       Here we have fetched two cloumns of data only where id = 512
//       When we fetch particular columns, coulmns would be different datatypes like
//       here name is String and salary is long, So we have to cast it to Object.
        
//        Query q = s.createQuery("select name, salary from Worker where id = 512");
//        Object[] worker = (Object[]) q.uniqueResult();
//        System.out.println(worker[0]+" : "+worker[1]);

        
        
        // Fetch all rows with specific columns(name, salary)
//        Query q = s.createQuery("select name, salary from Worker");
//        List<Object[]> workers  = (List<Object[]>) q.list();
//        for(Object[] worker : workers)
//        	System.out.println(worker[0]+" : "+worker[1]);
        
        
        // Fetch Particular row data with SQL Native Query
//        SQLQuery q = s.createSQLQuery("select * from worker where salary>30000");
// 		q.addEntity(Worker.class); // If we do't mention this, we get hashcode of employee   
//        List workers = q.list();
//        
//        for(Object worker : workers)
//        	System.out.println(worker);
        
        
        
        // Fetch specific columns of data with SQL Native Query
        SQLQuery q = s.createSQLQuery("select id, name, salary from worker where salary>30000");
 		q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);   
        List workers = q.list();
        
        for(Object worker : workers)
        {
        	Map m = (Map)worker;
        	System.out.println(m.get("id")+" : "+m.get("name")+" : "+m.get("salary"));
        }
        
        txn.commit();
        
    }
}
