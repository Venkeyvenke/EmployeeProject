package com.invensis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invensis.request.EmpRequest;
import com.invensis.response.EmpResponse;
import com.invensis.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/postData")
	public String postData(@RequestBody EmpRequest empRequest) {
		return employeeService.postData(empRequest);
	}

	@GetMapping("/getData")
	public List<EmpResponse> getAllData() {
		return employeeService.getAllData();
	}

}
