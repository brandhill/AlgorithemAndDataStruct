package CareerCup;

// https://www.careercup.com/question?id=5639848137326592

public class FindLongestRepeatedSubString {
	
	
	// Time - O(n^2), Space - O(n^2) 
	
	static String findLongestRepeatedSubString(String s) {
		if(s==null || s.trim().length()==0)
			return "";
		int len = s.length();
		int[][] matrix = new int[len][len];
		int maxLen = 0;
		int maxIndex = 0;
		for(int i=0; i< len; i++) {
			for(int j=i+1; j < len; j++) {
				if(s.charAt(i)==s.charAt(j)) {
					matrix[i][j] = ((i-1<0 || j-1<0)?0:matrix[i-1][j-1]) +1;
					if(matrix[i][j]>maxLen) {
						maxLen = matrix[i][j];
						maxIndex = j;
					}
				}
			}
		}
		
		return s.substring(maxIndex-maxLen+1,maxIndex+1);
	}
	
	public static void main(String[] args) {
		System.out.println(findLongestRepeatedSubString("abcdabccdabc"));
	}
}
