class Consumer implements Runnable {
	Q q;
	Consumer ( Q q ) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	public void run () {
		while (true) {
			q.consume();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
 	}

}