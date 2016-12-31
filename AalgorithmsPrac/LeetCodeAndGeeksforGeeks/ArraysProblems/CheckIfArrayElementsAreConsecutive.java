package ArraysProblems;

import java.util.HashSet;
import java.util.Set;

public class CheckIfArrayElementsAreConsecutive {
	
	// Time  - O(n)
	// Space - O(n)
	static public boolean areConsecutive(int[] inputs){
		
		if(inputs.length < 2) {
			return true;
		}
		Set<Integer> set = new HashSet<Integer>();
		int min = inputs[0];
		int max = inputs[0];
		for ( int i = 1; i < inputs.length; i++) {
			int num = inputs[i];
			if(set.contains(num)) {
				return false;
			}
			set.add(num);
			if(num < min){
				min = num;
			}
			else if (num > max){
				max = num;
			}
		}
		if(max-min+1==inputs.length)
			return true;
		else
			return false;
	}
	
	// Time  - O(n)
	// Space - O(1)
	static public boolean areConsecutive1(int[] inputs){
		
		int min = Integer.MIN_VALUE;
		for ( int i =0 ; i < inputs.length;i++) {
			if(inputs[i] < min) {
				min = inputs[i];
			}
		}
		for (int i = 0; i < inputs.length; i++) {
			if(Math.abs(inputs[i])-min >= inputs.length){
				return false;
			}
			if(inputs[Math.abs(inputs[i]-min)] < 0){
				return false;
			}
			inputs[Math.abs(inputs[i]-min)] = -inputs[Math.abs(inputs[i]-min)];
		}
		
		return true;
	}
	public static void main(String[] args) {
		int[] inputs = {0, 2, 3, 1, 4};
		boolean b = CheckIfArrayElementsAreConsecutive.areConsecutive(inputs);
		System.out.println(b);
	}
}
