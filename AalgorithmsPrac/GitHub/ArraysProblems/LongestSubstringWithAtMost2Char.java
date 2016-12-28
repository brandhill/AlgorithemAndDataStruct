package ArraysProblems;

import java.util.HashMap;
import java.util.Map;


/**
 * Longest Substring with At Most Two Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 */

// Time - O(n)
// Space - O(1)
public class LongestSubstringWithAtMost2Char {
	
	static int SubstringWith2DistintChar(String s) {
		
		if(s.length()<=2) {
			System.out.println(s);
			return s.length();
		} 
		
		char[] chars = s.toCharArray();
		char first = chars[0];
		char second = chars[1];
		int start = 0;
		int end = 1;
		int maxLen = 2;
		String output = s.substring(0, 2);
		for(int i = 2; i < s.length(); i++) {
			System.out.println("i "+i);
			char c = chars[i];
			if(c==first || c==second) {
				end++;
			}
			else {
				second = chars[i];
				first = chars[i-1];
				start = i-1;
				end = i;
				while(start-1>=0) {
					System.out.println("start "+start);
					if(chars[start-1]!=chars[i-1]) {
						break;
					}
					else {
						start--;
					}
				}
			}
			
			if(end-start+1>=maxLen) {
				maxLen = end-start+1;
				output = s.substring(start, end+1);
			}
			//maxLen = Math.max(maxLen, end-start+1);
		}
		System.out.println(output);
		return maxLen;
	}
	
	public static void main(String[] args) {
		//int n = LongestSubstringWithAtMost2Char.SubstringWith2DistintChar("abcbbbbcccbdddadacb");
		int n = LongestSubstringWithAtMost2Char.SubstringWith2DistintChar("aaaaaaabbbbbbbcccccc");
		//int n = LongestSubstringWithAtMost2Char.SubstringWith2DistintChar("abcdefds");
		System.out.println(n);
	}
}

class number1 {
	//number pointer;
	number1 next;
	int num;
	number1(int num){
		this.num = num;
	}
	
}

class number {
	number1 pointer;
	number(int num) {
		pointer = new number1(num);
	}
	void add(int num) {
		number1 numb = new number1(num);
		numb.next = pointer;
		pointer = numb;
	}
}