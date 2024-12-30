import java.io.*;
import java.util.*;

class StudentMarks {

	public static void main (String args[]) {
		
		try (Scanner sc = new Scanner(new File("student.txt"));
		PrintWriter pw = new PrintWriter("Grades.txt");
		) {
			String input;
			while ( (input = sc.nextLine()) != null ) {
				String [] entry = input.split(" ");
				String name = entry[0];
				int mark = Integer.parseInt(entry[1]);
				String grade;
				if ( mark >= 85 && mark <= 100 ) grade = "Distinction";
				else if (mark >= 70) grade = "First Class";
				else if ( mark >= 50 ) grade = "Second Class";
				else grade = "Fail";
				String outputMessage = name + " " + grade;
				pw.println(outputMessage);
			}
		}catch( IOException e ) {
			System.out.println("Marks have been Graded");
		} catch(NoSuchElementException e) {
			System.out.println("Marks have been updated");
		}
	}	

}