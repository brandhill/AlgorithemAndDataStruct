package VeryImportantQuestions;

public class maxSubArray {
	
	static int findMaxSumOfSubArray(int[] array) {
		int maxSum = 0;
		int runningSum = 0;
		int start = -1;
		int end = -1;
		int startf = -1;
		int endf = -1;
		for(int i = 0; i < array.length; i++) {
			runningSum +=array[i];
			if(runningSum < 0) {
				runningSum = 0;
				start = -1;
				end = -1;
			}
			else {
				if(start==-1)
					start = i;
			}
			if(runningSum>=maxSum) {
				maxSum = runningSum;
				startf = start;
				endf = i;
			}
		}
		System.out.println(startf+" "+endf);
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] input = {1,-2,1,2,3,5,-11,11,12};
		System.out.println(findMaxSumOfSubArray(input));
	}
}
