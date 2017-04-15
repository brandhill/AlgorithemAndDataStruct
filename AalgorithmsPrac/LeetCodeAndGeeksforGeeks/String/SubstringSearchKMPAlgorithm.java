package String;

import java.util.Arrays;

// Find the given pattern in the string

// m - size of pattern , n - size of string
// O(m+n)
// O(m)

public class SubstringSearchKMPAlgorithm {
	
	static int SearchPattern(char[] string, char[] pattern) {
		int index = -1;
		
		int[] indexs = new int[pattern.length];
		fillIndexs(pattern,indexs);
		System.out.println(Arrays.toString(indexs));
		int j = 0;
		int i = 0;
		while(i<string.length) {
			if(string[i]==pattern[j]) {
				i++;
				j++;
			}
			else if(j==0) {
				i++;
			}
			else {
				j = indexs[j-1];
			}
			
			if(j==pattern.length) {
				System.out.println(i);
				index = i - pattern.length;
				break;
			}
		}
		
		return index;
	}
	
	static void fillIndexs(char[] pat,int[] indexs) {
		int i = 1;
		int j = 0;
		indexs[0] = 0;
		while(i<pat.length) {
			if(pat[i]==pat[j]) {
				indexs[i] = j+1;
				i++;
				j++;
			}
			else if(j==0) {
				indexs[i] = j;
				i++;
			}
			else {
				j = indexs[j-1];
			}
			//System.out.println(Arrays.toString(indexs));	
		}
	}
	
	public static void main(String[] args) {
		//char[] string = "aaxaabaasdasaabaabaaa".toCharArray();
		//char[] pattern = "aabaabaaa".toCharArray();
		char[] string = "abxabcabcaby".toCharArray();
		char[] pattern = "abcaby".toCharArray();
		int index = SubstringSearchKMPAlgorithm.SearchPattern(string, pattern);
		System.out.println(index+" "+"abxabcabcaby".substring(index));
	}
}
