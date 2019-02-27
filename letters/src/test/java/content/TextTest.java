package content;

import static org.junit.Assert.*;


import org.junit.Test;

public class TextTest {

	@Test
	public void testGetContent() {
		Text text = new Text("This is a text");
		assertEquals("This is a text",text.getContent());
		
	}

}
