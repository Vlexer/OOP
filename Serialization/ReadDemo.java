import java.io.*;
import java.util.*;
class ReadDemo {
	
	public static void main (String [] args) {
		try (
			FileInputStream fis = new FileInputStream("data.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			ArrayList<Employee> list = new ArrayList<>();	
			
				
			while (true) {
				try {
					Employee e = (Employee)ois.readObject();
					list.add(e);
				} catch (EOFException e) {

					break;
				}
			}
			for ( Employee i : list ) {	
				System.out.println(i);
			} 
			int maxSalary = -1;Employee highest = null;
			for ( Employee e : list ) {
				if ( e.salary > maxSalary ) {
					maxSalary = e.salary;
					highest = e;
				}  
			} 
			System.out.println(highest);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}