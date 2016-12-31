package String;

import java.util.HashMap;
import java.util.Map;
// http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/

// Time - O(n)
// Space - O(n)
public class LongestSubstringWithKDistinctCharacters {
	public static int lengthOfLongestSubstringKDistinct(String s, int k) { 
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		char[] chars = s.toCharArray();
		int j = 0;
		int start = 0;
		int end = 0;
		int maxLen = 0;
		for(int i = 0; i<s.length();i++ ) {
			char c = chars[i];
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
			while(map.size()>k) {
				char c1 = chars[j];
				map.put(c1, map.get(c1)-1);
				if(map.get(c1)==0)
					map.remove(c1);
				j++;
			}
			if(maxLen<(i-j+1)) {
				start = j;
				end = i;
				maxLen = i-j+1;
			}
		}
		System.out.println("Max substring is "+s.substring(start, end+1)+" with length "+maxLen);
		return maxLen;
	}
	
	public static void main(String[] args) {
		//String s = "aabbcc";
		String s = "abcabc";
		LongestSubstringWithKDistinctCharacters.lengthOfLongestSubstringKDistinct(s, 1);
		LongestSubstringWithKDistinctCharacters.lengthOfLongestSubstringKDistinct(s, 2);
		LongestSubstringWithKDistinctCharacters.lengthOfLongestSubstringKDistinct(s, 3);
		String s1 = "aabacbebebe";
		LongestSubstringWithKDistinctCharacters.lengthOfLongestSubstringKDistinct(s1, 3);
	}
}
