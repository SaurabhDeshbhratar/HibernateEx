package com.jbk;//28-03-22
//error dont know how to use
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaTest2 {
public static void main(String[] args) {
	
	Configuration cfg =new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Employee.class);
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	
    //select * from employee where ename='xyz'
	Criteria criteria = session.createCriteria(Employee.class);
	criteria.add(Restrictions.eq("ename", "jbk"));
	criteria.add(Restrictions.eq("eid", "451"));
	//projection to do some operations on columns
	//select single column//aggregate function
	
	List<Employee> listEmp = criteria.list();
	
	for (Employee employee : listEmp) {
		System.out.println(employee.eid);
		System.out.println(employee.ename);
	}
}	
}
