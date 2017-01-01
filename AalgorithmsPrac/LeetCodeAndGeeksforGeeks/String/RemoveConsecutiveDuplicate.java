package String;

/**
 * Remove consecutive duplicate characters
 * e.g
 * AABBCDDAAB -> ABCDAB
 * ABBBCCD -> ABCD
 * Test cases
 * Empty string
 * all unique
 * all duplicates
 * duplicates at certain different places
 */

// Time - O(n)
// Space - O(k) - k unique characters
public class RemoveConsecutiveDuplicate {
	
	static String removeDuplicates(String s) {
		if(s==null || s.trim().length()==0) {
			return "";
		}
		char[] chars = s.toCharArray();
		StringBuffer output = new StringBuffer("");
		int i = 0;
		while(i<s.length()) {
			if(i!=0 && chars[i]==chars[i-1]) {
				i++;
				continue;
			}
			char c = chars[i];
			output.append(c);
			i++;
		}
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		//String s = "";
		//String s = "abcds";
		//String s = "aaaa";
		String s = "aaabbcccadd";
		String output = RemoveConsecutiveDuplicate.removeDuplicates(s);
		System.out.println(output);
	}
}
