package com.tap.interfaces;

import java.util.ArrayList;

import com.tap.entities.Employee;

public interface Employeedao 
{
	void addEmp(Employee e);
	ArrayList<Employee> displayAllEmployee();
	Employee getSpecificEmployee(int id);
	void updateEmp(int id, int salary);
	void deleteEmp(int id);

}
