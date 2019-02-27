package mocks;

import city.Inhabitant;
import content.Content;
import content.Text;
import content.letter.Letter;
import content.letter.simple.SimpleLetter;
import content.letter.simple.ThanksLetter;

public class MockLetterSendAnotherLetter extends Letter<MockContent>{

	public MockLetterSendAnotherLetter(MockContent content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}
	@Override
	public float getCost() {
		
		return 0.5f;
	}

	@Override
	public void action() {
		MockLetter letter = new MockLetter(new MockContent("Bonjour, ceci est un test"), receiver,sender);
		this.receiver.sendLetter(letter);
	}

}
