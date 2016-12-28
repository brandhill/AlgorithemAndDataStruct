package hackerrank.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockandArray {
	
	static String ifBalance(int[] array,int right) {
		
		int left = 0;
		int i = 0;
		while(i<array.length) {
			int num = array[i];
			right -=num;
			if(left==right) {
				return "YES";
			}
			left +=num;
			i++;
		}
		return "NO";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int loop = sc.nextInt();
		List<String> output = new ArrayList<String>();
		for ( int i = 0; i < loop; i++) {
			int len = sc.nextInt();
			int[] array = new int[len];
			int sum = 0;
			for ( int j = 0; j<len; j++) {
				int num = sc.nextInt();
				array[j] = num;
				sum += num;
			}
			output.add(SherlockandArray.ifBalance(array, sum));
		}
		
		for(String s: output) {
			System.out.println(s);
		}
		
	}
}
