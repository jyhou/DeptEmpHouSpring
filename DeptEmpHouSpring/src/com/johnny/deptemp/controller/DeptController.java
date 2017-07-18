package com.johnny.deptemp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.service.DepartmentService;
import com.johnny.deptemp.service.EmployeeService;

@Controller
public class DeptController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="/showAddDept")
	public String showAddDept(HttpServletRequest request) {
		request.getServletContext().setAttribute("allDept", deptService.loadDeptBasicInfo());
		request.getServletContext().setAttribute("allEmp", empService.loadEmpBasicInfo());
		return "addDepartment";
	}
	
	@RequestMapping(value="/addDept", method=RequestMethod.POST)
	public String showAddDept(HttpServletRequest request, @ModelAttribute("dept") Department dept) {//This applies Spring's auto data binding
//	public String showAddDept(HttpServletRequest request, @RequestParam String deptName, @RequestParam String deptEmail) {
//		Department dept = new Department();
//		dept.setDeptEmail(deptEmail);
//		dept.setDeptName(deptName);		
		
		try {
			deptService.saveDept(dept);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getServletContext().setAttribute("allDept", deptService.loadDeptBasicInfo());
		request.getServletContext().setAttribute("allEmp", empService.loadEmpBasicInfo());
		return "addDepartment";
	}
	

}
