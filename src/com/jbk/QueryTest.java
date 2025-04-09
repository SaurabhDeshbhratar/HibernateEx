package com.jbk;//28-03-22

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryTest {
	public static void main(String[] args) {

		Configuration cfg =new Configuration();
		//hibernate cfg file will be parsed
		//driver will be loded
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory factory = cfg.buildSessionFactory();
		//get one connection from connection factory
		Session session = factory.openSession();

		/*Query  query = session.createQuery("select ename from Employee ");
		//only ename column
		List<String> listEmp= query.list();   
		for (String employeeName : listEmp) {
			System.out.println(employeeName);
        */
		
		/*	Query  query = session.createQuery("select eid from Employee ");
			//only eid column
			List<Integer> listEmp= query.list();   
			for (int employeeid : listEmp) {
				System.out.println(employeeid);
		*/
			Query  query = session.createQuery("select ename,eid from Employee ");
		    //both column print
			List<Object []> listEmp =query.list();
			for(Object [] empDetails : listEmp) {
				for (Object objects : empDetails) {
					System.out.println(objects.toString());
				}
		
		}
	} 
}