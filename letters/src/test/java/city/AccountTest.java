package city;

import static org.junit.Assert.*;

import org.junit.Test;

import content.Money;

public class AccountTest {

	private Account createAccount(float amount, String iban) {
		return new Account(amount,iban);
	}
	@Test
	public void testGetAmount() {
		float amount = 12.6f;
		Account account = createAccount(amount, "iban1");
		assertEquals(amount, account.getAmount(), 0);
		
	}

	@Test
	public void testSetAmount() {
		float amount = 12.6f;
		Account account = createAccount(amount, "iban2");
		account.setAmount(amount);
		assertEquals(amount, account.getAmount(), 0);
		
	}

	@Test
	public void testDebit() {
		float amount = 10.5f;
		float debitAmount = 5f;
		Account account = createAccount(amount, "iban3");
		float amountBeforeDebit = account.getAmount();
		account.debit(debitAmount);
		assertEquals(amountBeforeDebit-debitAmount,account.getAmount(),0);
		
	}

	@Test
	public void testCredit() {
		float amount = 199.48f;
		float creditAmount = 40.52f;
		Account account = createAccount(amount, "iban4");
		float amountBefore = account.getAmount();
		account.credit(creditAmount);
		assertEquals(amountBefore+creditAmount, account.getAmount(),0);
	}

}
