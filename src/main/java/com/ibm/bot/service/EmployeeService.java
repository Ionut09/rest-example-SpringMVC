package com.ibm.bot.service;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.bot.model.Employee;

@Component
public class EmployeeService {

	private static List<Employee> empDatasource = new ArrayList<Employee>(){{
		add(new Employee(1L, "Gica", "Hagi", "Pitesti", 1234));
		add(new Employee(2L, "Petrica", "Ionescu", "Bucuresti", 3234));
		add(new Employee(3L, "Ionut", "Petrescu", "Craiova", 9234));
	}};
	
	public Employee getEmployeeById(Long id){
		return empDatasource.stream()
				.filter(emp -> emp.getId()==id)
				.findFirst()
				.get();
	}

	public List<Employee> getAllEmployees() {
		return empDatasource;
	}

	public void createEmployee(Employee emp) {
		empDatasource.add(emp);
	}

	public void deleteEmployee(Long empId) {
		empDatasource = empDatasource.stream().filter(emp -> emp.getId() != empId).collect(toList());
	}
	
}
