package Bank;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class BankTest {
	
	
	BankAccount c = new ChequingAccount(20.00,"Bob");
	BankAccount c1 = new ChequingAccount(50.00,"Cob");

	
	@Test
	void testDeposit1() {
		c.deposit(30);
		assertEquals(c.getBalance(),c1.getBalance());
	}
	
	@Test
	void testTransfer() {
		c.transfer(30, c1);
		assertEquals(80.0,c1.getBalance());
	}
	
	
	

}
