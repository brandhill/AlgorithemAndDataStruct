package CareerCup;

import java.util.HashSet;
import java.util.Set;

// https://www.careercup.com/question?id=5750775999365120

public class FindAllPalidromesOfGivenString {
	
	static Set<String> findAllPalindromeSubstrings(String input) {
		boolean[][] table = new boolean[input.length()][input.length()];
		Set<String> set = new HashSet<String>();
		for(int i=0;i < input.length(); i++) {
			set.add(input.charAt(i)+"");
			table[i][i] = true;
			if(i<input.length()-1 && input.charAt(i)==input.charAt(i+1)) {
				set.add(input.substring(i,i+2));
				table[i][i+1] = true;
			}
		}
		
		for(int k=3; k <= input.length(); k++) {
			for(int i=0; i<= input.length()-k; i++) {
			int j = k+i-1;
			if(table[i+1][j-1] && input.charAt(i)==input.charAt(j)) {
				set.add(input.substring(i,j+1));
				table[i][j] = true;
				}
			}
		}
		return set;	
	}
	
	public static void main(String[] args) {
		Set<String> set = findAllPalindromeSubstrings("abbacabbabba");
		System.out.println(set);
		Set<String> set1 = findAllPalindromeSubstrings("aabbaaab");
		System.out.println(set1);
	}
}
