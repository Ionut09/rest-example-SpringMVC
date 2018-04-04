package com.ibm.bot.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bot.model.Employee;
import com.ibm.bot.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(path = "/{id}", method = GET)
	public Employee getEmployeeById(@PathVariable("id") Long empId){
		return empService.getEmployeeById(empId);
	}

	@RequestMapping(path="epmployees",
			method = GET)
	public List<Employee> getAllEmployee(){
		return empService.getAllEmployees();
	}
	
	@RequestMapping(method = POST)
	public void createEmployee(Employee emp){
		empService.createEmployee(emp);
	}
	
	@RequestMapping(path = "/{id}", method = DELETE)
	public void deleteEmployee(@PathVariable("id") Long empId){
		empService.deleteEmployee(empId);
	}
	
	
}
