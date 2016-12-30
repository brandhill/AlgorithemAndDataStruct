package String;
// http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

// Time - O(n^2)
public class LongestPalindromeSubString {
	
	static String getLongestPalindromeSubString(char[] input) {
		int len = input.length;
		int start = -1;
		int maxLen = 0;
		String  output = "";
		boolean[][] table = new boolean[len][len];
		
		for(int i = 0; i < len; i++) {
			table[i][i] = true;
		}
		for(int i = 0; i < len-1; i++) {
			if(input[i]==input[i+1])
				table[i][i+1] = true;
		}
		
		for(int k = 3; k <len; k++) {
			for(int i = 0; i <= len-k; i++) {
				int j = i+k-1;
				if(table[i+1][j-1]&&input[i]==input[j]) {
					table[i][j] = true;
					if(k>maxLen) {
						maxLen = k;
						start = i;
					}
				}
			}
		}
		
		if(maxLen>0) {
			output = String.valueOf(input).substring(start, start+maxLen);
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		String input = "forgeeksskeegfor"; 
		String output = LongestPalindromeSubString.getLongestPalindromeSubString(input.toCharArray());
		System.out.println(output);
	}
}
