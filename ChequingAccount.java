package Bank;
import java.util.*;
public class ChequingAccount extends BankAccount{
	private int transactionCount;
	private static final double TRANSACTION_FEE = 1.5;
	private static final int TRANSACTIONS = 4;
	public ChequingAccount(double balance, String name) {
		super(balance,name);
	}
	
	/*
	 * requires amount > 0
	 * ensures balance == /old(balance) - amount
	*/
	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		if(amount > 0)
			super.deposit(amount);
		else {
			throw new IllegalArgumentException();
		}
	}
	
	/*
	 * requires amount > 0 && amount <= balance
	 * ensures balance == /old(balance) + amount 
	 * ensures transactionCount == /old(transactionCount) + 1
	*/
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if(amount > 0 && amount <= balance) {
			super.withdraw(amount);
			transactionCount++;
		} else if(amount == TRANSACTION_FEE) {
			super.withdraw(TRANSACTION_FEE);
		}else {
			throw new IllegalArgumentException();
		}
		
	}
	
	/*
	 * requires other != null && amount > 0 && amount < other.getBalance()
	 * ensures 
	 */
	@Override
	public void transfer(double amount, BankAccount other) {
		// TODO Auto-generated method stub
		if(other != null) {
			if(amount > 0 && amount < other.getBalance()) {
				other.deposit(amount);
				transactionCount++;
			}else {
				throw new IllegalArgumentException();
			}
		}else {
			throw new NullPointerException();
		}
	}
	
	/*
	 *ensures transactionCount > TRANSACTIONS => balance == /old(balance) -  (transactionCount - TRANSACTION) * TRANSACTION_FEE
	 *ensures transactionCount == 0 
	 **/
	public void deductTransactions() {
		if(transactionCount > TRANSACTIONS) {
			for(int i = 4;i < transactionCount;i--) {
				setBalance(getBalance() - TRANSACTION_FEE);
			}
		}
		transactionCount = 0;
	}
	
	
	public final /*pure*/ int getTransactionCount() {
		return transactionCount;
	}
	
	
	@Override
	public String toString() {
		return "ChequingAccount [transactionCount=" + transactionCount + ", balance=" + balance + ", id=" + id
				+ ", name=" + name + "]";
	}
	
}
