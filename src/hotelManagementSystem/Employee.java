package hotelManagementSystem;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String job;
	
	public Employee(int id,String name,double salary,String job) {
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.job=job;
	}

	//getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	public void print() {
		System.out.println("\n----------------");
		System.out.println("id"+id);
		System.out.println("name: "+name);
		System.out.println("Salary: "+salary);
		System.out.println("Job: "+job);
		System.out.println("----------------\n");

	}
	
}
