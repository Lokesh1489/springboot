package com.nc.service;

import java.util.List;

import com.nc.model.Employee;

public interface IEmployeeManagementService {
	public List<Employee> fetchEmployeesByDesignation(String designation1, String designation2, String designation3)
			throws Exception;
}
