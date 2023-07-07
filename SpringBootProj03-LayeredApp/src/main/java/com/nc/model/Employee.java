package com.nc.model;

import lombok.Data;

@Data
public class Employee {
	private Integer eNo;
	private String eName;
	private String eAddress;
	private String designation;
	private Double salary;
	private Integer deptNo;
}