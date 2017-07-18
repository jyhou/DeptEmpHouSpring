package com.johnny.deptemp.dao;

import java.util.List;

import com.johnny.deptemp.entity.Department;

public interface DepartmentDAO {
	
	void save(Department dept);
	
	Department findDepartmentById(int deptId);
	List<Department> findAllDepartment();
	List<Department> findBasicDeptInfo();

}
