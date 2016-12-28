package ArraysProblems;

import java.util.Arrays;

// http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/

// Time - O(n)
// Space - O(1)
public class PositiveAndNegativeNumberAlternatively {
	static void arrange(int[] array) {
		int pointer = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i]<0) {
				swap(array,i,pointer);
				pointer++;
			}
		}
		int n = pointer;
		//System.out.println(pointer);
		//System.out.println(Arrays.toString(array));
		// If negatives > positives
		if(array.length/2<n) {
			for(int i = 0; i <n; i=i+2) {
				if(pointer< array.length) {
					swap(array,i,pointer);
					pointer++;
				}
			}
		}
		// else If negatives <= positives
		else {
			// (pointer%2==0) positive values start from even index 
			if(pointer%2==0) {
				pointer++;
			}
			for(int i = 0; i <n; i=i+2) {
				swap(array,i,i+pointer);
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	private static void swap(int arr[],int i,int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
	
	public static void main(String args[]) {
        int arr[] = {-1,6,-3,-4,5,1,2,3,4,-5};
        		 // {6,-1,5,-3,2,-4,3,-4,4,-5}
		int arr1[] = {-1,3,-2,-4,-6,2,5,-8};
		int arr2[] = {-3};
		int arr3[] = {3};
		int arr4[] = {3,-2,3};
		int arr5[] = {-3,3,-1,-2,-5,2,5,6};
        PositiveAndNegativeNumberAlternatively.arrange(arr);
        PositiveAndNegativeNumberAlternatively.arrange(arr1);
        PositiveAndNegativeNumberAlternatively.arrange(arr2);
        PositiveAndNegativeNumberAlternatively.arrange(arr3);
        PositiveAndNegativeNumberAlternatively.arrange(arr4);
        PositiveAndNegativeNumberAlternatively.arrange(arr5);
        //for(int i=0; i < arr.length; i++){
        //    System.out.print(arr[i]+ " ");
        //}
    }
}
