package ArraysProblems;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWithinkIndices {
	
	static public boolean duplicate(int[] input,int k) {
		
		Map<Integer,Integer> map  = new HashMap<Integer,Integer>();
		for (int i = 0; i < input.length; i++) {
			if(map.containsKey(input[i])) {
				if(i - map.get(input[i]) <= k) {
					return true;
				}
			}
			map.put(input[i], i);
		}

		return false;
	}
	
	public static void main(String[] args) {
		 int arr[] = {1,2,3,11,1,2,2};
	        DuplicateWithinkIndices dk = new DuplicateWithinkIndices();
	        System.out.println(dk.duplicate(arr, 3));
	}
}
