package plugin;

public class LowerCase implements Plugin{

	public String transform(String s) {

		return s.toLowerCase();
	}

	public String getLabel() {
		
		return "Lower Case";
	}

	public String helpMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
