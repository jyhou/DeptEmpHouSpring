package com.johnny.deptemp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.deptemp.dao.DepartmentDAO;
import com.johnny.deptemp.dao.EmployeeDAO;
import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	DepartmentDAO departmentDAO;
	

	@Override
	public List<Employee> loadEmpBasicInfo() {
		return employeeDAO.findAllEmployees();
	}


	@Override
	@Transactional
	public void saveEmp(Employee emp) {
		employeeDAO.save(emp);
	}


	@Override
	public Department findDeptById(int deptId) {
		return departmentDAO.findDepartmentById(deptId);
	}

}
