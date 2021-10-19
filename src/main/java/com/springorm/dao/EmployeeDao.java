package com.springorm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.entity.Employee;

public class EmployeeDao {

	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int Insert(Employee employee) {
		Integer i = (Integer) this.hibernateTemplate.save(employee);
		return i;

	}

	@Transactional
	public Employee getEmployee(int id) {
		Employee employee = this.hibernateTemplate.get(Employee.class, id);
		return employee;

	}

	@Transactional
	public List<Employee> getAllEmployees() {
		List<Employee> employees = this.hibernateTemplate.loadAll(Employee.class);
		return employees;

	}

	@Transactional
	public void deleteStudent(int id) {
		Employee employee = this.hibernateTemplate.get(Employee.class, id);
		this.hibernateTemplate.delete(employee);
	}

	/*
	 * @Transactional public void updateEmployee(int id) {
	 * 
	 * this.hibernateTemplate.saveOrUpdate(Employee.class);
	 * 
	 * }
	 */

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
