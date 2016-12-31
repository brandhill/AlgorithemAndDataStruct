package ArraysProblems;

import java.util.Arrays;

// https://www.careercup.com/question?id=5179916190482432

// Restrictions: 1) No use of divison 2) Complexity - O(n)

// Time - O(n)
// Space - O(n)
public class MultiplyAllFieldsExceptOwnPosition {
	
	static int[] multiply(int arr[]) {
		int[] output = new int[arr.length];
		int[] bwd = new  int[arr.length];
		int product = 1;
		bwd[arr.length-1] = 1;
		
		for(int i = arr.length-2; i >= 0; i--) {
			bwd[i] = arr[i+1]*bwd[i+1];
		}
		
		for(int i = 0; i < arr.length; i++) {
			output[i] = product*bwd[i];
			product *=  arr[i];
		}
	
		System.out.println(Arrays.toString(bwd));
		System.out.println(Arrays.toString(output));
		return output;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,0,4};
		MultiplyAllFieldsExceptOwnPosition.multiply(arr);
	}
}
