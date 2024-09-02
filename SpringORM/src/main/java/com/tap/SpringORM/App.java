package com.tap.SpringORM;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.daoimpl.EmployeeDaoImpl;
import com.tap.entities.Employee;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("beans.xml");
        
        EmployeeDaoImpl edaoi = (EmployeeDaoImpl) cx.getBean("employeeDaoImpl");
//        Employee emp = (Employee) cx.getBean("employee");
//        
//        edaoi.addEmp(emp);
        
//        ArrayList<Employee> emp = edaoi.displayAllEmployee();
//        
//        for(Employee e : emp)
//        {
//        	System.out.println(e);
//        }
        
//        Employee specificEmployee = edaoi.getSpecificEmployee(1);
//        System.out.println(specificEmployee);
        
//        edaoi.updateEmp(1, 150000);
        
        edaoi.deleteEmp(2);
    }
}
