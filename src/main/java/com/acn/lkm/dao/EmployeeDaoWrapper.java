package com.acn.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acn.lkm.bean.EmployeeBean;
import com.acn.lkm.entity.EmployeeEntity;

@Repository
public class EmployeeDaoWrapper { 
	
	@Autowired 
	EmployeeDao dao;
	
	public List<EmployeeBean> getAllEmployees(){
		
		List<EmployeeBean> beans = new ArrayList<>();
		List<EmployeeEntity> entity = dao.findAll();
		
		for(EmployeeEntity e : entity) {
			
			EmployeeBean bean = new EmployeeBean();
			BeanUtils.copyProperties(e, bean);
			beans.add(bean);
			
		}
		 
		return beans;
		
	}
	
	public int addEmployee(EmployeeBean employee) {
		
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, empEntity);
		EmployeeEntity emp = dao.save(empEntity);
		
		return emp.getEmpId();
		
	}
	
	public EmployeeBean getEmployeeById(int id) {
		
		EmployeeBean empBean = new EmployeeBean();
		EmployeeEntity empEntity = dao.findOne(id);
		
		if(empEntity != null) {
			BeanUtils.copyProperties(empEntity, empBean);
		}
		
		return empBean;
		
	}
	
	public EmployeeBean updateEmployee(EmployeeBean bean) {
		
		EmployeeBean empBean = new EmployeeBean();
		EmployeeEntity empEntity = dao.findOne(bean.getEmpId());

		if(empEntity != null) {
			BeanUtils.copyProperties(bean, empEntity);
			dao.save(empEntity);
			BeanUtils.copyProperties(empEntity, empBean);
		}
		
		return empBean;
		
	}
	
	public EmployeeBean deleteEmployee(int id) {
		
		EmployeeBean empBean = null;
		EmployeeEntity empEntity = dao.findOne(id);
		
		if(empEntity != null) {
			dao.delete(empEntity);
			empBean =  new EmployeeBean();
			BeanUtils.copyProperties(empEntity, empBean);
		}
		
		return empBean;
		
	}

}
