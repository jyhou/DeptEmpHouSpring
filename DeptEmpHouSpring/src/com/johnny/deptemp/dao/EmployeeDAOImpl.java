package com.johnny.deptemp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.johnny.deptemp.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext
	EntityManager em;
	

	@Override
	@Transactional
	public void save(Employee emp) {
		em.persist(emp);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Employee> findAllEmployees() {
		
		return em.createNamedQuery("getAllEmp").getResultList();
	}
	

}
