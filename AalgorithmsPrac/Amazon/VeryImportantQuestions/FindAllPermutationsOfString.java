package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.List;

public class FindAllPermutationsOfString {
	
	public static List<String> findPermutations(String str) {
		List<String> permutations = new ArrayList<String>();
		permutations.add(new String());
		char[] charArray = str.toCharArray();
		int count = 0;
		for(char c: charArray) {
			List<String> temp = new ArrayList<String>();
			for(String s: permutations) {
				for(int i=0; i <= s.length(); i++) {
					count++;
					String s1 = s.substring(0,i) + c + s.substring(i);
					System.out.println(s1);
					temp.add(s1);
				}
//				temp.add(s+c);
//				System.out.println(s+c);
			}
			permutations = temp;
		}
		System.out.println(count);
		System.out.println(permutations.size());
		return permutations;
	}
	
	public static void main(String[] args) {
		System.out.println(findPermutations("abc"));
	}
}
