package plugin;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstCharSentenceToUppercaseTest {

	@Test
	public void testTransform() {
		FirstCharSentenceToUppercase firstCharToUpper = new FirstCharSentenceToUppercase();
		String text = "This is a test";
		String result = firstCharToUpper.transform(text);
		assertEquals(result, "This Is A Test");
	}

}
