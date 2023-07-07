package com.nc.dao;

import java.util.List;

import com.nc.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> getEMployeeByDesignation(String designation1, String designation2, String designation3)
			throws Exception;
}
