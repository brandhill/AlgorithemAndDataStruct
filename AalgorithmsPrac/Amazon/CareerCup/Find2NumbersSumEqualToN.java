package CareerCup;

import java.util.HashSet;
import java.util.Set;

// https://www.careercup.com/question?id=5727163577794560

public class Find2NumbersSumEqualToN {
	static void findPairs(int[] arr, int n) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set1 = new HashSet<Integer>();
		
		for(int i=0; i< arr.length; i++) {
			if(!set1.contains(arr[i])) {
				if(set.contains(n-arr[i])) {
					System.out.println(arr[i]+" "+(n-arr[i]));
					set.remove(n-arr[i]);
					set1.add(arr[i]);
					set1.add(n-arr[i]);
				} else {
					set.add(arr[i]);
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,8,2,8,5,9,5};
		findPairs(arr,10);
	}
}
