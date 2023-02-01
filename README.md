# HibernateExamples

Hibernate Framework :
Hibernate is a Java framework that simplifies the development of Java application to interact with the database. 
It is an open source, lightweight, ORM (Object Relational Mapping) tool. 
Hibernate implements the specifications of JPA (Java Persistence API) for data persistence.

ORM TOOL :
An ORM tool simplifies the data creation, data manipulation and data access. 
It is a programming technique that maps the object to the data stored in the database.

JPA :
Java Persistence API (JPA) is a Java specification that provides certain functionality and standard to ORM tools. 
The javax.persistence package contains the JPA classes and interfaces.

SessionFactory :
The SessionFactory is a factory of session and client of ConnectionProvider. 
It holds second level cache (optional) of data. The org.hibernate.
SessionFactory interface provides factory method to get the object of Session.

Session :
The session object provides an interface between the application and data stored in the database. 
It is a short-lived object and wraps the JDBC connection. 
It is factory of Transaction, Query and Criteria. 
It holds a first-level cache (mandatory) of data. 
The org.hibernate.Session interface provides methods to insert, update and delete the object. 
It also provides factory methods for Transaction, Query and Criteria.

Transaction : 
The transaction object specifies the atomic unit of work. It is optional. The org.hibernate.
Transaction interface provides methods for transaction management.

@Entity annotation marks this class as an entity.

@Table annotation specifies the table name where data of this entity is to be persisted. 
If you don't use @Table annotation, hibernate will use the class name as the table name by default.

@Id annotation marks the identifier for this entity.

@Column annotation specifies the details of the column for this property or field. 
If @Column annotation is not specified, property name will be used as the column name by default.

HQL : 
Hibernate Query Language (HQL) is same as SQL (Structured Query Language) but it doesn't depends on the table of the database. 
Instead of table name, we use class name in HQL. So it is database independent query language.

Query Interface : 
It is an object oriented representation of Hibernate Query. 
The object of Query can be obtained by calling the createQuery() method Session interface.

Hibernate created a new language named Hibernate Query Language (HQL), the syntax is quite similar to database SQL language. 
The main difference between is HQL uses class name instead of table name, and property names instead of column name.

get() vs load() : https://www.digitalocean.com/community/tutorials/hibernate-session-get-vs-load-difference-with-examples

Both get() and load() seems similar because both of them fetch the data from database, however there are few differences between them
1. get() loads the data as soon as it’s called whereas load() returns a proxy object and loads data only when it’s actually required, so load() is better because it support lazy loading.
2. Since load() throws exception when data is not found, we should use it only when we know data exists.
3. We should use get() when we want to make sure data exists in the database.

-----------------------------------------------------------------------------------------------------------

Dependencies :: 
Hibernate EntityManager Relocation : It gives hibernate classes
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>5.6.14.Final</version>
</dependency>

MySql Conncetor : To connect with database
<dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	    <version>8.0.29</version>
</dependency>

EhCahce : To use features of EhCache
<dependency>
	    <groupId>net.sf.ehcache</groupId>
	    <artifactId>ehcache</artifactId>
	    <version>2.10.5</version>
</dependency>

Hibernate-EcCache : For hibernate and ehCache integration
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-ehcache</artifactId>
    <version>4.0.0.Final</version>
</dependency>
--------------------------------------------------------------------------------------------------------------

-> While Creating Project choose Maven Project, it is easier to add and maintain dependencies
-> Choose Archtype is quickstart

-> Hibernate Plugin : We have to install it to configure hibernate.cfg file, It has database details.
   Go to Help -> Eclipse Market Place -> search Hibernate -> Jboss tool has hibernate
   While installing, install only hibernate tools and uncheck all other tools. 

--------------------------------------------------------------------------------------------------------------

If Table is not created when we run code even we use update in cfg file -> make sure dialect is MySQL5Dialect and hibernate-entitymanager
version is above 5 means 5.6.14.Final. If we use greater 5 version we don't need to create service registry.

----------------------------------------------------------------------------------------------------------------
1. HibExample : In this we can see save(), udpate(), delete() and get() methods of session. 
                Using this methods we can manipulate data in database.

2. EmbeddedObjectExample : It is an examples of how one object is depended on other object, and can see How we embedded dependent object.

3. HibernateCacheExample : Example of First Level and Second Level Cache.

4. GetVsLoadExample : Example of diference between Get() and Load() methods of session.

5. HQLExamples : In this we have examples of HQL and Native Sql Query

6. OneToOneMapping : One Employee can have one Laptop.
I have taken two different classes Emp, Laptop. Emp class has Laptop property and Mentioned OneToOne Mapping their
then it creates two tables emp(id, name, domain, laptop_lid), laptop(lid, lname).
Mapping done in emp table, laptop_lid in emp table is foreign key.
  
7. OneToManyMapping : One Bank can have multiple Customers.
I have taken two classes Bank, Customer. Taken list of customers in Bank class and mentioned OneToMany Mapping,
then it creates 3 tables bank(ifsc, name, pincode), customer(id, name) and bank_customer(bank_ifsc, customers_id).
Mapping done in bank_customer table.

8. ManyToOneMapping : Multiple users can have one or same bank account.
Taken same examples as discussed in OneToMany. Here I have taken bank variable in Customer class and Mentioned ManyToOne Mapping
it creates bank(ifsc, name, pincode), customer(id, name, bank_ifsc).
Mapping done in customer table, Here bank_ifsc coulmn in customer table is foreign key.



9. OneToManyManyToOneMapping : One Bank can have multiple customers and Multiple customers can have one Bank.
It creates tables bank(ifsc, name, pincode), customer(id, name) and bank_customer(bank_ifsc, customers_id)

If we metione mapping is done by "bank" varialbe in Bank class it creates two tables only.
bank(ifsc, name, pincode), customer(id, name, bank_ifsc).
Here bank_ifsc coulmn in customer table is foreign key.


10. ManyToManyMapping : Multiple Customers can have multiple accounts as well as Multiple Banks can have multiple customers.

Taken List of Banks in Customer class and List of Customers in Bank Class, Mentioned ManyToMany Mapping.
It creates 4 tables : bank(ifsc, name, pincode), customer(id, name),
                      bank_customer(bank_ifsc, customers_id) and customer_bank(customer_id, bank_ifsc)

If We mention mapped By banks(declared in Customer that means customer is reposible to do mapping) property in Bank Class, 
It creates only 3 tables That are bank(ifsc, name, pincode), customer(id, name), customer_bank(customers_id, bank_ifsc);


