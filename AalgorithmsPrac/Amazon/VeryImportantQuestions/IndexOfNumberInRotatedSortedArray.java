package VeryImportantQuestions;

import java.util.PriorityQueue;
import java.util.Queue;

// https://www.careercup.com/question?id=5640877024215040
// incomplete
public class IndexOfNumberInRotatedSortedArray {
	
	static int findIndexWithoutDuplicates(int[] array, int n) {
		if(array.length==0)
			return -1;
		if(array.length==2) {
			return array[0]==n?0:(array[1]==n?1:-1);
		}
		if(array[0]<=array[array.length-1]) {
			return binarySearch(array,0,array.length-1,n);
		}
		int pivot = findPivot(array,0,array.length-1);
		System.out.println(pivot);
		if(pivot==-1)
			return -1;
		if(n>=array[0])
			return binarySearch(array,0,pivot,n);
		return binarySearch(array,pivot+1	,array.length-1,n);
	} 
	
	private static int findPivot(int[] arr, int low, int high) {
		 if (high < low)  return -1;
		   if (high == low) return low;
		 
		   int mid = (low + high)/2;   /*low + (high - low)/2;*/
		   if (mid < high && arr[mid] > arr[mid + 1])
		       return mid;
		   if (mid > low && arr[mid] < arr[mid - 1])
		       return (mid-1);
		   if (arr[low] >= arr[mid])
		       return findPivot(arr, low, mid-1);
		   return findPivot(arr, mid + 1, high);
	}
	
	private static int binarySearch(int[] array, int start, int end, int n) {
		while(start<=end) {
			System.out.println(start+" "+end);
			int mid = (start+end)/2;
			if(array[mid]==n)
				return mid;
			else if(array[mid]<n) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return -1;
	}
	
	static int findIndex(int[] array, int n) {
		int low = 0;
		int high = array.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			System.out.println(low +" "+ high);
			if(array[mid]==n)
				return mid;
			if(n==array[low])
				return low;
			if(array[mid]>array[low]) {
				if(array[mid]>n && n>array[low]) {
					high = mid;
				} else {
					low = mid;
				}
			} else {
				if(array[mid]<n && n<array[low]) {
					low = mid;
				} else {
					high = mid;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		int[] array = {60,60,60,70,5,17,17,17};
//		int[] array1 = {2,2,2,2,2,2,2,2,2,2,2,2,2,3,2,2};
//		System.out.println(findIndex(array1,3));
//		int[] array = {4,5,6,7,0,1,2};
//		System.out.println(findIndexWithoutDuplicates(array,0));
//		int[] array1 = {3,5,1};
//		System.out.println(findIndexWithoutDuplicates(array1,1));
//		Queue q = new PriorityQueue<>();
		
		int s = 12345;
		String value = String.valueOf(s);
		System.out.println(value);
		for(int i =0; i< value.length(); i++) {
			if(value.charAt(i)>value.charAt(i+1)) {
				System.out.println(i);
				break;
			}
		}
		
	}
}


// 20 30 45 45 60 60 70 5 17 18 19

