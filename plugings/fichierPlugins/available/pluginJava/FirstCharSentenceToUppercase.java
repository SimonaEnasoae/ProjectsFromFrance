package plugin;

public class FirstCharSentenceToUppercase implements Plugin{

	public String transform(String s) {
		
			
		char ch[] = s.toCharArray(); 
        for (int i = 0; i < s.length(); i++) { 
  
            // If first character of a word is found 
            if (i == 0 && ch[i] != ' ' ||  
                ch[i] != ' ' && ch[i - 1] == ' ') { 
  
                // If it is in lower-case 
                if (ch[i] >= 'a' && ch[i] <= 'z') { 
  
                    // Convert into Upper-case 
                    ch[i] = (char)(ch[i] - 'a' + 'A'); 
                } 
            } 
  
            // If apart from first character 
            // Any one is in Upper-case 
            else if (ch[i] >= 'A' && ch[i] <= 'Z')  
  
                // Convert into Lower-Case 
                ch[i] = (char)(ch[i] + 'a' - 'A');             
        } 
  
        // Convert the char array to equivalent String 
        String st = new String(ch); 
        return st; 
		
	}

	public String getLabel() {
		
		return "First char sencence uppercase";
	}

	public String helpMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
