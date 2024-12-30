class DownCounter implements Runnable {
	public void run () {
		for ( int i = 10 ; i > 0; i-- ) {
			System.out.println("Downcounter " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}