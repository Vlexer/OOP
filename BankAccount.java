class BankAccount {
	double balance;
	public BankAccount ( double amt ) {
		balance =  amt;
	}
	public synchronized void checkBalance () {
		System.out.println(Thread.currentThread().getName() + " Balance : " + balance);
	}
	public synchronized void deposit ( double amount ) {
		if ( amount > 0 ) {
		bal
	} 
	}  
}