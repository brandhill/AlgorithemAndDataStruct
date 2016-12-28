package Sorting;

import java.util.Arrays;

// Time Complexity - O (n log n)
// Space Complexity - O(n)
public class MergeSort {
	
	
	static void Merge(int[] array) {
		
		if(array.length < 2) {
			return;
		}
		
		int leftIndex = array.length/2;
		int rightIndex = array.length - leftIndex;
		int[] left = new int[leftIndex];
		int[] right = new int[rightIndex];
		
		for (int i = 0; i < leftIndex; i++) {
			left[i] = array[i];
		}
		for (int i = 0; i < rightIndex; i++) {
			right[i] = array[i+leftIndex];
		}
		Merge(left);
		Merge(right);
		MergeSortHelper(left,right,array);
	}
	
	static void MergeSortHelper(int[] left, int[] right, int[] array) {
		int i = 0;
		int j = 0;
		int k =0;
		
		while(i < left.length && j < right.length) {
			if(left[i] <= right[i]) {
				array[k] = left[i];
				i++;
				k++;
			}
			else {
				array[k] = right[j];
				j++;
				k++;
			}
		}
		
		while(i<left.length) {
			array[k] = left[i];
			i++;
			k++;
		}
		while(j<right.length) {
			array[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {15,14,12,16,9};
		System.out.println(Arrays.toString(array));
		MergeSort.Merge(array);
		System.out.println(Arrays.toString(array));
	}
}
