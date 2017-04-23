package CareerCup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplitGivenStringIntoSentence {
	
	static List<String> SplitSentence(String str, Set<String> dict) {
		List<String> output = new ArrayList<String>();
		if(str==null || str.trim().length()==0)
			return output;
		SplitSentenceHelper(str, output, 0, dict);
		return output;
	}
	
	private static boolean SplitSentenceHelper(String str,List<String> output, int start, Set<String> dict) {
		if(start==str.length()) {
			return true;
		}
		
		for(int i = start; i<str.length(); i++) {
			String s = str.substring(start,i+1);
			if(dict.contains(s)) {
				if(SplitSentenceHelper(str, output, i+1, dict)) {
					output.add(s);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String str = "Thisisasentense";
		Set<String> dict = new HashSet<String>();
		dict.add("This");
		dict.add("Thi");
		dict.add("sisen");
		dict.add("asent");
		dict.add("is");
		dict.add("a");
		dict.add("sentense");
		System.out.println(SplitSentence(str, dict));
	}
	
}	
