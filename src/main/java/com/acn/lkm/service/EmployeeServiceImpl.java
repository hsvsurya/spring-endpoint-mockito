package com.acn.lkm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acn.lkm.bean.EmployeeBean;
import com.acn.lkm.dao.EmployeeDaoWrapper;

@Service
public class EmployeeServiceImpl {

	@Autowired
	EmployeeDaoWrapper dao;
	
	public List<EmployeeBean> getAllEmployees(){
		return dao.getAllEmployees(); 
	}
	
	public int addEmployee(EmployeeBean employee) {
		return dao.addEmployee(employee);
	}
	
	public EmployeeBean getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}
	
	public EmployeeBean updateEmployee(EmployeeBean bean) {
		return dao.updateEmployee(bean);
	}
	
	public EmployeeBean deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}
	
}
