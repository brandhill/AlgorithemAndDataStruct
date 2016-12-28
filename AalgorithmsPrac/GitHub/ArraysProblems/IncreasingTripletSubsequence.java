package ArraysProblems;

// https://leetcode.com/problems/increasing-triplet-subsequence/

public class IncreasingTripletSubsequence {

	 static boolean IsTripletExits(int[] input) {
		 int high = Integer.MIN_VALUE;
		 int low = Integer.MIN_VALUE;
		 for(int i= input.length-2; i >=0; i--) {
			 if(input[i] < low) {
				 return true;
			 }
			 if(input[i]<input[i+1]) {
				if(input[i+1]>=high) {
					high = input[i+1];
					low = input[i];
				}
				else {
					low = input[i+1];
				}
			 }
		 }
		 return false;
	}
	 
	 public static void main(String[] args) {
		int[] input = {1, 2, 9, 2, 5, 0, 11};
		int[] input1 = {1, 2, 9, 2, 11, 3, 5};
		int[] input2 = {1, 0, 0, 0, 2, 0, 5};
		System.out.println(IsTripletExits(input));
	}
}


/// 1 9 2 10 11 4 5