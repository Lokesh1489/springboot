package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class Project3LayeredAppApplication {

	public static void main(String[] args) {
		// get IOC conatiner
		ApplicationContext ctx = SpringApplication.run(Project3LayeredAppApplication.class, args);

		// get controller class obj ref
		PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);

		// invoke b.method
		try {
			List<Employee> list = controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp -> {
				System.out.println(emp);
			});
		} catch (Exception e) {
			e.printStackTrace();
			((ConfigurableApplicationContext)ctx).close();

		}
	}
}
