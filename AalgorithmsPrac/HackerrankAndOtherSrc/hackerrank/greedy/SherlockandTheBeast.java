package hackerrank.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockandTheBeast {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		List<String> output = new ArrayList<String>();
		for ( int j = 0; j < loop; j++) {
			StringBuffer s = new StringBuffer("");
			int val = sc.nextInt();
		
				int num2 = val%3;
				int num1 = val - num2;
				while(num1>0) {
					if(num2%5==0) {
						break;
					}
					
					num2 += 3;
					num1 -= 3;
				}
				if(num1>=0 && num2%5 == 0) {
					int i = 0;
					while (i < val) {
						if(num1>0) {
							s.append("555");
							i +=3;
							num1 -= 3;
						}
						else if(num2 >= 0) {
							s.append("33333");
							i += 5;
							num2 -= 5;
						}
					}
					output.add(s.toString());
					//System.out.println(s.toString());
				}
				else {
					output.add("-1");
				}
			}
		
		for (int i = 0; i < loop; i++) {
			System.out.println(output.get(i));
		}
		
	}
}
