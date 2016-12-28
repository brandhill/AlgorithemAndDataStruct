package hackerrank.implementation;

import java.util.Scanner;

public class MiniMaxSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for ( int j = 0; j < 5; j++){
			int i = sc.nextInt();
			if( i < min){
				min = i;
			}
			if( i > max){
				max = i;
			}
			sum += i;
		}
		System.out.print((sum-max)+" "+(sum-min));
	}
}	
