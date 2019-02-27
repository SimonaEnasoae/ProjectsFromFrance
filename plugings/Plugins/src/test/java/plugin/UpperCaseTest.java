package plugin;

import static org.junit.Assert.*;

import org.junit.Test;

public class UpperCaseTest {

	@Test
	public void testTransform() {
		UpperCase myUpperCase = new UpperCase();
		String text = "This is a test";
		String result = myUpperCase.transform(text);
		char ch[] = result.toCharArray();
		for(int i = 0; i<text.length(); i++) {
			if(ch[i]>='A' && ch[i]<='Z') {
				assertTrue(Character.isUpperCase(ch[i]));
			}
		}
	}

}
