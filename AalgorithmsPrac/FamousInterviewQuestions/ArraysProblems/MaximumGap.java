package ArraysProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-gap/

// Maximum distance in the actual array between the successive elements in its sorted form

public class MaximumGap {
	// Time  - O(n*log n)
	// Space - O(n)
	static int findMaxGap(int[] array) {
		if(array.length<2) {
			return 0;
		}
		index[] sort = new index[array.length];
		for(int i = 0; i < array.length; i++) {
			sort[i] = new index(array[i],i);
		}
		Arrays.sort(sort);
		int max = 0;
		for(int i = 1; i < array.length-1; i++) {
			int num = Math.max(Math.abs(sort[i].index-sort[i-1].index), Math.abs(sort[i].index-sort[i+1].index))-1;
			if(num>max) {
				max = num;
			}
		}
		return max;
	}
	
	// Only for next previous elements in the array
	// Time - O(n)
	// Spance - O(n)
	static int findMaxGap1(int[] array) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] distance = new int[array.length];
		int max = 0;
		for(int i = 0; i < array.length; i++) {
			int num = array[i];
			if(map.containsKey(num-1)) {
				int dist = i - map.get(num-1)-1;
				if(dist>distance[i]) {
					distance[i] = dist;
				}
			}
			if(map.containsKey(num+1)) {
				int dist = i - map.get(num+1)-1;
				if(dist>distance[i]) {
					distance[i] = dist;
				}
			}
			map.put(num, i);
		}
		
		for(int i = 0; i < array.length; i++) {
			if(distance[i]>max) {
				max = distance[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] array = {4,2,20,9,12,8,13,10};
		int max = MaximumGap.findMaxGap(array);
		System.out.println(max);
	}
}
