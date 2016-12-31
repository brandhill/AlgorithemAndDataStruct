package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeIndex {

	boolean checkPalindrome(String s1){
		int len = s1.length()-1;
		for(int i = 0; i < len/2; i++) {
			
			if(s1.charAt(i)!=s1.charAt(len-i)){
				return false;
			}
			
		}
		return true;
	}
	
	int findIndex(String s){
		
		if( s.trim().length() == 0 || s == null ) {
			return -1;
		}
		
		if(checkPalindrome(s)){
			return -1;
		}
		
		//StringBuilder s1 = new StringBuilder(s);
		
		/*if( s1.toString().equals(s1.reverse().toString()) )
		{
			return -1;
		}*/
		//System.out.println(s1.substring(0, 0).toString());
		
		for( int i = 0; i < s.length()/2; i++ ) {
			
			//StringBuilder s2 = new StringBuilder(s.substring(0, i)+s.substring(i+1,s.length()));
			//StringBuilder s3 = new StringBuilder(s.substring(i+1,s.length()));
			//s2.append(s3);
			/*if( s2.toString().equals(s2.reverse().toString()) )
				return i;
*/			
			
			//StringBuilder s4 = new StringBuilder(s.substring(0, lastindex)+s.substring(lastindex+1,s.length()));
			//StringBuilder s5 = new StringBuilder(s.substring(lastindex+1,s.length()));
			//s4.append(s5);
			/*if( s4.toString().equals(s4.reverse().toString()) )
				return lastindex;*/
			
			String s2 = s.substring(0, i)+s.substring(i+1,s.length());
			if(checkPalindrome(s2))
				return i;
			int lastindex = s.length()-1-i;
			String s3 = s.substring(0, lastindex)+s.substring(lastindex+1,s.length());
			if(checkPalindrome(s3))
				return lastindex;
			
		}
		//System.out.println("This should never print");
		
		return -1;
	}
	
	public static void main(String[] args) {
		PalindromeIndex p = new PalindromeIndex();
		Scanner in = new Scanner(System.in);
		int count = Integer.valueOf(in.nextLine());
		//in.next();
		List<String> list = new ArrayList<String>();
		for( int i = 0; i < count; i++) {
			list.add(in.nextLine());
		}
		//in.nextInt();
		for( int i = 0; i < count; i++) {
			//System.out.println(list.get(i));
			System.out.println(p.findIndex(list.get(i)));
		}
		
	}
}
