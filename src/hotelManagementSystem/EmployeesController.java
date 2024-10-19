package hotelManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesController {

	public static void addNewEmployee(ArrayList<Employee> employees,Scanner input) {
		System.out.println("Enter name: ");
		String name = input.next();
		System.out.println("Enter salary (double) :  ");
		double salary = input.nextDouble();
		System.out.println("Enter job type (string): ");
		String job = input.next();
		int id = employees.size();
		Employee employee = new Employee(id,name,salary,job);
		employees.add(employee);
		System.out.println("Employee added succesfully! ");
		
	}
	
	public static void showAllEmployees(ArrayList<Employee> employees) {
		for (Employee employee : employees) {
			employee.print();
		}
	}
	
	public static void editEmployeeData(ArrayList<Employee> employees,Scanner input) {
		System.out.println("Enter id (int) \n-1 to show all employees");
		int id = input.nextInt();
		if(id == -1) {
			showAllEmployees(employees);
			System.out.println("Enter id (int): ");
			id = input.nextInt();
		}
		
		Employee employee = employees.get(id);
		System.out.println("Enter name (String) \n-1 to keep it");
		String name = input.next();
		if (name.equals("-1")) {
			name=employee.getName();
		}
		
		System.out.println("Enter salary (Double): \n-1 to keep it");
		double salary = input.nextDouble();
		if (salary == -1) {
			salary = employee.getSalary();
		}
		
		System.out.println("Enter job (String) \n-1 to keep it");
		String job = input.next();
		if (job.equals("-1")) {
			job = employee.getJob();
		}
		
		employee.setJob(job);
		employee.setName(name);
		employee.setSalary(salary);
		employees.set(id, employee);
		
		System.out.println("Employee edited succesfully!");
		
	}
	
	
}
