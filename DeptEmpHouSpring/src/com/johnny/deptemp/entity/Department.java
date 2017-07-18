package com.johnny.deptemp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "department")
@NamedQueries({
@NamedQuery(name = "getAllDept", query = "SELECT OBJECT(d) from Department d"),
//@NamedQuery(name = "getAllDeptWithEmp", query = "SELECT OBJECT(d) from Department d JOIN FETCH d.employeeList")
})
public class Department implements Serializable{
	
	private static final long serialVersionUID = -7199682586906824076L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private Integer deptId;
	
	@Column(name = "dept_name", length = 100)
	private String deptName;
	
	@Column(name = "dept_email", length = 150, nullable = false)
	private String deptEmail;
	
	@OneToMany(mappedBy = "empDept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employee> deptEmpList;
	
	public Department(){
		
	}
	
	public Department(Integer deptId, String deptName, String deptEmail, List<Employee> deptEmpList){
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptEmail = deptEmail;
		this.deptEmpList = deptEmpList;
	}
	
	public String getDeptName(){
		return deptName;
	}
	public void setDeptName(String deptName){
		this.deptName = deptName;
	}
	
	public String getDeptEmail(){
		return deptEmail;
	}
	public void setDeptEmail(String deptEmail){
		this.deptEmail = deptEmail;
	}
	
	public List<Employee> getDeptEmpList(){
		return deptEmpList;
	}
	public void setDeptEmpList(ArrayList<Employee> deptEmpList){
		this.deptEmpList = deptEmpList;
	}
	
	public Integer getDeptId(){
		return deptId;
	}
	public void setDeptId(Integer deptId){
		this.deptId = deptId;
	}
	
	@Override
	public boolean equals(Object deptObj){
		if(deptObj instanceof Department){
			return ((Department) deptObj).deptName.equalsIgnoreCase(this.deptName) &&
					((Department) deptObj).deptEmail.equalsIgnoreCase(this.deptEmail);
		}else{
			return false;
		}
	}

}
