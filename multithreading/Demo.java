class Demo {
	public static void main (String [] args){
		Thread t1 = new Thread(new UpCounter());
		Thread t2 = new Thread(new DownCounter());

		t1.start();
		t2.start();
		
	}
	
}