package hackerrank.string;

import java.util.Scanner;

public class CaesarCipher {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		String input = sc.next();
		int rotate = sc.nextInt();
		
		StringBuffer s = new StringBuffer("");
		for ( int i = 0; i < count; i++) {
			
			char ch = input.charAt(i);
			int newCh = ch+rotate;
			if( (ch>=97 && ch <= 122)) {
				
				while(newCh>122){
					newCh = newCh-122+ 96;
				}
				s.append((char)(newCh));
			}
			else if ((ch>=65 && ch<=90)) {
				while(newCh>90){
					newCh = newCh-90+ 64;
				}
				s.append((char)(newCh));
			}
			else {
				s.append(ch);
			}
		} 
		System.out.println(s.toString());
		
	}
}
