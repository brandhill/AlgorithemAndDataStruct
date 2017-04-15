package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find the longest common substring between two texts.
// n - length of small string, m - length of long string
// Time - O(m*n)
// Space - O(m*n)

public class FindCommenSubstrinBetweenTwoStrings {
	
	static String findCommenSubstring(String s1,String s2) {
		if(s1==null || s2==null || s1.trim().length()==0 || s2.trim().length()==0)
		return "";
		int[][] track = new int[s1.length()][s2.length()];
		int len = 0;
		int endIndex = -1;
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0 ; j < s2.length(); j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					track[i][j] = track[Math.max(0, i-1)][Math.max(0, j-1)] + 1;
					if(track[i][j]>len) {
						len = track[i][j];
						endIndex = i;
					}
				}
				else {
					track[i][j] = 0;
				}
			}
		}
		
		return s1.substring(endIndex-len+1,endIndex+1);
			
	}
		
	public static void main(String[] args) {
		System.out.println(findCommenSubstring("abcabb","abcabcabb"));
	}
}
