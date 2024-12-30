class Circle extends Shapes {

	double radius;
	public Circle ( double radius ) {
		this.radius = radius;
	}

	double Area () {
		return Math.PI * radius * radius;
	}

	boolean compare ( Shapes obj ) {
		return obj.Area() == this.Area();
	}
}
