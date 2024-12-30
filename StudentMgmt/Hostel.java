class Hostel {
	private String name;
	private String location;
	private int nRooms;
	public Hostel ( String name, String location, int nRooms ) {
		this.name = name;
		this.location = location;
		this.nRooms = nRooms;
	}
	String getName () {
		return name;
	}
	String getLocation ()  {
		return location;
	}
	String getNRooms () {
		return nRooms;
	}
	public String toString () {
		return "Name : " + name + " Location : " + " No of Rooms  " + nRooms;
	}

}
