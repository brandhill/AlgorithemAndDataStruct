package Sorting;

import java.util.Arrays;
// Time Complexity  - O (n log n) - in best or avg case
// Time Complexity  - O (n^2) - in worst case - which can avoided using random pivot sorting
public class QuickSorting {

	static void QuickSort(int[] array,int start,int end){
		if(start>=end) {
			return;
		}
		int pIndex = partition(array,start,end);
		QuickSort(array,start,pIndex-1);
		QuickSort(array,pIndex+1,end);
		
	}
	
	static int partition(int[] array,int start,int end){
		
		int pivot = array[end];
		int pIndex = start;
		
		for (int i = start; i < end; i++) {
			if(array[i]<=pivot) {
				swap(array,i,pIndex);
				pIndex++;
			}
		}
		swap(array,pIndex,end);
		return pIndex;
	}
	
	static void swap(int[] array,int index1,int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {15,14,12,16,9,10};
		System.out.println(Arrays.toString(array));
		QuickSorting.QuickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
}
