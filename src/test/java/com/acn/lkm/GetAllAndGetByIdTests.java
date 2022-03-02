package com.acn.lkm;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.acn.lkm.bean.EmployeeBean;
import com.acn.lkm.controller.EmployeeController;
import com.acn.lkm.service.EmployeeServiceImpl;
import com.acn.lkm.utils.JSONUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//@AutoConfigureMockMvc
public class GetAllAndGetByIdTests { 

	@Mock
	EmployeeServiceImpl service;
	
	@InjectMocks
	EmployeeController controller;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void mySetup() {
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
	}
	
	
	@Test
	public void getEmployees() throws Exception {
		
		String uri = "/emp/getEmployees";
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri);
		
		when(service.getAllEmployees()).thenReturn(getEmployeesdata());
		
		ResultActions rest = mockMvc.perform(request);
		MvcResult mvcResult = rest.andReturn();
		
		String result = mvcResult.getResponse().getContentAsString();
		int actualStatus = mvcResult.getResponse().getStatus();
		
		@SuppressWarnings("unchecked")
		List<EmployeeBean> employees = JSONUtils.convertJsonToObject(result,List.class);
		
		verify(service,times(1)).getAllEmployees();
		
		Assert.assertNotEquals(employees,null);
		Assert.assertEquals(actualStatus,HttpStatus.OK.value());
		
	}

//	@Test
//	public void getEmployeeByIdTest() throws Exception {
//		
//		String uri = "/emp/getEmployeeById/103";
//		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri); 
//		
//		when(service.getEmployeeById(103)).thenReturn(new EmployeeBean(103, "surya", 29302, new Date()));
//		
//		ResultActions rest = mockMvc.perform(request);
//		MvcResult mvcResult = rest.andReturn();
//		
//		String result = mvcResult.getResponse().getContentAsString();
//		int actualStatus = mvcResult.getResponse().getStatus();
//		
//		EmployeeBean empBean = JSONUtils.convertJsonToObject(result, EmployeeBean.class);
//		
//		String expectedName = "surya";
//		
//		verify(service,times(1)).getEmployeeById(103);
//		
//		Assert.assertTrue(empBean.getEmpName().equals(expectedName));
//		Assert.assertTrue(actualStatus == HttpStatus.OK.value()); 
//		
//	}

	public List<EmployeeBean> getEmployeesdata() {
		return Arrays.asList(new EmployeeBean(101, "harsha", 23001.0, new Date()),
				new EmployeeBean(102, "joe", 23001.0, new Date()),
				new EmployeeBean(103, "will", 23001.0, new Date()),
				new EmployeeBean(104, "jack", 23001.0, new Date()));
	}

}
