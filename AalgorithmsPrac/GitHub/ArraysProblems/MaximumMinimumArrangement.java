package ArraysProblems;

import java.util.Arrays;

// http://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/

public class MaximumMinimumArrangement {

	static void rearrange(int[] input) {
		int len = input.length;
		int	limit = len/2;
		
		int count = 0;
		int index = len-1;
		int val = input[index];
		int edge = index;
		while(count < len) {
			int current;
			if(index>=limit) {
				current = (len-1-index)*2;
			}
			else {
				current = (index)*2 + 1;
			}
			//System.out.println(index+" "+current);
			int temp = input[current];
			input[current] = val;
			if(current==edge) {
				edge--;
				current = edge;
				temp = input[current];
			}
			val = temp;
			index = current;
			count++;
		}
		System.out.println(Arrays.toString(input));
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] arr2 = {1, 2, 3, 4, 5, 6};
		MaximumMinimumArrangement.rearrange(arr1);
		MaximumMinimumArrangement.rearrange(arr2);
		System.out.println("completed");
	}
}
