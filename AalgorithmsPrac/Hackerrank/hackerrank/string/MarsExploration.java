package hackerrank.string;

import java.util.Scanner;

public class MarsExploration {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int count = 0;
		for (int i = 0; i <= str.length()-3; i=i+3) {
			if(str.charAt(i)!='S') {
				count++;
			}
			if(str.charAt(i+1)!='O') {
				count++;
			}
			if(str.charAt(i+2)!='S') {
				count++;
			}
		}
		System.out.println(count);
	}
	
}
