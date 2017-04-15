package VeryImportantQuestions;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithUniqueCharacters {
	
	static String findLongestSubstring(String s) {
		
		Set<Character> set = new HashSet<Character>();
		
		int slow = 0;
		int fast = 0;
		int len = 0;
		int start = 0;
		int end = 0;
		while(fast<s.length()) {
			char c = s.charAt(fast);
			
			while(set.contains(c) && slow < fast) {
				char c1 = s.charAt(slow);
				set.remove(c1);
				slow++;
			}
			
			set.add(c);
			if(fast-slow+1>len) {
				len = fast-slow+1;
				start = slow;
				end = fast;
			}
			fast++;
		}
		
		return s.substring(start, end+1);
	}
	
	static String findLongestSubstring1(String s) { 
		int slow = 0;
		int fast = 0;
		int len = 0;
		int start = 0;
		int end = 0;
		boolean[] set = new boolean[256];
		while(fast<s.length()) {
			char c = s.charAt(fast);
			while(set[c] && slow<fast) {
				char c1 = s.charAt(slow);
				set[c1] = false;
				slow++;
			}
			set[c] = true;	
			if(fast-slow+1>len) {
				len = fast-slow+1;
				start = slow;
				end = fast;
			}
			fast++;
		}
		
		return s.substring(start, end+1); 
	}
	
	public static void main(String[] args) {
		System.out.println(findLongestSubstring("abc12abjeba"));

		System.out.println(findLongestSubstring1("abc12abjeba"));
		System.out.println(findLongestSubstring("aaaaa"));
		System.out.println(findLongestSubstring1("aaaaa"));
	}
}
