class Octnum extends Num {
	Octnum (int num) {
		super(num);
	}
	void showNum () {
		String octal = Integer.toOctalString(num);
		System.out.println("In Octal notation  " + octal);	
	}
	public static void main (String [] args) {
		Octnum n1 = new Octnum(42);
		n1.showNum();		
	}
}