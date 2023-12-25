package com.tgl.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tgl.demo.model.Employee;
import com.tgl.demo.task.EmployeeDataProvider;
import com.tgl.demo.task.EmployeeTask;

@SpringBootApplication
public class DemoWithThread {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoWithThread.class, args);
		
		EmployeeDataProvider employeeDataProvider=new EmployeeDataProvider();

		@SuppressWarnings("static-access")
		List<Employee> employees = employeeDataProvider.getListOfEmployees(20);
		
		List<Thread> threads = new ArrayList<>();

        //Start a new thread for each employee		
        for (Employee employee : employees) {
        	int count=employee.getId();
            Thread t = new Thread(() -> new EmployeeTask(employee,count).run());           
            threads.add(t);
            t.start();
        }
        
        //Wait for all threads to complete
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("----------------- processEmployeeData() completed for all employees ...................");
		

	}

}
