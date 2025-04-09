package com.jbk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		//hibernate cfg file will be parsed
		//driver will be loaded
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory factory = cfg.buildSessionFactory();
		
		//get one connection from connection factory
		Session session = factory.openSession();
		//it will load a data of employee table
		//w.r.to primary key 23
		Transaction transaction = session.beginTransaction();
		Employee employee = session.load(Employee.class,11);
        System.out.println(employee);
        employee.setEname("hello...");//operation fail
        session.update(employee);//for this we need select,insert,update,delete
	    transaction.commit();//trans n commit line solun
	} 

}
