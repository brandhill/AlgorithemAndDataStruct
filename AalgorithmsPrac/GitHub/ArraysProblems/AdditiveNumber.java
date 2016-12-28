package ArraysProblems;

import java.math.BigInteger;

/**
 *
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers.
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 *
 * https://leetcode.com/problems/additive-number/
 */
public class AdditiveNumber {
	
	static public boolean isAdditive(String num) {
		
		if(num.trim().length()<3) {
			return false;
		}
		for(int i = 0; i < num.length(); i++) {
			if(num.charAt(0)=='0' && i > 0)
				break;
			BigInteger num1 = new BigInteger(num.substring(0, i+1));
			
			for (int j = i + 1; Math.max(i, j - (i + 1)) + 1 <= num.length() - j - 1 ; j++) {
				System.out.println(Math.max(i+1, j - (i + 1)+1)+" "+ (num.length()-j-1));
				if(num.charAt(i+1)=='0' && j > i+1)
					break;
				
				BigInteger num2 = new BigInteger(num.substring(i+1, j+1));
				if(isValid(num,j+1,num1,num2)){
					return true;
				}
			}
			
		}
		return false;
		
	}
	
	static public boolean isValid(String num, int start,BigInteger num1,BigInteger num2){
		//System.out.println(start+" "+num.length());
		if(start==num.length())
			return true;
		BigInteger num3 = num1.add(num2);
		String s = num3.toString();
		return s.equals(num.substring(start, start+s.length())) && isValid(num,start+s.length(),num2,num3);
	}
	
	public static void main(String[] args) {
		System.out.println(AdditiveNumber.isAdditive("145150295445"));
	}
}
