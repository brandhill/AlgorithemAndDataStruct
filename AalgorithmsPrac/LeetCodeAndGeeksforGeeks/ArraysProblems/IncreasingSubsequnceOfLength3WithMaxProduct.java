package ArraysProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//http://www.geeksforgeeks.org/increasing-subsequence-of-length-three-with-maximum-product/

// Space - O(n)
// Time - O(n log n)

public class IncreasingSubsequnceOfLength3WithMaxProduct {
	
	// 
	static int maxProduct(int[] input) {
		
		int[] Rmax = new int[input.length];
		//int[] Lmax = new int[input.length];
		//Arrays.fill(Rmax, -1);
		index[] sort = new index[input.length];
		sort[input.length-1] = new index(input[input.length-1],input.length-1);
		sort[0] = new index(input[0],0);
		for(int i = input.length-2; i > 0; i--) {
			sort[i] = new index(input[i],i);
			int max = Math.max(input[i+1], Rmax[i+1]); 
			Rmax[i] =  (max >= input[i])? max:0;
		}
		
		int[] LmaxIndex = new int[input.length];
		LmaxIndex[0] = -1;
		Arrays.sort(sort);
		for(int i = 1; i < input.length; i++) {
			int in = sort[i-1].index;
			int current = sort[i].index;
			if(current < in) {
				while( in!= -1 && in>current ) {
					in = LmaxIndex[in];
				}
			}
			LmaxIndex[current] = in;
			System.out.println(Arrays.toString(LmaxIndex));
			//Lmax[current] = (in==-1)?-1:input[in]; 
		}
		System.out.println(Arrays.toString(LmaxIndex));
		//int prev = 0;
		/*for(int i = 1; i < input.length; i++) {
			//int index = i-1;
				int index = i-1;
				int max = 0;
				while(index>=0) {
					if(input[index]<=input[i]) {
						if(input[index]>max) {
							max = input[index];
						}
					}
					index--;
				}
				Lmax[i] = max;
		}*/
		int maxProduct = 0;
		for(int i = 0; i < input.length; i++) {
			int left = LmaxIndex[i]==-1?-1:input[LmaxIndex[i]];
			int val = left*input[i]*Rmax[i];
			if(val > maxProduct) {
				maxProduct = val;
			}
		}
		return maxProduct;
	}
	
	public static void main(String args[]){
        int arr[] = {6, 7, 8, 1, 2, 3, 9, 10};
        IncreasingSubsequnceOfLength3WithMaxProduct iss = new IncreasingSubsequnceOfLength3WithMaxProduct();
        System.out.println(iss.maxProduct(arr));
        int arr1[] = {1, 5, 9, 10,7,8,11,12, 9};
        System.out.println(iss.maxProduct(arr1));
        int arr2[] = {5,4,1,2,3};
        System.out.println(iss.maxProduct(arr2));
    }
}

class index implements Comparable {
	int val;
	int index;
	
	index(int val, int index) {
		this.val = val;
		this.index = index;
	}
	@Override
	public int compareTo(Object o) {
		index i = (index) o;
		if(this.val > i.val) {
			return 1;
		}
		else if(this.val < i.val) {
			return -1;
		}
		return 0;
	}
}