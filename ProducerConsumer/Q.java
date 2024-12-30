class Q {
	boolean valueSet = false;
	int n;
	synchronized int consume (){
		while ( !valueSet ) {
			try {
				wait();
			} catch(InterruptedException e ) {
				System.out.println(e);
			}
		}
		System.out.println("Got : "+n);
		valueSet = false;
		notify();
		return n;
	}
	synchronized void produce ( int n ) {
		while ( valueSet ) {
			try { wait(); }
			catch ( InterruptedException e ) { e.printStackTrace(); }
		}
		this.n = n;
		valueSet = true;
		System.out.println("Put  : "+ n);
		notify();
	}
}