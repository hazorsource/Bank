package Bank;

public class SavingsAccount extends BankAccount {

	private final double interestRate = 0.02;
	public SavingsAccount(double amount, String name) {
		super(amount, name);
	}
	
	/*
	 * requires amount > 0 && amount < other.getBalance() && other != null
	 * ensures other.getBalance = /old(ohter.getBalance) + amount && balance == /old(balance) - amount
	 * */
	@Override
	public void transfer(double amount, BankAccount other) {
		// TODO Auto-generated method stub
		if(other != null) {
			if(amount > 0 && amount < other.getBalance()) {
				withdraw(amount);
				other.deposit(amount);
			}else {
				throw new IllegalArgumentException();
			}
		}else {
			throw new NullPointerException();
		}
		
	}
	
	/*
	 * ensures amount >= 1000 -> balance == /old(balance) + amount
	 * */
	@Override
	public void deposit(double amount) {
		if(amount >= 1000) {
			super.deposit(amount);
		}
	}
	
	
	//ensures balance == /old(balance) - amount
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		super.withdraw(amount);
	}

	private double interest() {
		return /*pure*/ balance * interestRate;
	}
	
	//ensures balance == balance + balance * interestRate
	public void addInterest() {
		balance += interest();
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + ", balance=" + balance + ", id=" + id + ", name=" + name
				+ "]";
	}
	
}
