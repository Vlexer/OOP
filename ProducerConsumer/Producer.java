class Producer implements Runnable {
	Q q;
	Producer ( Q  q ) {
		this.q = q;
		new Thread(this, "Producer").start();
	}
	public void run () {
		int i = 0;
		while (i < 100) {
			q.produce(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}