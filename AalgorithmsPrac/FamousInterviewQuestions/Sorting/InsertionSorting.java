package Sorting;

import java.util.Arrays;

public class InsertionSorting {
	
	static void InsertionSort(int[] array){
		
		for ( int i = 1; i < array.length; i++) {
			int num = array[i];
			for ( int j = i; j >=0; j-- ) {
				if(j==0 || array[j-1] <= num) {
					array[j] = num;
					break;
				}
				else {
					array[j] = array[j-1];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {15,14,12,16,9,10};
		System.out.println(Arrays.toString(array));
		InsertionSorting.InsertionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
