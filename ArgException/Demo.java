class Demo {
	public static void main (String args[]){
		try {
			int nArgs = args.length;
			if ( nArgs < 2 ) throw new CommandLineArgsException("Too Few Arguements Given");
			int n1 = Integer.parseInt(args[0]);
			int n2 = Integer.parseInt(args[1]);
			int res = n1 + n2;
			System.out.println("Sum of Arguements " + res);
		} catch ( CommandLineArgsException e ) {
			e.printStackTrace();
		}
	}
}