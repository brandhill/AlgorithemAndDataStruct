package CareerCup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// https://www.careercup.com/question?id=5760923399618560

public class FindSubsetSumEqualToN {
	
	// Time - 2^n
	static int findSumWithMap(int[] array, int n) {
		
		Arrays.sort(array);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i< array.length; i++) {
			if(array[i]==n)
				return 1;
			else if(array[i]>n)
				return -1;
			Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>(map);
			for(Integer sum: tempMap.keySet()) {
				int newSum = sum+array[i];
				if(newSum==n)
					return map.get(sum)+1;
				if(newSum<n && !map.containsKey(newSum)) {
					map.put(newSum, map.get(sum)+1);
				}
			}
			map.put(array[i], 1);
		}
		return -1;
	}
	
	static int findSum(int[] array, int n) {
		
		Arrays.sort(array);
		
		return findSubsetHelper(array,n,0);
	}
	
	
	static int findSubsetHelper(int[] array, int n, int start) {
		if(n==0) {
			return 0;
		}
		if(n<0) {
			return -1;
		}
		
		for(int i= start; i< array.length; i++) {
			int len = findSubsetHelper(array,n-array[i],i+1);
			if(len>=0) {
				return len+1;
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,6};
		System.out.println(findSum(arr, 4));
		System.out.println(findSumWithMap(arr, 4));
	}
}
