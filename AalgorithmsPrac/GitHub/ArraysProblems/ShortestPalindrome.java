package ArraysProblems;


// https://leetcode.com/problems/shortest-palindrome/

// Not complete
public class ShortestPalindrome {
	
	String getShortestPalindrome(String input) {
		if(input.trim().length()==0) {
			return "";
		}
		//asdad
		StringBuffer output = new StringBuffer("");
		int start = 0;
		int end = input.length()-1;
		char[] chars = input.toCharArray();
		while(start<=end) {
			if(chars[start]==chars[end]) {
				start++;
			}
			output.append(chars[end]);
			end--;
		}
		output.append(input.substring(start));
		System.out.println(output.toString());
		if(output.substring(output.length()-input.length()).equals(input)) {
			return output.toString();
		}
		else {
			int n = input.length()%2==0?0:1;
			StringBuffer s  = new StringBuffer("");
			for(int i = input.length()-1; i >=n; i--) {
				s.append(chars[i]);
			}
			return s.toString()+input;
		}
		
	}
	
	public static void main(String args[]) {
        ShortestPalindrome sp = new ShortestPalindrome();
        //System.out.println(sp.getShortestPalindrome("aacecaaa"));
        //System.out.println(sp.getShortestPalindrome("aaccaaa"));
        System.out.println(sp.getShortestPalindrome("aabba"));
        //System.out.println(sp.getShortestPalindrome("abcadcba"));
        //System.out.println(sp.getShortestPalindrome("adcba"));
        
    }
}
