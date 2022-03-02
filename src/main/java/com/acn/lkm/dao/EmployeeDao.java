package com.acn.lkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acn.lkm.entity.EmployeeEntity;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer>{

	
}
