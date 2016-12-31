package ArraysProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * Test cases
 * Starting with either 0 or 1
 * Maximum length of 0 1 2 or more
 * 
*/
public class LargestSubArrayWithEqual0sAnd1s {
	
	// time - O(n)
	static public int equalNumber(int arr[]) {
		
		int[] sum = new int[arr.length];
		sum[0] = ((arr[0]==0)?-1:1);
		for(int i = 1; i < arr.length; i++) {
			sum[i] = sum[i-1] + (arr[i]==0?-1:1);
			System.out.print(sum[i]+" ");
		}
		
		System.out.println();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int maxLen = 0;
		int start = 0;
		int end = 0;
		for(int i = 0; i < sum.length; i++) {
			int s = sum[i];
			if(s==0) {
				maxLen = Math.max(maxLen, i+1);
				if(maxLen==i+1) {
					start = 0;
					end = i+1;
				}
			}
			if(map.containsKey(s)) {
				maxLen = Math.max(maxLen,i-map.get(s));
				if(maxLen==(i-map.get(s))) {
					start = map.get(s)+1;
					end = i;
				}
			}
			else {
				map.put(s, i);
			}
		}
		
		System.out.println(start+" "+end);
		return maxLen;
		}
		
	/// time - O(n^2)
	static public int equalNumber1(int arr[]){
		
		int count0 = 0;
		int count1 = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0)
				count0++;
			else 
				count1++;
		}
		
		if(count0==0 || count1==0) {
			return -1;
		}
		
		int start = 0;
		int end = arr.length-1;
		
		return equalNumberHelper(arr, count0, count1, start, end);
	}
	
	
	public static int equalNumberHelper(int[] arr,int count0,int count1,int start,int end) {
		
		System.out.println("Started..... "+ start+" "+end);
		if(start>=end)
			return 0;
		
		while(start<end) {
			System.out.println(start+" "+end);
			System.out.println(count0+" "+count1);
			System.out.println("---");
			if(count0==count1) {
				System.out.println(start+" "+end);
				return end-start+1;
			}
			
			if(count0>count1) {
				if(arr[end]==0) {
					end--;
					count0--;
				}
				else if(arr[start]==0){
					start++;
					count0--;
				}
				else {
					return Math.max(equalNumberHelper(arr, count0, count1-1, start+1, end), 
							equalNumberHelper(arr, count0, count1-1, start, end-1));
				}
			}
			else {
				if(arr[end]==1) {
					end--;
					count1--;
				}
				else if(arr[end]==1){
					start++;
					count1--;
				}
				else {
					return Math.max(equalNumberHelper(arr, count0-1, count1, start+1, end), 
							equalNumberHelper(arr, count0-1, count1, start, end-1));
				}
			}
			
		}
	
	return 0;
	}
	
	
	public static void main(String[] args) {
		// {1, 0, 1, 1, 1, 0, 0};
		//int[] arr = {1, 1, 1, 1};
		//int[] arr = {0, 0, 1, 1, 0};
		int[] arr = {1,0,0,1,0,1,0,0,0,0,1,1};
		int n = LargestSubArrayWithEqual0sAnd1s.equalNumber(arr);
		System.out.println(n);
	}
}