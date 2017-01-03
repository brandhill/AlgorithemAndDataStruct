package ArraysAndStrings1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Find if a string has all unique characters

public class FindIfUniqChars1 {
	
	// Time complexity is n
	static boolean findIfUniqueWithMap(String s){
		if(s.trim().length() ==0 || s.length() > 26 || s ==null)
			return false;
		char[] chars = s.toLowerCase().toCharArray();
		Set<Character> set = new HashSet<Character>();
		for( int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if(!set.contains(c)) {
				set.add(c);
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	// Time complexity is  (n * Log n)
	static boolean findIfUnique(String s){
		if(s.trim().length() ==0 || s.length() > 26 || s ==null)
			return false;
		char[] chars = s.toLowerCase().toCharArray();
		Arrays.sort(chars);
		for( int i = 0; i < chars.length - 1; i++) {
			if(chars[i]==chars[i+1])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(FindIfUniqChars1.findIfUniqueWithMap("ancdeA"));
	}
}
