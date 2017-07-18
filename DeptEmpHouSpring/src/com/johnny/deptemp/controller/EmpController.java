package com.johnny.deptemp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnny.deptemp.entity.Employee;
import com.johnny.deptemp.service.DepartmentService;
import com.johnny.deptemp.service.EmployeeService;

@Controller
public class EmpController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentService deptService;
	
	@RequestMapping("/showAddEmp")
	public String showAddEmp(HttpServletRequest request) {
		request.getServletContext().setAttribute("allEmp", empService.loadEmpBasicInfo());
		request.getServletContext().setAttribute("allDept", deptService.loadDeptBasicInfo());
		return "addEmployee";
	}
	
	@RequestMapping("/addEmp")
	public String addEmp(HttpServletRequest request, ModelMap model, 
			@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam int department ) {
		
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setAge(age);
		emp.setDept(empService.findDeptById(department));
		empService.saveEmp(emp);
		empService.loadEmpBasicInfo();
		request.getServletContext().setAttribute("allEmp", empService.loadEmpBasicInfo());
		request.getServletContext().setAttribute("allDept", deptService.loadDeptBasicInfo());
		return "addEmployee";
	}

}
