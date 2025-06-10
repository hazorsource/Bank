package Bank;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount cheque = new ChequingAccount(50.00,"BOB");
		BankAccount cheque2 = new ChequingAccount(50.00,"BOB");
		
		cheque.deposit(125.25);
		System.out.print(cheque.getName());
		
	}

}
