package CareerCup;

import java.util.Arrays;

// https://www.careercup.com/question?id=5714091033231360

public class PositiveNegativeSequenceWithConstantSpace {
	// Time  - O(n^2)
	static void rearrange(int[] array) {
		if(array.length<=1)
			return;
		int i = 1;
		
		boolean check = array[0]>=0?true:false;
		
		while(i<array.length) {
			// look for -ve integer
			int j = i;
			if(check) {
				while(j <array.length && array[j]>=0) {
					j++;
				}
				check = false;
			} 
			// look up for +ve integer
			else {
				while(j <array.length && array[j]<0) {
					j++;
				}
				check = true;
			}
			
			if(j==array.length)
				return;
			else
			   shift(array,i,j);
			i++;
		}
	}
	
	private static void shift(int[] array, int from, int to) {
		for(int i=to; from<i; i--) {
			swap(array, i, i-1);
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] array =  {1, 2, -3, -4, 5, 6, 7, -8, -9};
		rearrange(array);
		System.out.println(Arrays.toString(array));
	}
}
