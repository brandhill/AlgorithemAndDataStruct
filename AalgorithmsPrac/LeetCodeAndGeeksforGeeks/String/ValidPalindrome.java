package String;
// https://leetcode.com/problems/valid-palindrome/

// Time - O(n) 
// Space - O(1)
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		
		char[] chars = s.toLowerCase().toCharArray();
		int i = 0;
		int j = s.length()-1;
		while(i<j) {
			if(!isAlphNum(chars[i])) {
				i++;
				continue;
			}
			if(!isAlphNum(chars[j])) {
				j--;
				continue;
			}
			if(chars[i]!=chars[j])
				return false;
			i++;
			j--;
		}
		
		return true;
	}
	
	boolean isAlphNum(char c) {
		
		if((c>='0' && c<='9') || (c>='a' && c<='z'))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'A');
		System.out.println((int)'Z');
	}
}
