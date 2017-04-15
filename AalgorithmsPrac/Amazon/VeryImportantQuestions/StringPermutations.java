package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	
	static List<String> getPermutations(String input) {
		char[] chars = input.toCharArray();
		List<String> output = new ArrayList<String>();
		output.add("");
		for(int i=0; i < chars.length; i++) {
			List<String> temp = new ArrayList<String>();
			for(String s: output) {
				for(int j=0; j<s.length();j++) {
					String s1 = s.substring(0,j) + chars[i] + s.substring(j);
					temp.add(s1);
				}
				temp.add(s+chars[i]);
			}
			output = temp;
		}
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(getPermutations("abcd").size());
	}
}
