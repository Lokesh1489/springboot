package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDaoImpl implements IEmployeeDAO {

	private static final String GET_EMPS_BY_DESGS = "SELECT * FROM EMPLOYEE WHERE DESG IN(?,?,?) ORDER BY DESG";

	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEmployeesByDesignation(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeDaoImpl.getEmployeesByDesignation()::ds" + ds.getClass());
		List<Employee> list = null;
		// get pooled jdbc connection object
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS)) {
			// set the values to Query Parameters
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			try (ResultSet rs = ps.executeQuery()) {

				list = new ArrayList<>();
				while (rs.next()) {
					// copy each record of result set to Emplyoee Object
					Employee emp = new Employee();
					emp.setEno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setEaddrs(rs.getString(3));
					emp.setDesg(rs.getString(4));
					emp.setSalary(rs.getDouble(5));
					emp.setDeptno(rs.getInt(6));
					list.add(emp);
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return list;
		}

	}
}
