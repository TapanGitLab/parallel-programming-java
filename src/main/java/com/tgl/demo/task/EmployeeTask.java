package com.tgl.demo.task;

import com.tgl.demo.model.Employee;

public class EmployeeTask implements Runnable{


	private final Employee employee;
	private final Integer count;

	public EmployeeTask(Employee employee,Integer count) {
		this.employee = employee;
		this.count=count;
	}

	@Override
	public void run() {
		System.out.println("-------- Execution STARTED   for employee ::: count :--- "+count + "  id :  " +employee.getId() + 
				"   name : "+ employee.getName() + "  Thread : " +Thread.currentThread()  );		
		try {
			if(count==2) {
				Thread.sleep(10000);
			}
			if(count==5) {
				Thread.sleep(20000);
			}
			if(count==7) {
				Thread.sleep(30000);
			}
			if(count==3) {
				Thread.sleep(50000);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------- Execution COMPLETED for employee ::: count :--- "+count + "  id :  " +employee.getId() + 
				"   name : "+ employee.getName() + "  Thread : " +Thread.currentThread()  );
	}	

	
}
