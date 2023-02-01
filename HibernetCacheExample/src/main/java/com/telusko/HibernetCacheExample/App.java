package com.telusko.HibernetCacheExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Contractor c1 = null;
    	Contractor c2 = null;
    	Contractor c3 = null;
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Contractor.class);
        SessionFactory sf = cfg.buildSessionFactory();
        
        // First Level Cache
        Session session1 = sf.openSession(); 
        Transaction txn1 = session1.beginTransaction();
        
        // First it will search data in session cache, if don't find data It fires query and get data from database. It stores data in session
        c1 = (Contractor) session1.get(Contractor.class, 512);
        System.out.println(c1);
        
        // Now it don't fire query, it takes data from session cache.
        // It fires query only when we fetch different contractor data which has not been fetched earlier.
        c2 = (Contractor) session1.get(Contractor.class, 512); 
        System.out.println(c2);
        
        txn1.commit();
        
		/*
		  Second Level Cache 
		  To enable Second level Cache 
		  1. Add below dependencies 
		  --> EhCache from net.sf.ehcache : It is to use ehcache features 
		  --> Hibernate-EhCache : It is for hibernate EhCache integration 
		  2. Add these in hibernate config file
		  --> <property name="hibernate.cache.use_second_level_cache">true</property>
          --> <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
          --> <property name="hibernate.cache.use_query_cache">true</property> 
		  3. Add these two annotations in entity class 
		  --> @Cacheable : It allows entity class to cache
		  --> @Cache(usage = CacheConcurrencyStrategy.READ_ONLY) : Strategy of cache
		 */
        
        Session session2 = sf.openSession(); 
        Transaction txn2 = session2.beginTransaction();
        
        c3 = (Contractor) session2.get(Contractor.class, 512); 
        System.out.println(c3);
        
        txn2.commit();
        
        
    }
}
