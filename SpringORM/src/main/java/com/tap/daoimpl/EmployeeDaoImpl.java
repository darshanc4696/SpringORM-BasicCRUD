package com.tap.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tap.entities.Employee;
import com.tap.interfaces.Employeedao;

@Component
public class EmployeeDaoImpl implements Employeedao 
{
	public SessionFactory sessionFactory;
	
	@Autowired
	public EmployeeDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmp(Employee e) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(e);
		session.getTransaction().commit();
		System.out.println("Sucessfully data added");
		session.close();

	}

	@Override
	public ArrayList<Employee> displayAllEmployee() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee",Employee.class);
		
		return (ArrayList<Employee>) query.list();

	}


	@Override
	public Employee getSpecificEmployee(int id) 
	{
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	public void updateEmp(int id, int salary) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "UPDATE Employee e SET e.salary = :newSalary WHERE e.empid = :empId";
        session.createQuery(hql)
                .setParameter("newSalary", salary)
                .setParameter("empId", id).executeUpdate();
		session.getTransaction().commit();
		System.out.println("success update");
		session.close();
	}

	@Override
	public void deleteEmp(int id) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee specificEmployee = getSpecificEmployee(id);
		if(specificEmployee != null)
		{
			session.delete(specificEmployee);
			System.out.println("Succesfully deleted");
		}
		else
		{
			System.out.println("unsucessfull deletion");
		}
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	

}
