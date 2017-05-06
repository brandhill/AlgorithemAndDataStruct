package VeryImportantQuestions;

import java.util.HashSet;
import java.util.Set;

public class CheckIFUniqueCharacterWithinKCharacters {
	
	static boolean checkIfDuplicateCharactersExits(String s, int k) {
		
		Set<Character> set = new HashSet<Character>();
		
		for(int i=0; i<s.length(); i++) {
			if(i>k-1) {
				set.remove(s.charAt(i-k));
			}
			if(set.contains(s.charAt(i)))
				return false;
			set.add(s.charAt(i));
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkIfDuplicateCharactersExits("ancdbwdsfgd",3));
	}
}
