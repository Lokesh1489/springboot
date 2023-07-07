package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company;
import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj06ConfigurationPropertiesOnArrayListSetHasAPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication
				.run(BootProj06ConfigurationPropertiesOnArrayListSetHasAPropertiesApplication.class, args);
		Employee employee = ctx.getBean("emp", Employee.class);
		System.out.println(employee);
		((ConfigurableApplicationContext) ctx).close();
	}

}
