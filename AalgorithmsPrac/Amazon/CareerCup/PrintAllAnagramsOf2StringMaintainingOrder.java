package CareerCup;

import java.util.HashSet;
import java.util.Set;

// https://www.careercup.com/question?id=6254587007729664

public class PrintAllAnagramsOf2StringMaintainingOrder {
	
	static Set<String> AllPossibleAnagrams(String s1, String s2) {
		
		Set<String> set = new HashSet<String>();
		for(int i=0; i<=s1.length(); i++) {
			System.out.println(i);
				for(int j=0; j<=s2.length(); j++) {
						String s = s1.substring(0,i)+s2.substring(0,j)+s1.substring(i)+s2.substring(j);
						System.out.println(s);
						if(!set.contains(s)) {
							set.add(s);
						}
			}
		}
		System.out.println(set.size());
		return set;
		
	}
	
	public static void main(String[] args) {
		System.out.println(AllPossibleAnagrams("ab","c"));
		
		String s ="abc";
		System.out.println("SubString " +s.substring(3));
	}
	
}
