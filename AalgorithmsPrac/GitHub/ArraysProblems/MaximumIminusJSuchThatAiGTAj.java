package ArraysProblems;

import java.util.Arrays;

// http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

public class MaximumIminusJSuchThatAiGTAj {
	
	static public int maximumGeeks(int[] input) {
		int maxLen = -1;
		
		int[] Lmin = new int[input.length];
		int[] Rmax = new int[input.length];
		Lmin[0] = input[0];
		for(int i = 1; i < input.length; i++) {
			if(Lmin[i-1]>input[i]) {
				Lmin[i] = input[i];
			}
			else {
				Lmin[i] = Lmin[i-1];
			}
		}
		Rmax[input.length-1] = input[input.length-1];
		for(int i = input.length-2; i >= 0 ; i--) {
			if(Rmax[i+1]>input[i]) {
				Rmax[i] = Rmax[i+1];
			}
			else {
				Rmax[i] = input[i];
			}
		}
		//System.out.println(Arrays.toString(Lmin));
		//System.out.println(Arrays.toString(Rmax));
		int i = 0, j= 0;
		int index1 = -1,index2=-1;
		while(j < input.length) {
			if(Rmax[j]>Lmin[i] && (j-i)>maxLen) {
				maxLen = j-i;	
				index1 = j;
				index2 = i;
			}
			else {
				i++;
			}
			j++;
		}
		System.out.println(maxLen+" ( j = "+index1+", i = "+index2+")");
		return maxLen;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		int[] arr2 = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		int[] arr4 = {6, 5, 4, 3, 2, 1};
		MaximumIminusJSuchThatAiGTAj.maximumGeeks(arr1);
		MaximumIminusJSuchThatAiGTAj.maximumGeeks(arr2);
		MaximumIminusJSuchThatAiGTAj.maximumGeeks(arr3);
		MaximumIminusJSuchThatAiGTAj.maximumGeeks(arr4);
		
	}
}
