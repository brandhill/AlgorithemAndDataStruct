package String;

import java.util.Arrays;
// http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

// Time - O(n^2)
// Space - O(n^2)
public class LongestPalindromeSubsequence {
	
	public int longestPalindromeSubsequence(String input) {
		int[][] table = new int[input.length()][input.length()];
		for(int i = 0; i < table.length; i++) {
			Arrays.fill(table[i], 1);
		}
		pointer p = new pointer();
		p.max = 1;
		lpsHelper(input,table,0,input.length()-1,p);
		
		return p.max;
	}
	
	public int lpsHelper(String input,int[][] table,int i,int j,pointer p) {
		
		if(i==j)
			return 1;
		if(table[i][j]!=1) {
			return table[i][j];
		}
		if(i+1==j && input.charAt(i)==input.charAt(j)) {
			table[i][j] = 2;
		}
		else if(input.charAt(i)==input.charAt(j)) {
			table[i][j] = lpsHelper(input,table,i+1,j-1,p)+2;
		}
		else {
			table[i][j] = Math.max(lpsHelper(input,table,i,j-1,p),lpsHelper(input,table,i+1,j,p));
		}
		if(p.max < table[i][j]) {
			p.max = table[i][j];
		}
		return table[i][j];
	}
	
	public static void main(String[] args) {
		//String s = "GEEKSFORGEEKS";
		String s = "BBABCBCAB";
		LongestPalindromeSubsequence l = new LongestPalindromeSubsequence();
		int n = l.longestPalindromeSubsequence(s);
		System.out.println(n);
	}
}

class pointer {
	int i;
	int j;
	int max;
}