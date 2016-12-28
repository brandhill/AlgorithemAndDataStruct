package hackerrank.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheMaximumSubarray {
	
	static int findMaxSubArray(int[] array) {
		//int start = 0;
		//int end = 0;
		int sum = array[0];
		int prevsum = array[0];
		for ( int i = 1; i < array.length;i++) {
				if( prevsum < 0  && array[i] > prevsum) {
					//start = i;
					//end = i;
					prevsum = array[i];
				}
				else {
					prevsum = prevsum + array[i];
						//end = i;
				}
				
				if(prevsum >= sum) {
					sum = prevsum;
				}
		}
		//System.out.println(start+" "+end+" "+sum);
		return sum;
	}
	
	static int findMaxSum(int[] array) {
		int sum = 0;
		int prevsum = 0;
		for (int i =0; i < array.length; i++) {
			if ( i == 0 ) {
				sum = array[i];
				prevsum = array[i];
			}
			else if(array[i] > 0) {
				if(sum < 0)
					sum = 0;
				
				sum = sum + array[i];
			}
			else {
				sum = sum>array[i] ? sum:array[i];
			}
			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		List<int[]> list = new ArrayList<int[]>();
		for ( int i = 0 ; i < loop; i++) {
				int len = sc.nextInt();
				//ArrayList<Integer> L = new ArrayList<Integer>();
				int[] L = new int[len];
				list.add(L);
				for ( int j = 0; j < len;j++) {
					L[j] = sc.nextInt();
				}
		}
		for ( int i = 0 ; i < loop; i++) {
			int sum1 = TheMaximumSubarray.findMaxSubArray(list.get(i));
			//int sum2 = TheMaximumSubarray.findMaxSum(list.get(i));
			//System.out.println(sum1+" "+sum2);
	}
		
	}
}

