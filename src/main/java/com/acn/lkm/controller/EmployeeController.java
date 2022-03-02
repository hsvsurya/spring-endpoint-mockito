
package com.acn.lkm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acn.lkm.bean.EmployeeBean;
import com.acn.lkm.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@RequestMapping(value = "/emp/getEmployees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeBean>> getEmployeeDetails() {
		List<EmployeeBean> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeBean>>(listEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "emp/getEmployeeById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId) {
		EmployeeBean employee = employeeService.getEmployeeById(myId);

		if (employee != null) {
			return new ResponseEntity<EmployeeBean>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/emp/addEmp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean employee) {
		int id = employeeService.addEmployee(employee);
		return new ResponseEntity<>("Employee added successfully with id:" + id, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/emp/updateEmp", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody EmployeeBean employee) {
		EmployeeBean employee2 = employeeService.updateEmployee(employee);
		if (employee2 == null) {
			return new ResponseEntity<EmployeeBean>(employee2, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println(employee);
		return new ResponseEntity<EmployeeBean>(employee2, HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/deleteEmp/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> deleteEmployee(@PathVariable("id") int myId) {
		EmployeeBean employee = employeeService.deleteEmployee(myId);
		if (employee == null) {
			return new ResponseEntity<EmployeeBean>(employee, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Removed: " + employee);
		return new ResponseEntity<EmployeeBean>(employee, HttpStatus.OK);
	}
}
