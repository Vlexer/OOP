class Factorial {
	
	public static void main ( String [] args ) {
		int nArgs = args.length;
		try {
			String n = args[0];
			double no = Double.parseDouble(n);
			if ( no == 0 ) throw new IllegalArgumentException();
			double res = Math.sqrt(2 * Math.PI * no) * Math.pow((no/Math.E), no);
			System.out.println("Factorial of " + no + " is " + res);	
		} catch ( ArrayIndexOutOfBoundsException e ) {
			System.out.println("No Arguements are passed");
		} catch ( NumberFormatException e ) {
			System.out.println("Non Numeric value is not allowed");
		} catch ( IllegalArgumentException e ) {
			System.out.println(" 0! can be calculated but im forced to pass this exception");
		}
	}
}