import java.util.*;
class Shapes {
	static double Area ( double radius ) {
		return Math.PI * radius * radius; 
	}
	static double Area ( double l, double b ) {
		return l *b;
	}
	static double Area ( double s1, double s2, double s3 ) {
		double s = (s1 + s2 + s3)/2;
		double area = Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
		return area;
	}
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Circle 2. Rectangle 3. Triangle");
		int choice = sc.nextInt();
		while ( true ) {
			switch (choice) {
				case 1:
					System.out.println("Enter radius");
					double rad = sc.nextDouble();
					System.out.println("Area " + Area(rad));
					break;
				case 2:
					System.out.println("Enter length");
					double l = sc.nextDouble();								System.out.println("Enter breadth");
					double d = sc.nextDouble();
					System.out.println("Area " + Area(l, d));
					break;
				case 3:
					System.out.println("Enter side 1");
					double s1 = sc.nextDouble();
					System.out.println("Enter side2");
					double s2 = sc.nextDouble();
					System.out.println("Enter side 3");
					double s3 = sc.nextDouble();
					System.out.println("Area " + Area(s1, s2, s3));
					break;
			}
			System.out.println("Enter choice again");
			choice = sc.nextInt();
		}	
	}
}