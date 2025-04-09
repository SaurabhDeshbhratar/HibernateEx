package com.jbk;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CriteriaTest {
public static void main(String[] args) {
	
	Configuration cfg =new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Employee.class);
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	
    //select * from employee
	Criteria criteria = session.createCriteria(Employee.class);
	List<Employee> listEmp = criteria.list();
	for (Employee employee : listEmp) {
		System.out.println(employee.eid);
		System.out.println(employee.ename);
		
	}
}
} 
