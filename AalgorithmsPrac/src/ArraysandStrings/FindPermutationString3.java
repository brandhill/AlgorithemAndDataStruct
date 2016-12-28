package ArraysandStrings;

import java.util.Arrays;

public class FindPermutationString3 {
	public String sort(String s){
		char[] c1 = s.toCharArray();
		Arrays.sort(c1);
		String sorted = new String(c1);
		return sorted;
	}
	
	public boolean findPermutation(String s1,String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		
		return sort(s1).equalsIgnoreCase(sort(s2));
	}
	
	public static void main(String[] args) {
		FindPermutationString3 q3 = new FindPermutationString3();
		boolean check = q3.findPermutation("hardfsha", "harshadf");
		if(check)
			System.out.println("Both Strings are permutated");
		else
			System.out.println("Both Strings are not permutated");
	}
}
