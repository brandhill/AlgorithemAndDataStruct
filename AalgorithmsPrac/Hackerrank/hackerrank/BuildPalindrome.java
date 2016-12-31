package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BuildPalindrome {
	
	static String findPalindrome(String a, String b) {
		
		String palindrome = "";
		
		for( int i = 0; i < a.length() ; i++) 
		{
			int len = 1;
			while(len <= a.length() - i) 
			{
				String s1 = a.substring(i,i+len);
				//System.out.print(s1+" is ");
				for( int j = 0; j < b.length() ; j++) 
				{
					int len1 = 1;
					while(len1 <= b.length() - j) 
					{
						String s2 = b.substring(j,j+len1);
						//System.out.print(s2+" ");
						if(ifpalindrome(s1,s2)) 
						{
							String s = s1+s2;
							if(palindrome.isEmpty() || s.length() > palindrome.length()) 
							{
								palindrome = s;
							}
							else if( s.length() == palindrome.length()) 
							{
								char[] c1 = s.toCharArray();
								char[] c2 = palindrome.toCharArray();
								for( int k = 0; k < s.length() ; k++) 
								{
									if ( c1[k] < c2[k]) 
									{
										palindrome = s;
										break;
									}
									else if ( c1[k] > c2[k]) 
									{
										break;
									}
								}
							}
						}
						len1++;
					}
					
				}
				//System.out.println();
				len++;
			}
		
		}
		
		return palindrome;
	}
	
	static boolean ifpalindrome(String s1, String s2) {
		//System.out.println(s1+" "+s2);
		char[] s = (s1 + s2).toCharArray();
		int len = s.length;
		for( int i = 0; i < len/2 ; i++) {
			if( s[i] != s[len-i-1]) {
				return false;
			}
		}
		return true;
	}
	
	static String findPalindrome1(String a, String b) {
		List<String> list1 = findSubstrings(a);
		List<String> list2 = findSubstrings(b);
		String palindrome = "";
		for( int i = 0; i < list1.size(); i++) {
			String s1 = list1.get(i);
			for( int j = 0; j < list2.size(); j++) {
				String s2 = list2.get(j);
				if(ifpalindrome(s1,s2)) 
				{
					String s = s1+s2;
					if(palindrome.isEmpty() || s.length() > palindrome.length()) 
					{
						palindrome = s;
					}
					else if( s.length() == palindrome.length()) 
					{
						char[] c1 = s.toCharArray();
						char[] c2 = palindrome.toCharArray();
						for( int k = 0; k < s.length() ; k++) 
						{
							if ( c1[k] < c2[k]) 
							{
								palindrome = s;
								break;
							}
							else if ( c1[k] > c2[k]) 
							{
								break;
							}
						}
					}
					break;
				}
			}
		}
		return palindrome;
	}
	
	static List<String> findSubstrings(String input){
		
		List<String> list = new ArrayList<String>();
		for( int i = 0; i < input.length() ; i++) 
		{
			int len = 1;
			while(len <= input.length() - i)
			{
				list.add(input.substring(i,i+len));
				len++;
			}
		}
		return list;
	}
	
static Set<String> findSubstrings1(String input){
		
		Set<String> list = new HashSet<String>();
		for( int i = 0; i < input.length() ; i++) 
		{
			int len = 1;
			while(len <= input.length() - i)
			{
				list.add(input.substring(i,i+len));
				len++;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = Integer.valueOf(in.nextLine());
		count = count * 2;
		List<String> list = new ArrayList<String>();
		for( int i = 0; i < count; i++) {
			list.add(in.nextLine());
		}
		
		for( int i = 0; i < count; i=i+2) {
			long startTime = System.currentTimeMillis();
			String s = BuildPalindrome.findPalindrome1(list.get(i), list.get(i+1));
			if(s.length()==0)
				System.out.println(-1);
			else if(s.length()>0)
				System.out.println(s);
			long stopTime = System.currentTimeMillis();
		      long elapsedTime = stopTime - startTime;
		      System.out.println(elapsedTime);
		}
		
		
	}
}

/* 
 -1
67794
-1
62248
dbcacbd
68379
snsrfpxxftmjuedksdmnbklsrnjpwvpqwmxxtffgtbdbjifnrvwztbdjrbazxotgfqvyqpgrdojjgjvqiwldvjinoeebscjcisyvutvhvmiycyimvhvtuvysicjcsbeeonijvdlwiqvjgjjodrgpqyvqfgtoxzabrjdbtzwvrnfijbdbtgfftxxmwqpvwpjnrslkbnmdskdeujmtfxxpfrsns
67228
xawaroblpmamklrwlznplgspuzvnubpudibptdslaagxaaacqrsrqcaaaxgaalsdtpbidupbunvzupsglpnzlwrlkmamplborawax
12395*/
