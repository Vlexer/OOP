class Complex {
	double realPart;
	double complexPart;
	
	public Complex ( double realPart, double complexPart ) {
		this.realPart = realPart;
		this.complexPart = complexPart;
	} 
	
	static Complex addComplexNumber ( Complex z1, Complex z2 ) {
		return new Complex(z1.realPart+z2.realPart, z1.complexPart + z2.complexPart);
	}
	public String toString () {
		return realPart + " + " + complexPart + "i";
	}
	public static void main ( String [] args ) {
		Complex z1 = new Complex(3.4, 2.3);
		Complex z2 = new Complex ( 5.6, 3.7 );
		System.out.println(z1);
		System.out.println(addComplexNumber(z1, z2));
	} 
}