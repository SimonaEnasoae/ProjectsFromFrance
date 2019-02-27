package content.letter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import city.Account;
import city.City;
import city.Inhabitant;
import content.Content;
import content.Money;
import content.Text;
import content.letter.simple.SimpleLetter;
import content.letter.simple.ThanksLetter;

public class BillOfExchangeTest extends LetterTest  {
	
	public Content createContent() {
		Money money = new Money(5.5f);
		return money;
	}
	
	public Letter createLetter(Content content, Inhabitant sender, Inhabitant receiver){
		return new BillOfExchange( (Money) content, sender, receiver);
	}
	
	@Test
	public void testGetCost() {
		Content money = createContent();
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		Letter billOfExchange = createLetter(money, sender, receiver);
		assertEquals(money, billOfExchange.getContent());
	}

	@Test
	public void testAction() {
		Content money = createContent();
		Inhabitant sender = createInhabitant();
		Inhabitant receiver = createInhabitant();
		float moneyBefore = receiver.getAccount().getAmount();
		BillOfExchange  billOfExchange = (BillOfExchange) createLetter(money, sender, receiver);
		billOfExchange.action();
		ThanksLetter thanksLetter = new ThanksLetter(receiver, receiver);
		float sendingThanksLetterCost = thanksLetter.getCost();
		Money moneyObject = (Money) money;
		assertEquals(moneyBefore+moneyObject.getContent()-sendingThanksLetterCost,receiver.getAccount().getAmount(), 0);
		
	}

}
