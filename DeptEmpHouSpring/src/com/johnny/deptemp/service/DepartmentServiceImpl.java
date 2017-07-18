package com.johnny.deptemp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.deptemp.dao.DepartmentDAO;
import com.johnny.deptemp.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDAO deptDAO;

	@Override
	@Transactional
	public void saveDept(Department dept) {
		deptDAO.save(dept);
	}

	@Override
	@Transactional
	public List<Department> loadDeptDetails() {
		return deptDAO.findAllDepartment();
	}

	@Override
	@Transactional
	public List<Department> loadDeptBasicInfo() {
		return deptDAO.findBasicDeptInfo();
	}

}
