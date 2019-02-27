package mocks;

import city.Inhabitant;
import content.Content;
import content.Text;
import content.letter.Letter;

public class MockLetter extends Letter<MockContent>{

	public boolean checkAction = false;
	
	public MockLetter(MockContent content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	@Override
	public float getCost() {
		return 0.9f;
	}

	@Override
	public void action() {
		checkAction = true;
		
	}

	
}
