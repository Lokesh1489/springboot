package com.nc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nc.model.Employee;
import com.nc.service.IEmployeeManagementService;

@Controller("payroll")
public class PayrollOperationsController {

	@Autowired
	private IEmployeeManagementService service;

	public List<Employee> showEmployeesByDesignation(String designation1, String designation2, String designation3) throws Exception {
		System.out.println("PayrollOperationsController.showEmployeesByDesignation()");

		List<Employee> employeeList = service.fetchEmployeesByDesignation(designation1, designation2, designation3);
		return employeeList;
	}
}
