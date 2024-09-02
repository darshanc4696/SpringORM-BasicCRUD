package com.tap.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "employee")
public class Employee 
{
	@Id
	@Column(name="id")
	int empid;
	@Column(name="name")
	String name;
	@Column(name="desg")
	String desg;
	@Column(name="salary")
	int salary;
	
	public Employee() {
		super();
	}

	@Autowired
	public Employee(@Value("2") int empid,@Value("ABcd") String name,@Value("IT") String desg,@Value("80000") int salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.desg = desg;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "empid=" + empid + ", name=" + name + ", desg=" + desg + ", salary=" + salary;
	}
	
}
