import java.util.*;

class BankAccount {
	String Name;
	long AccNo;
	double Balance;
	ArrayList<String> Transaction;
	BankAccount ( String name, long accno, double bal ) {
		Name = name;
		AccNo = accno;
		Balance = bal;
		Transaction = new ArrayList<>();
		Transaction.add("Account created with Balance : " + bal);
	}
	void deposit(double amt) {
		if ( amt > 0 ) {
			Balance += amt;
			Transaction.add("Deposited Rs " + amt);
		} else {
			System.out.println("Invalid deposit amt");
		}
	}
	void withdraw ( double amt ) {
		if ( amt > 0 && amt <= Balance ) {
			Balance -= amt;
			Transaction.add("Withdrawn  Rs " + amt);
		} else {
			System.out.println("InSufficient creds");
		}
	}
	void generateBankStatement() {
		System.out.println("Bank Statement for Account Number " + AccNo);
		for ( String t : Transaction ) {
			System.out.println(t);
		}
	}
	public static void main ( String [] args ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter acc holder name");
		String name = sc.nextLine();
		System.out.println("Enter acc No");
		Long acc = sc.nextLong();
		System.out.println("Enter acc balance");
		double Bal = sc.nextDouble();
		
		BankAccount acc1 =new BankAccount(name, acc, Bal);
		
		while (true ) {
			System.out.println("1. Deposit 2. Withdraw 3 to bank Statement");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter amt to deposit");
					double amt1 = sc.nextDouble();
					acc1.deposit(amt1);
					break;
				case 2: 
					System.out.println("Enter amt to Withdraw");
					double amt = sc.nextDouble();
					acc1.withdraw(amt);
					break;
				case 3:
					acc1.generateBankStatement();
				
			}	
		}
	}
}