package String;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * References
 * https://leetcode.com/problems/minimum-window-substring/
 * http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 */
// n - length of string, m - length of substring
// Time - O(n+m)
// Space - O(m)
public class SmallestWindowContaingAllCharacters {
	
	public String minWindow(String s, String t) {
		if(s==null || t==null || s.trim().length()==0 ||t.trim().length()==0)
			return "";
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		Set<Character> set = new HashSet<Character>();
		// Loop over string t and store the characters in map and set
		for(Character c:t.toCharArray()) {
			set.add(c);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		
		// slow pointer
		int i = 0;
		// fast pointer
		int j = 0;
		// Variable to store start and end and len of smallest window substring respectively.
		int start = -1;
		int end = -1;
		int len = Integer.MAX_VALUE;
		while(j<s.length() && i < s.length()) {
			char c = s.charAt(j);
			// if Character c is part of string t
			// decrement count of c in map to -1
			if(map.containsKey(c)) {
				map.put(c, map.get(c)-1);
				// if count of c is 0 then remove the c from the set
				if(map.get(c)==0) {
					set.remove(c);
				}
			}
			
			//set.isEmpty() - if set is empty means all the substring characters are found between pointer i & j
			//j-i+1>minLen - means distance between i & j is more than len of already found
			//j == s.length()-1 - if fast pointer 'j' has reached the end then we loop for slow pointer 'i' 
			while(i<s.length() && (set.isEmpty() || j-i+1>len || j == s.length()-1)) {
				
				if(set.isEmpty()) {
					// Check if new substring len is smaller than previously found substring
					if(len>(j-i+1)) {
						start = i;
						end = j;
						len = end-start+1;
					}
				}
				char c1 = s.charAt(i);
				// if char c1 is part of string t then increment the count of c1 by 1 
				if(map.containsKey(c1)) {
					map.put(c1, map.get(c1)+1);
					// if count is greater than 0 then add char c1 to the set
					if(map.get(c1)==1)
						set.add(c1);
				}
				i++;
			}
			j++;
		}
		if(start==-1)
			return "";
		else
			return s.substring(start,end+1);
    }
	
	public static void main(String[] args) {
		//String str = "ADOBECADEBANC";
        //String subString = "AABC";
        String str = "Tsuaosyogrlmnsluuorjkoruost";
        String subString = "roos";
        SmallestWindowContaingAllCharacters swcac = new SmallestWindowContaingAllCharacters();
        String result = swcac.minWindow(str, subString);
        System.out.println(result);
	}
}
