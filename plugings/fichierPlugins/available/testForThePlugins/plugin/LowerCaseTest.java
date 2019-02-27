package plugin;

import static org.junit.Assert.*;

import org.junit.Test;

public class LowerCaseTest {

	@Test
	public void testTransform() {
		LowerCase myLowerCase = new LowerCase();
		String text = "THIS IS A TEST";
		String result = myLowerCase.transform(text);
		assertEquals(result, "this is a test");
		//char ch[] = text.toCharArray();
		
		/*for(int i = 0; i<text.length(); i++) {
			if(ch[i]>='A' && ch[i]<='Z') {
				assertTrue(Character.isUpperCase(ch[i]));
			}
		}
		*/
	}

}
