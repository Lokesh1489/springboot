package com.nc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nc.controller.PayrollOperationsController;
import com.nc.dao.EmployeeDAOImplementation;
import com.nc.model.Employee;

@SpringBootApplication
public class SpringBootProj03LayeredAppApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj03LayeredAppApplication.class, args);

		PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);

		try {
			List<Employee> employeeList = controller.showEmployeesByDesignation("Developer", "Software Engineer",
					"Engineer");
			employeeList.forEach(emp -> {
				System.out.println(emp);
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Internal prolbme--try again::" + e.getMessage());

		}

		((ConfigurableApplicationContext) ctx).close();
	}
}