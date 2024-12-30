class Employee {
	String name;
	String designation;
	int salary;
	public Employee ( String n, String des, int s ) {
		name = n;
		designation = des;
		if ( s >= 0 )
			salary = s;
		else salary = 0;
	} 
	static Employee find ( Employee [] list ) {
		int max = -1;
		Employee highest = null;
		for ( Employee e : list ) {
			if ( e.salary > max ) {
				max = e.salary; highest = e;
			}
		}
		return highest;
	} 
	public String toString () {
		String s = "Name :" + name + "\n Salary : " + salary;
		return s;
		} 
	public static void main ( String args [] ) {
		Employee e1 = new Employee("Sivasu", "HR", 450000);
		Employee e2 = new Employee("Ponajay", "HR", 45000);
		Employee e3 = new Employee("Sai ", "HR", 4590000);
		Employee e4 = new Employee("Kanishk", "HR", 45045000);
		Employee [] list = { e1, e2, e3, e4 };
		System.out.println(find(list));
	}  
}