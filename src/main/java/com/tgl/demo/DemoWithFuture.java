package com.tgl.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tgl.demo.model.Employee;
import com.tgl.demo.task.EmployeeDataProvider;
import com.tgl.demo.task.EmployeeTask;

@SpringBootApplication
public class DemoWithFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SpringApplication.run(DemoWithFuture.class, args);

		EmployeeDataProvider employeeDataProvider=new EmployeeDataProvider();

		@SuppressWarnings("static-access")
		List<Employee> employees = employeeDataProvider.getListOfEmployees(20);

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		List<Future<?>> futures = new ArrayList<>();

		// submit tasks for each employee
		System.out.println("Start time : "+ new Date()+ " __ "+ new Date().getSeconds());
		int count=0;
		for (Employee employee : employees) {
			count++;
			//EmployeeTask empTask=new EmployeeTask(employee,count);
			//empTask.run1();
			Future<?> future = executorService.submit(new EmployeeTask(employee,count));
			futures.add(future);
		}

		// wait for all tasks/threads to complete their tasks.  
		//Once all threads complete their tasks then only proceed for next execution.
		for (Future<?> future : futures) {
			future.get();
		}

		System.out.println("********  ########  ******** ########  EXECUTION OF THIS IS EXPECTED AFTER COMPLETION OF ALL THREAD ********  ########  ******** ######## ");
		System.out.println("Start time : "+ new Date() + " __ "+ new Date().getSeconds());
		// shut down the executor service
		executorService.shutdown();
		
	}

}
