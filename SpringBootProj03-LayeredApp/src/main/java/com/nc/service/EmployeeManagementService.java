package com.nc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nc.dao.IEmployeeDAO;
import com.nc.model.Employee;

@Service("employeeService")
public class EmployeeManagementService implements IEmployeeManagementService {

	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	public List<Employee> fetchEmployeesByDesignation(String designation1, String designation2, String designation3)
			throws Exception {
		return employeeDAO.getEMployeeByDesignation(designation1, designation2, designation3);
	}
}
