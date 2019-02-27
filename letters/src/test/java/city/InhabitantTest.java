package city;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import content.Content;
import content.Money;
import content.letter.*;
import mocks.MockContent;
import mocks.MockLetter;
import mocks.MockLetterSendAnotherLetter;

import org.junit.Test;

public class InhabitantTest {

	public Inhabitant createInhabitant(float amount) {
		List<Letter<?>> mailbox = new ArrayList<Letter<?>>();
		List<Inhabitant> inhabitantsList = new ArrayList<Inhabitant>();
		List<String> streets = new ArrayList<String>();
		String rezDeChaussee = "rez de Chausee";
		String AnneJosepheDuBourg = "Anne Josephe Du Bourg";
		streets.add(rezDeChaussee);
		streets.add(AnneJosepheDuBourg);
		City lille = new City(mailbox, "Lille", inhabitantsList, streets);
		Account account1 = new Account(amount, "FR502478");
		Account account2 = new Account(amount, "FR502479" );
		Inhabitant inhabitant1 = new Inhabitant(lille, account1, "Maria");
		Inhabitant inhabitant2 = new Inhabitant(lille, account2, "Marcel");
		inhabitantsList.add(inhabitant1);
		inhabitantsList.add(inhabitant2);
		
		return inhabitant1;
	}
	
	@Test
	public void testSendLetter() {
		
		Inhabitant sender = createInhabitant(5.5f);
		Inhabitant receiver = createInhabitant(10.5f);
		Letter<MockContent> letter = new MockLetter(new MockContent("Bonjour"), sender, receiver);
		Float prix = letter.getCost();
		Float beforeSendingAmount = sender.getAccount().getAmount();
		sender.sendLetter(letter);
		
		assertTrue(receiver.getCity().getMailbox().contains(letter));
		assertEquals(beforeSendingAmount-prix, sender.getAccount().getAmount(), 0);
	}

	@Test (expected = NotEnoughMoneyException.class)
	public void testSendLetterException() {
		Inhabitant inhabitant1 = createInhabitant(0.0f);
		Inhabitant inhabitant2 = createInhabitant(10.5f);
		Letter<MockContent> letter = new MockLetter(new MockContent("Bonjour"), inhabitant1, inhabitant2);
		inhabitant1.sendLetter(letter);
	}
	
	@Test
	public void testReceiveLetter() {
		Inhabitant sender = createInhabitant(5.5f);
		Inhabitant receiver = createInhabitant(10.5f);
		MockLetterSendAnotherLetter letter= new MockLetterSendAnotherLetter(new MockContent("Bonjour"), sender, receiver);
		int mailBoxSizeBefore = sender.getCity().getMailbox().size();
		receiver.receiveLetter(letter);
		int mailBoxSizeAfter = sender.getCity().getMailbox().size();
		assertEquals(mailBoxSizeBefore+1,mailBoxSizeAfter);
	}

	@Test
	public void testDebitFloat() {
		Inhabitant inhabitant = createInhabitant(5.5f);
		float inhabitantAcountBefore = inhabitant.getAccount().getAmount();
		float debitAmount = 2.3f;
		inhabitant.debit(debitAmount);
		assertEquals(inhabitantAcountBefore - debitAmount, inhabitant.getAccount().getAmount(), 0);
	}

	@Test
	public void testCreditFloat() {
		Inhabitant inhabitant = createInhabitant(60.3f);
		float creditAmount = 50.1f;
		float inhabitantAcountBefore = inhabitant.getAccount().getAmount();
		inhabitant.credit(creditAmount);
		assertEquals(inhabitantAcountBefore + creditAmount, inhabitant.getAccount().getAmount(), 0);
		
	}

	@Test
	public void testDebitMoney() {
		Inhabitant inhabitant = createInhabitant(30.2f);
		float inhabitantAccountBefore = inhabitant.getAccount().getAmount();
		float amount = 20.9f;
		Money debitAmount = new Money(amount);
		inhabitant.debit(debitAmount);
		float inhabitantAccountAfter = inhabitant.getAccount().getAmount();
		assertEquals(inhabitantAccountBefore - amount, inhabitantAccountAfter, 0 );
	}

	@Test
	public void testCreditMoney() {
		Inhabitant inhabitant = createInhabitant(15.7f);
		float inhabitantAccountBefore = inhabitant.getAccount().getAmount();
		float amount = 75.9f;
		Money creditAmount = new Money(amount);
		inhabitant.debit(creditAmount);
		float inhabitantAccountAfter = inhabitant.getAccount().getAmount();
		assertEquals(inhabitantAccountBefore - amount, inhabitantAccountAfter, 0 );
	}

}
