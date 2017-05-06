package CareerCup;

public class WhatKindOfArray {
	
	static void whatTypeOfArray(int[] arr) {
		
		if(arr.length<=1) {
			System.out.println("Ascending");
			return;
		}
		int len = arr.length;
		int start = 0;
		int end = len-1;
		while(start<len-1 && arr[start]==arr[start+1])
			start++;
		if(start==len-1) {
			System.out.println("All same numbers");
			return;
		}
		while(end>0 && arr[end]==arr[end-1])
			end--;
		
		if(arr[start]>arr[end]) {
			if(start+1==end || (arr[start]>arr[start+1] && arr[end-1]>arr[end])) {
				System.out.println("Decending");
			} else 
				System.out.println("Ascending Sorted");
		} else {
			if(start+1==end || (arr[start]<arr[start+1] && arr[end-1]<arr[end])) {
				System.out.println("Ascending");
			} else 
				System.out.println("Decending Sorted");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,9,0};
		int[] arr1 = {1,1,2,3,3,3};
		int[] arr2 = {2,2,2,2};
		whatTypeOfArray(arr2);
	}
}
