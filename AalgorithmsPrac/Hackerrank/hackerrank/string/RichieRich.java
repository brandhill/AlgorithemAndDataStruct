package hackerrank.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import GraphsDataStructures.mainclass;

public class RichieRich {
	
	static String MaxPalindrome(String number,int k) {
		
		if(number==null || number.isEmpty())
			return "-1";
		char[] output = number.toCharArray();
		int len = number.length();
		if(len <= k) {
			for ( int i = 0; i <output.length; i++) {
				output[i] = '9';
			}
			return String.valueOf(output);
		}
		
		int lowIndex = 0;
		int highIndex = len-1;
		Set<Integer> indexs = new HashSet<Integer>();
		while(lowIndex<=highIndex && k > 0) {
			char l = number.charAt(lowIndex);
			char h = number.charAt(highIndex);
			if(l!=h) {
				indexs.add(lowIndex);
				char max = l>h?l:h;
				output[lowIndex] = max;
				output[highIndex] = max;
				k--;
			}
			else {
				output[lowIndex] = l;
				output[highIndex] = l;
			}
			lowIndex++;
			highIndex--;
		}
		lowIndex = 0;
		while(k>0 && lowIndex <= len/2) {
			if(output[lowIndex]!='9') {
				if(indexs.contains(lowIndex) ) {
					output[lowIndex] = '9';
					output[len-1-lowIndex] = '9';
					k--;
				}
				else if(lowIndex == len/2) {
					output[len/2] = '9';
					k--;
				}
				else {
					if(k>1){
						output[lowIndex] = '9';
						output[len-1-lowIndex] = '9';
						k -= 2;
					}
				}
			
			}
			lowIndex++;
		}
		
		
		
		if(isPalindrome(output)) {
			return String.valueOf(output);
		}
		else {
			return "-1";
		}
	}
	
	private static boolean isPalindrome(char[] chars) {
		int len = chars.length;
		for ( int i = 0; i <= len/2; i++) {
			if(chars[i]!=chars[len-1-i]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int k = sc.nextInt();
		String str = sc.next();
		String s = RichieRich.MaxPalindrome(str, k);
		System.out.println(s);
	}
}
