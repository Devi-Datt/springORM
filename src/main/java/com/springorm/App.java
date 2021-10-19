package com.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.EmployeeDao;
import com.springorm.entity.Employee;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/springorm/config.xml");
		EmployeeDao eDao = context.getBean("employeeDao", EmployeeDao.class);

//Insert Data In DataBases.....		
		/*
		 * Employee employee = new Employee();
		 * 
		 * employee.setName("Lalit Parsad joshi "); employee.setSalary("20000");
		 * employee.setCity("Faridabad..");
		 * 
		 * int insert = eDao.Insert(employee);
		 * System.out.println("The Number of added student is: "+insert);
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("==========================");
			System.out.println("Press 1 for add new Employee:");
			System.out.println("Press 2 for Display all Employee:");
			System.out.println("Press 3 for get Details for single Employee:");
			System.out.println("Press 4 for delete Employee:");
			System.out.println("Press 5 for update Employee:");
			System.out.println("press 6 for exit:");

			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					System.out.println("Enter Your Name:");
					String emp_name = br.readLine();

					System.out.println("Enter Your Salary:");
					String emp_salary = br.readLine();

					System.out.println("Enter Your City:");
					String emp_city = br.readLine();

					Employee emp = new Employee();
					emp.setName(emp_name);
					emp.setSalary(emp_salary);
					emp.setCity(emp_city);

					int result = eDao.Insert(emp);
					System.out.println(result);

					System.out.println("+++++++++++++++++++++++++++++++++");
					break;

				case 2:
					List<Employee> employees = eDao.getAllEmployees();
					for (Employee emp1 : employees) {
						System.out.println("emp_Name:" + emp1.getName());
						System.out.println("emp_Salary:" + emp1.getSalary());
						System.out.println("emp_City:" + emp1.getCity());

						System.out.println("+++++++++++++++++++++++++++++++++");
						break;
					}
				case 3:
					System.out.println("Enter Your Id:");
					int emp_id = Integer.parseInt(br.readLine());
					Employee emp2 = eDao.getEmployee(emp_id);

					System.out.println("emp_Name:" + emp2.getName());
					System.out.println("emp_salary:" + emp2.getSalary());
					System.out.println("emp_city:" + emp2.getCity());
					break;

				case 4:
					System.out.println("Enter Your id:");
					int id = Integer.parseInt(br.readLine());
					eDao.deleteStudent(id);
					System.out.println("Employee Deleted...");
					break;
				/*
				 * case 5: System.out.println("Enter Your Id:"); int id1 =
				 * Integer.parseInt(br.readLine());
				 * 
				 * System.out.println("Enter Your Name:"); String name = br.readLine();
				 * 
				 * System.out.println("Enter Your salary:"); String salary = br.readLine();
				 * 
				 * System.out.println("Enter your city:"); String city = br.readLine();
				 * 
				 * Employee emp3 = new Employee();
				 * 
				 * emp3.setName(name); emp3.setSalary(salary); emp3.setCity(city);
				 * eDao.updateEmployee(id1);
				 */
				case 6:
					go = false;
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}