package com.telusko.HibExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Student s = new Student();
        s.setId(103); // Id should be unique as it is Identifier property
        s.setName("Sagar yadav");
        s.setMarks(800);
        
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction txn = session.beginTransaction();
        // session.save(s); // save method inserts data in table
        // session.update(s); // update method update details by taking reference of Identifier
        // session.delete(s); // deletes object from DB and it doesn't need all properties like name, marks. id is enough.
         Student st = (Student)session.get(Student.class, 102); // get(Entity type, Identifier)
         System.out.println(st);
        
        txn.commit();
    }
}
