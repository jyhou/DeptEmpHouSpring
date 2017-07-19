package com.johnny.deptemp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.johnny.deptemp.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Department dept) {
		em.persist(dept);
	}

	@Override
	public List<Department> findAllDepartment() {
		Query query = em.createQuery("SELECT OBJECT(d) FROM Department d JOIN FETCH d.deptEmpList");
		return query.getResultList();
	}

	@Override
	public List<Department> findBasicDeptInfo() {
		return em.createNamedQuery("getAllDept").getResultList();
	}

	@Override
	public Department findDepartmentById(int deptId) {
		return em.find(Department.class, deptId);
	}

}
