package com.acn.lkm.bean;

import java.util.Date;

public class EmployeeBean {

	private int empId;
	private String empName; 
	private double salary;
	private Date joinDate;
	
	public EmployeeBean(int empId, String empName, double salary, Date joinDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.joinDate = joinDate;
	}
	
	public EmployeeBean() {
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

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
	
}
