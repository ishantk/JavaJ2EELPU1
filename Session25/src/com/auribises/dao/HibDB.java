package com.auribises.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.auribises.bean.Employee;


public class HibDB implements EmployeeHibDAO{
	

	SessionFactory sessionFactory;
	HibernateTemplate hibernate;
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		hibernate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveEmployee(Employee employee) {
		hibernate.save(employee);
	}

	@Override
	public Employee getEmployee(Integer eid) {
		List<Employee> employees = hibernate.find("From Employee where eid = "+eid);
		return employees.get(0);
	}

	@Override
	public List<Employee> listEmployees() {
		List<Employee> employees = hibernate.find("From Employee");
		return employees;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		hibernate.delete(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		hibernate.update(employee);
	}

}
