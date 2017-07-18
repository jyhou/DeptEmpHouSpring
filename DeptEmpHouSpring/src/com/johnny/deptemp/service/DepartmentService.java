package com.johnny.deptemp.service;

import java.util.List;

import com.johnny.deptemp.entity.Department;

public interface DepartmentService {
	
	public void saveDept(Department dept);
	
	public List<Department> loadDeptDetails();
	public List<Department> loadDeptBasicInfo();

}
