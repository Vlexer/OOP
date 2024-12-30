import java.io.*;

class Demo {
	public static void main (String [] args) {
		Employee e1 = new Employee("Sivasu", "Hr", 2323223);
		Employee e2 = new Employee("Sai", "DOPS", 234312);
		Employee e3 = new Employee("JOnesy", "Rickets", 312);

		try (FileOutputStream fos = new FileOutputStream("data.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Employee [] list = { e1, e2, e3 };
		for ( Employee e : list ) {
			oos.writeObject(e);	
		}
		} catch (Exception e) 
		{
			e.printStackTrace();	
		}
		
		
		
	}
}