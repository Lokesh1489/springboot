package com.nc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nc.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImplementation implements IEmployeeDAO {

	private static final String GET_EMPLOYEE_BY_DEIGNATION = "select * from employee where designation in(?,?,?) order by designation";

	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEMployeeByDesignation(String designation1, String designation2, String designation3)
			throws Exception {
		System.out.println("EmployeeDAOImplementation.getEMployeeByDesignation() :: ds" + ds.getClass());
		List<Employee> employeeList = null;

		// get pooled jdbc connection object
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_EMPLOYEE_BY_DEIGNATION)) {
			ps.setString(1, designation1);
			ps.setString(2, designation2);
			ps.setString(3, designation3);

			try (ResultSet rs = ps.executeQuery()) {
				employeeList = new ArrayList<Employee>();

				while (rs.next()) {
					// copy each records of result set to EMployee Object
					Employee employee = new Employee();
					employee.setENo(rs.getInt("e_no"));
					employee.setEName(rs.getString("e_name"));
					employee.setEAddress(rs.getString("e_address"));
					employee.setDesignation(rs.getString("designation"));
					employee.setSalary(rs.getDouble("salary"));
					employee.setDeptNo(rs.getInt("dept_no"));

					employeeList.add(employee);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return employeeList;
	}
}