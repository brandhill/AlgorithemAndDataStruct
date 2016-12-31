package String;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Time - O(n)
// Space - O(n)
public class LongestSubstringWithoutRepetingCharacter {
	
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.trim().length()==0)
			return 0;
		int maxLen = 1;
		int j = 0;
		char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++) {
			char c = chars[i];
			while(set.contains(c)) {
				set.remove(chars[j]);
				j++;
			}
			set.add(c);
			if(maxLen<(i-j+1)) {
				maxLen = i-j+1;
			}
		}
		
		return maxLen;
	}
	
}
