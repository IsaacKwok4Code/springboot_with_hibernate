package com.yin4learn.springboot.hibernate.hibernate_api.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yin4learn.springboot.hibernate.hibernate_api.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	//constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);//hibernate session
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save employee
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
				
		theQuery.executeUpdate();
		
	}

}
