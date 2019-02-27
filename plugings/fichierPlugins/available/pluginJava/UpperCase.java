package plugin;

public class UpperCase implements Plugin {
	
	public String st;
	
	public UpperCase() {
		
	}
	public String transform(String s) {
		
		return s.toUpperCase();
	}

	public String getLabel() {
		
		return "Upper case";
	}

	public String helpMessage() {
		return null;
	}

}
