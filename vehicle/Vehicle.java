class Vehicle {
	protected String RegNo;
	protected int Speed;
	protected String color;
	protected String owner;
	
	void showData () {
		System.out.println("Reg No : " + RegNo);

		System.out.println("Top Speed : " + Speed);

		System.out.println("Color : " + color);
		System.out.println("Owner : " + owner);
	}
}