package ArraysProblems;

import java.util.Arrays;

// https://leetcode.com/problems/create-maximum-number/

public class MaxNumberFromTwoArray {
	
	public int[] maxNumber(int[] arr1,int[] arr2,int k) {
		int[] result = new int[k];
		
		index1[] array1 = new index1[arr1.length];
		index1[] array2 = new index1[arr2.length];
		for(int i = 0; i < array1.length; i++) {
			array1[i] = new index1(arr1[i],i);
		}
		for(int i = 0; i < array2.length; i++) {
			array2[i] = new index1(arr2[i],i);
		}
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		for(int i = 1; i < k; i++) {
			addValuesToArray(i,k-i,arr1,arr2,array1,array2,result);
		}
		
		return result;
	}
	
	void addValuesToArray(int num1,int num2,int[] arr1,int[] arr2,index1[] array1,index1[] array2,int[] result) {

	}
	
	public static void main(String[] args) {
		int[] arr1 = {3,4,6,5};
		int[] arr2 = {9,1,2,5,8,3};
		int k = 5;
		//int[] arr3 = arr2;
		//System.out.println(Arrays.toString(arr3));
		int[] result = new int[k];
		MaxNumberFromTwoArray m = new MaxNumberFromTwoArray();
		result = m.maxNumber(arr1, arr2, k);
		System.out.println(Arrays.toString(result));
	}
}

class index1 implements Comparable {
	int val;
	int index;
	
	index1(int val,int index) {
		this.val = val;
		this.index = index;
	}
	
	@Override
	public int compareTo(Object o) {
		index1 i = (index1) o;
		if(this.val > i.val) {
			return -1;
		}
		else if(this.val < i.val) {
			return 1;
		}
		return 0;
	}
}