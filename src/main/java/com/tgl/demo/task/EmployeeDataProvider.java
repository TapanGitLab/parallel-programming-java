package com.tgl.demo.task;

import java.util.ArrayList;
import java.util.List;

import com.tgl.demo.model.Employee;

public class EmployeeDataProvider {
	
	public static List<Employee> getListOfEmployees(int numberOfEmployees) {		
		List<Employee> employees = new ArrayList<>();
		for(int i=0;i<numberOfEmployees;i++) {
			int count = i+1;
			Employee emp=new Employee(i+1,"name"+"_"+count,25+count);
			System.out.println(emp.toString());
			employees.add(emp);			
		}
		return employees;
	}

}
