package com.johnny.deptemp.dao;

import java.util.List;

import com.johnny.deptemp.entity.Employee;

public interface EmployeeDAO {
	void save(Employee emp);
	
	List<Employee> findAllEmployees();

}
