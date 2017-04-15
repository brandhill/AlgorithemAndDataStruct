package VeryImportantQuestions;

import java.util.Set;

public class MissingSpaces {
	
	String addSpaces(Set<String> dictionary, String input) {
		
		StringBuffer output = new StringBuffer();
		for(int i = 0; i < input.length(); i++) {
			output.append(input.charAt(i));
			if(dictionary.contains(output.toString())) {
				if(output.length()==input.length())
					return output.toString();
				String nextString = addSpaces(dictionary,input.substring(i+1));
				if(nextString!=null) {
					return output.append(" "+nextString).toString();
				}
			}
		}
		
		return null;
	}
	
	public static void main(String[] params){
		
	}
}
