package com.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.DTO.Employee;

@Repository
public class EmployeeDAO
{
	@Autowired
	EntityManager manager;
	
	@Autowired
	EntityTransaction transaction;
	
	public void saveEmployee(Employee employee)
	{
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		
	}
	
	public Employee findEmployee(int id)
	{
		
		Employee e = manager.find(Employee.class, id);
		return e;
		
	}
	
	public void deleteEmployee(int id)
	{
		Employee employee = findEmployee(id);                     //find the obj first thn remove the obj.....find the cureent obj.....thn remove. 
		transaction.begin();
		manager.remove(employee);
		transaction.commit();
		
	}
	
	public void updateEmployee(Employee employee)
	{
		//Employee employee = findEmployee(id);                     //find the obj first thn remove the obj.....find the cureent obj.....thn remove. 
		transaction.begin();
		manager.merge(employee);
		transaction.commit();
	}

	public List<Employee> getAllEmployee()
	{
		Query q = manager.createQuery("select e from Employee e");
		List<Employee> employeelist = q.getResultList();
		return employeelist;
		
	}

}
