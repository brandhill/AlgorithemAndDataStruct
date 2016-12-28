package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoveLetterMystery {

	int decode(String s) {
		int count = 0;
		if( s==null || s.length() <= 1) {
			return 0;
		}
		char[] chars = s.toCharArray();
		int len = s.length()-1;
		for(int i = 0; i <= len/2; i++) {
			
			if( chars[i] != chars[len-i] ) {
				count += Math.abs(Math.subtractExact(chars[i], chars[len-i]));
			}
			//else if( chars[i] < chars[len-i] ) {
			//	count += chars[i] - chars[len-i];
			//}
			
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		
		LoveLetterMystery L = new LoveLetterMystery();
		Scanner in = new Scanner(System.in);
		int count = Integer.valueOf(in.nextLine());
		List<String> list = new ArrayList<String>();
		for( int i = 0; i < count; i++) {
			list.add(in.nextLine());
		}
		for( int i = 0; i < count; i++) {
			System.out.println(L.decode(list.get(i)));
		}
		
		
	}
	
}
