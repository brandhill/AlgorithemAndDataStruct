package Sorting;

import java.util.Arrays;

public class BubbleSorting {

	static void BubbleSort(int[] array){
		
		for ( int i = array.length-1; i > 0; i--) {
			for ( int j = 0; j < i; j++) {
				if(array[j] > array[j+1]) {
					swap(array,j,j+1);
				}
			}
		}
	}
	
	static void swap(int[] array,int index1,int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {15,14,12,16,9,10};
		System.out.println(Arrays.toString(array));
		BubbleSorting.BubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
}
