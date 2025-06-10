package Bank;

import java.util.*;

abstract class BankAccount {
	//initializes random variable
	private static final Random rng = new Random();
	//has a database of bank accounts
	private static final Map<Long,BankAccount> accounts = new HashMap<Long,BankAccount>();
	//amount of money in account
	public double balance;
	//id of account
	public  long id;
	//name of owner of account
	public String name;
	
	/*
	 * precondition: requires name != null && amount > 0;
	 * ensures this.name == name && balance == amount && id == Math.abs(rng.nextLong());
	 */
	public BankAccount(double amount, String name) {
		Objects.requireNonNull(name);
		if(amount < 0) {
			throw new IllegalArgumentException();
		}
		this.setBalance(amount);
		this.name = name;
		boolean idAssigned = false;
		while (!idAssigned) {
			this.id = Math.abs(BankAccount.rng.nextLong());
			if (!BankAccount.accounts.containsKey(this.id)) {
				BankAccount.accounts.put(this.id, this);
				idAssigned = true;
			}
		}
	}
	
	public /* pure */ long getId() {
		return id;
	}


	public /* pure */ double getBalance() {
		return balance;
	}

	public void setBalance(double amount) {
		this.balance = amount;
	}

	public /* pure */ String getName() {
		return name;
	}


	/*
	 * requires amount > 0
	 * ensures \result == balance == \old(balance) + amount
	*/
	public void deposit(double amount) {
		this.setBalance(this.balance + amount);
	}
	
	/*
	 * requires amount > 0
	 * ensures \result == balance == \old(balance) - amount
	*/
	public void withdraw(double amount) {
		this.setBalance(this.balance - amount);
	}
	
	public abstract void transfer(double amount, BankAccount other);

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(accounts, other.accounts)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(name, other.name);
	}
	
	
}