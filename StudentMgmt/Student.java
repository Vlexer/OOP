import java.util.*;
class Student extends Hostel implements Department {
	String studentName;
	String regNo;
	ArrayList<String> electiveSub;
	
	public Student ( String sName , String regNo, Hostel h,  ) {
		studentName = sName;
		this.regNo = regNo;
		electiveSub = new ArrayList<>();
	}  
	
	void addSubject ( String name  ) {
		electiveSub.add(name);
	} 
	void addSubject ( String [] name ) {
		for ( String sub : name ) {
			electiveSub.add(sub);
		}  
	}
	void PrintDetails () {
		System.out.println("Student Name " + studentName);
		System.out.println("Register Name " + regNo);
		System.out.println("Department " + deptName);
		System.out.println("Department Head " + deptHead);
		System.out.println("Hostel Name  " + name);
		System.out.println("Hostel Location " + location);
		System.out.println("Subjects ");
		for ( String sub : electiveSub ) {
			System.out.println(sub);
		}  
	
	}
	
}