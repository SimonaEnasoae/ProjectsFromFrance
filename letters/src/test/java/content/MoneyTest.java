package content;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void testGetContent() {
		Float amount = 5.5f;
		Money money = new Money(amount);
		assertEquals(amount,money.getContent());
	}

}
