class Demo {
	public static void main ( String [] args ) {
		Circle c = new Circle (10);
		Rectangle r = new Rectangle(10, 10);
		System.out.println("Area of circle " + c.Area());

		if ( c.compare(r) ) {
			System.out.println("Shapes have same area");
		} else System.out.println("NOT SAME AREA");

	}
}
