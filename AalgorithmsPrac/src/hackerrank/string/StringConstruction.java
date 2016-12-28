package hackerrank.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringConstruction {
	
	static int ConstructString(String s) {
		Set<Character> set = new HashSet<Character>();
		int count = 0;
		for ( int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!set.contains(c)){
				set.add(c);
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		String[] str = new String[count];
		for ( int i = 0; i < count; i++) {
			str[i] = sc.next();
		}
		for ( int i = 0; i < count; i++) {
			System.out.println(StringConstruction.ConstructString(str[i]));
		}
		
	}
}
