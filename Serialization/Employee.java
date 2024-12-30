import java.io.*;
class Employee implements Serializable{
	String name;
	String desig;
	int salary;
	Employee ( String name, String desig, int salary ) {
		this.name = name;
		this.desig = desig;
		this.salary = salary;
	}
	public String toString () {
		return "Name : " + name + " Designation : " + desig + " Salary : " + salary;
	}
	
}