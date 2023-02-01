package com.telusko.ManyToManyMapping;

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
    	// HDFC Bank
    	Bank HDFC = new Bank();
    	HDFC.setIfsc(23660);
    	HDFC.setName("HDFC");
    	HDFC.setPincode(507101);
    	
    	// ICICI Bank
    	Bank ICICI = new Bank();
    	ICICI.setIfsc(34112);
    	ICICI.setName("ICICI");
    	ICICI.setPincode(507101);
    	
    	// Customer : Laxma
    	Customer Laxma = new Customer();
    	Laxma.setId(501);
    	Laxma.setName("Laxma");
    	
    	// Customer : Akhil
    	Customer Akhil = new Customer();
    	Akhil.setId(515);
    	Akhil.setName("Akhil");
    	
    	// Customer : Navin
    	Customer Navin = new Customer();
    	Navin.setId(530);
    	Navin.setName("Navin");
    	
    	// Create List of Banks those Laxma Have
    	List<Bank> LaxmaList = new ArrayList<>();
    	LaxmaList.add(HDFC);
    	LaxmaList.add(ICICI);
    	
    	// Create List of Banks those Akhil Have
    	List<Bank> AkhilList = new ArrayList<>();
    	AkhilList.add(HDFC);
    	AkhilList.add(ICICI);
    	
    	// Create List of Banks those Navin Have
    	List<Bank> NavinList = new ArrayList<>();
    	NavinList.add(ICICI);
    	
    	// Create List of Customers Those HDFC have
    	List<Customer> HdfcList = new ArrayList<>();
    	HdfcList.add(Laxma);
    	HdfcList.add(Akhil);
    	
    	// Create List of Customers Those ICICI have
    	List<Customer> IciciList = new ArrayList<>();
    	IciciList.add(Navin);
    	IciciList.add(Akhil);
    	IciciList.add(Laxma);
    	
    	HDFC.setCustomers(HdfcList);
    	ICICI.setCustomers(IciciList);
    	
    	Laxma.setBanks(LaxmaList);
    	Akhil.setBanks(AkhilList);
    	Navin.setBanks(NavinList);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Bank.class).addAnnotatedClass(Customer.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction txn = s.beginTransaction();
        s.save(HDFC);
        s.save(ICICI);
        s.save(Laxma);
        s.save(Akhil);
        s.save(Navin);
        txn.commit();
    }
}
