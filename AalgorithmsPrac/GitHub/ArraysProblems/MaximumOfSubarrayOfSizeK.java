package ArraysProblems;

import java.util.Arrays;

import GraphsDataStructures.mainclass;

// http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/

// Time - O(n)
// Space - O(n-k+1)
public class MaximumOfSubarrayOfSizeK {
	
	public static int[] maxSubArray(int[] input,int k) {
		int[] output = new int[input.length-k+1];
		int max = input[0];
		int pointer = 0;
		int start = 0;
		for(int i = 1 ; i < input.length; i++) {
				if(pointer<start) {
					max = input[start];
					pointer = start;
					for(int m = start+1; m<=i; m++) {
						if(max<input[m]) {
							max = input[m];
							pointer = m;
						}
					}
				}
				else {
					if(max<input[i]) {
						max = input[i];
						pointer = i;
					}
				}
				if(i>=k-1) {
					output[i+1-k] = max;
					start++;
				}
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
	
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		MaximumOfSubarrayOfSizeK.maxSubArray(input, 3);
		int[] input1 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		MaximumOfSubarrayOfSizeK.maxSubArray(input1, 4);
		int[] input2 = {12, 1, 78, 90, 57, 89, 56};
		MaximumOfSubarrayOfSizeK.maxSubArray(input2, 3);
	}
}
