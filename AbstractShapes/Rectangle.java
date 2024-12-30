class Rectangle extends Shapes {

	double l;
	double d;
	public Rectangle ( double l, double d ) {
		this.l = l;
		this.d = d;
	}
	double Area() {
		return l * d;
	}
	boolean compare(Shapes obj) {
		return obj.Area() == this.Area();
	}
}
