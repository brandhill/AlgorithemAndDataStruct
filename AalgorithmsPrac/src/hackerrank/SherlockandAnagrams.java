package hackerrank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SherlockandAnagrams {
	
	public static int findAnagrams ( String input ) {
		
		char[] chars = input.toCharArray();
		int count = 0;
		for( int i = 0 ; i < chars.length -1 ; i++) 
		{
			int len = 1;
			while(len < chars.length-i)
			{
				String s1 = input.substring(i,i+len);
				for( int j = i+1; j+len <= chars.length ; j++)
				{	
					String s2 = input.substring(j,j+len);
					if(checkIfStringAnagrams(s1,s2))
					{
						System.out.println(s1+" "+s2);
						count++;
					}
				}
				len++;
			}
		}
		return count;
	}
	
	static boolean checkIfStringAnagrams(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if( String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2)) ) {
			//System.out.println(String.valueOf(c1) + " "+ String.valueOf(c2));
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = Integer.valueOf(in.nextLine());
		//in.next();
		List<String> list = new ArrayList<String>();
		for( int i = 0; i < count; i++) {
			list.add(in.nextLine());
		}
		for( int i = 0; i < count; i++) {
			System.out.println(SherlockandAnagrams.findAnagrams(list.get(i)));
		}
	}
}
