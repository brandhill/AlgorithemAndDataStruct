package hackerrank.string;

import java.util.Scanner;

public class FunnyString {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		String[] strings = new String[count];
		for ( int j = 0; j < count; j++) {
			strings[j] = sc.next();
		}
		
		for ( int j = 0; j < count; j++) {
			String str = strings[j];
			int check = 0;
			for (int i = 0; i < str.length() -1; i++) {
				int end = str.length()-1-i;
				int left = Math.abs(str.charAt(i)-str.charAt(i+1));
				int right = Math.abs(str.charAt(end)-str.charAt(end-1));
				check = Math.addExact(left, -1*right);
				if(check!=0){
					System.out.println("Not Funny");
					break;
				}
			}
				if(check==0){
				System.out.println("Funny");
				}
		}
	}
}
