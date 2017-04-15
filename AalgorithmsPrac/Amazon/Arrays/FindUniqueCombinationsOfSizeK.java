package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindUniqueCombinationsOfSizeK {
	
	static List<String> findUniqueCombinations(String s,int k) {
		

		if (k<=0 || k > s.length()) {
			return null;
		}
		List<String> output = new ArrayList<String>();
		
		
		findUniqueCombinationsHelper("",s,k,output);
		
		return output;
	}
	
	static void findUniqueCombinationsHelper(String prefix, String s, int k, List<String> list) {
		System.out.println(prefix+" "+s);
		if(prefix.length()==k) {
			list.add(prefix);
			return;
		}
		
		for(int i = 0; i < s.length(); i++) {
			findUniqueCombinationsHelper(prefix+s.charAt(i),s.substring(i+1),k,list);
		}
	}
	
	public static void main(String[] args) {
		findUniqueCombinations("ABCDE",3);
	}
}
