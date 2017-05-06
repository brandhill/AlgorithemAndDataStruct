package CareerCup;

// https://www.careercup.com/question?id=5146233651855360

import java.util.Arrays;

public class MiceAndHoles {
	// mice and holes length are equal
	int getMaxTime(int[] mice, int[] holes) {
		Arrays.sort(mice);
		Arrays.sort(holes);
		int max = Integer.MIN_VALUE;
		for(int i=0; i< mice.length; i++) {
			int n  = Math.abs(mice[i]-holes[i]);
			max = n>max?n:max;
		}
		return max;
	}
	
	// not equal
	
	
	
	public static void main(String[] args) {
		
	}
	
}


