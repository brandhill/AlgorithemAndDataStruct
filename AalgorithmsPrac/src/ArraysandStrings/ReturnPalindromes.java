package ArraysandStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Return all possible palindromes for the given string

public class ReturnPalindromes {

	public static Set<String> returnPalindromes(String input){
		char[] chars = input.toCharArray();
		//Map<Character,Integer> map = new HashMap<Character,Integer>();
		//List<LinkedList<Character>> list = new ArrayList<LinkedList<Character>>();
		Set<String> output = new HashSet<String>();
		for(int i = 0; i <= input.length()-1; i++) 
		{
			for(int j= i+1; j <= input.length(); j++) 
			{
				String palindrome = input.substring(i, j);
				if( isPalindrome(palindrome) )
				{
					output.add(palindrome);
				}
			}
		}
		
		return output;
	}
	
	public static boolean isPalindrome(String s){
		char[] c = s.toCharArray();
		int len = s.length();
		for( int i = 0; i < len/2; i++) {
			if(c[i]!=c[len-i-1]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(ReturnPalindromes.returnPalindromes("abcbabcba").toString());
	}
}
