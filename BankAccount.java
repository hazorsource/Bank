package Bank;

import java.util.*;

abstract class BankAccount {
	private static final Random rng = new Random();
	private static final Map<Long,BankAccount> accounts = new HashMap<Long,BankAccount>();

	public double balance;
	public  long id;
	public String name;
	public String address;
	
	public BankAccount(double amount, String name, String address) {
		Objects.requireNonNull(name);
		if(amount < 0) {
			throw new IllegalArgumentException();
		}
		this.setBalance(amount);
		this.name = name;
		this.address = address;
		boolean idAssigned = false;
		while (!idAssigned) {
			this.id = Math.abs(BankAccount.rng.nextLong());
			if (!BankAccount.accounts.containsKey(this.id)) {
				BankAccount.accounts.put(this.id, this);
				idAssigned = true;
			}
		}
	}
	
	public long getId() {
		return id;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double amount) {
		this.balance = amount;
	}

	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}
	
	public void deposit(double amount) {
		this.setBalance(this.balance + amount);
	}
	
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
		return Objects.equals(accounts, other.accounts) && Objects.equals(address, other.address)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(name, other.name);
	}
	
	
}