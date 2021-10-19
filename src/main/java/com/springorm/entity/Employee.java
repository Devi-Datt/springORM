package com.springorm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Name;
	private String City;
	private String Salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", City=" + City + ", Salary=" + Salary + "]";
	}

	public Employee(int id, String name, String city, String salary) {
		super();
		this.id = id;
		Name = name;
		City = city;
		Salary = salary;
	}

	public Employee() {
		super();
	}

}
