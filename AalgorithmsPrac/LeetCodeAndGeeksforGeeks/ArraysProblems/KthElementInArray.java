package ArraysProblems;

import java.util.Arrays;

public class KthElementInArray {
	
	int KthLargestElement(int[] arr,int k) {
		
		if(k < 0 || k >arr.length) {
			return -1;
		}
		
		int low = 0;
		int high = arr.length -1;
		int count = 1;
		while(true) {
			System.out.println("Count "+count);
		int p = QuickSort(arr,low,high);
		
			if(k==(p+1)) {
				return arr[p];
			}
			else if(k < (p+1)) {
				//low = 
				high = p-1;
			}
			else {
				low = p+1;
			}
			count++;
		}
		
	}
	
	int QuickSort(int[] arr, int low,int high) {
		int pivot = high;
		int point = low;
		
		while(low<high) {
			if(arr[low]>arr[pivot]) {
				swap(arr,point,low);
				point++;
			}
			low++;
		}
		swap(arr,point,pivot);
		
		return point;
	}
	
	void swap(int[] arr,int index1,int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void main(String args[]){
        int arr1[] = {6, 2, 1, 6, 8, 9, 6};
        int arr[] = {1, 2, 3, 4, 5, 7, 6};
        KthElementInArray kthElement = new KthElementInArray();
        System.out.println(kthElement.KthLargestElement(arr, 3));
        System.out.print(Arrays.toString(arr));
    }
}
