class Bank {
	double amt;
	public Bank (double amt) {
		this.amt = amt;
	}
	public synchronized void getBalance () {
		System.out.println("Balance Amt is " + amt);
	}
	public synchronized void deposit (double dep) {
		if ( dep > 0 ) {
			amt += dep;
			System.out.println("Successfully deposited amt " + dep);
		} else {
			System.out.println("Not a valid deposit amt");
		}
	}
	public synchronized void withdraw (double withdraw) {
		if ( amt >= withdraw ) {
			amt -= withdraw;
			System.out.println("Withdrawn Rs" + withdraw);
		} else {
			System.out.println("Insufficient Balance");
		}
	}
	public static void main (String [] args) {
		Bank acc = new Bank(1000);
		Thread t1 = new Thread(() -> {
			acc.deposit(300);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acc.getBalance();
		});
		Thread t2 = new Thread(() -> {
			acc.withdraw(100);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acc.deposit(100);
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println("Error " + e);
		}

	}
} 