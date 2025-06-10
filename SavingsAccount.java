package Bank;

public class SavingsAccount extends BankAccount {

	private final double interestRate = 0.02;
	public SavingsAccount(double amount, String name) {
		super(amount, name);
	}
	
	@Override
	public void transfer(double amount, BankAccount other) {
		// TODO Auto-generated method stub
		if(other != null) {
			if(amount > 0 && amount < other.getBalance()) {
				other.deposit(amount);
			}else {
				throw new IllegalArgumentException();
			}
		}else {
			throw new NullPointerException();
		}
		
	}
	
	// requires amount >= 1000
	@Override
	public void deposit(double amount) {
		if(amount >= 1000) {
			super.deposit(amount);
		}
	}
	
	
	
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		super.withdraw(amount);
	}

	private double interest() {
		return balance * interestRate;
	}
	
	public void addInterest() {
		balance += interest();
	}

}
