package CareerCup;

// https://www.careercup.com/question?id=5746120238039040

public class ClimbMaxStairs {
	static int FindMaxStairsClimbable(int movesToMake, int brokenStep) {
		int sum = 0;
		int totalSum = (movesToMake*(movesToMake+1))/2;
		for(int i=1; i<= movesToMake; i++) {
			sum += i;
			if(sum==brokenStep) {
				return totalSum-1;
			}
			else if(sum>brokenStep)
				return totalSum;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(FindMaxStairsClimbable(4,10));
		System.out.println(FindMaxStairsClimbable(3,1));
		System.out.println(FindMaxStairsClimbable(3,2));
	}
	
}
