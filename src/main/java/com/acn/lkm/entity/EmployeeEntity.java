package com.acn.lkm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class EmployeeEntity {

	@Id
	int empId;
	String empName;
	double salary;
	Date joinDate;
	
	public EmployeeEntity(int empId, String empName, double salary, Date date) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.joinDate = date;
	}
	
	public EmployeeEntity() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date date) {
		this.joinDate = date;
	}
	
	
	
}
