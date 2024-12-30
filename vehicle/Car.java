class Car extends Vehicle  {
	private String Manufacturer;
	
	Car ( String RegNo, int Speed, String color, String owner, String manufacturer ){
		this.RegNo = RegNo;
		this.color = color;
		this.Speed = Speed;
		this.owner = owner;
		this.Manufacturer = manufacturer;
	}
	
	void showData () {
		super.showData();
		System.out.println("Manufacturer : " + Manufacturer);
	}

	public static void main (String [] args) {
		new Car("TN64B971", 150, "Blue", "Sivasu", "Suzuki").showData();
	}
}