package ArraysProblems;

import java.util.Arrays;

// http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/

public class RepeatingAndMissingNumber {
	// Time - O(n(log n))
	// Space - O(1)
	public void findNumbers(int[] input) {
		int repeat = -1;
		int missing = -1;
		Arrays.sort(input);
		//System.out.println(Arrays.toString(input));
		for(int i = 0; i < input.length; i++) {
			if(repeat == -1) {
				if(input[i]==input[i+1]) {
					repeat = input[i];
					missing = i+1;
				}
			}
			else {
				if(input[i]!=i+1) {
					missing = i+1;
				}
			}
		}
		System.out.println(repeat+" "+missing);
	}
	
		// Time  - O(n)
		// Space - O(n)
		public void findNumbers1(int[] input) {
			boolean[] check = new boolean[input.length+1];
			int missing = -1;
			int repeat = -1;
			for(int i = 0; i < input.length; i++) {
				if(check[input[i]]) {
					repeat = input[i];
				}
				check[input[i]] = true;
			}
			for(int i = 1; i < input.length+1; i++) {
				if(!check[i]) {
					missing = i;
				}
			}
			System.out.println(repeat+" "+missing);
		}
	
	public static void main(String[] args) {
		RepeatingAndMissingNumber rmn = new RepeatingAndMissingNumber();
        int input[] = {3,1,2,4,6,8,2,7};
        int input1[] = {4, 3, 6, 2, 1, 1};
        int input2[] = {3, 1, 3};
        rmn.findNumbers(input);
        rmn.findNumbers1(input);
        rmn.findNumbers(input1);
        rmn.findNumbers1(input1);
        rmn.findNumbers(input2);
        rmn.findNumbers1(input2);
	}
	
}
