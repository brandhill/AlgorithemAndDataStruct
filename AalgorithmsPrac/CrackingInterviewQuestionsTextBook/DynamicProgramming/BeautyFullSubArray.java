package DynamicProgramming;

public class BeautyFullSubArray {
	
	static int checkIfGood(int[] a, int m) {
		int count = 0;
		int runningCount = 0;
		int slow = 0;
		int fast = 0;
		while(fast<a.length) {
			if(a[fast]%2==1) {
				runningCount++;
				if(m==1) {
					count++;
					System.out.println(fast+": "+count);
				}
			}
			
			if(runningCount==m) {
				if(fast==a.length-1 || a[fast+1]%2==1) {
					while(runningCount==m) {
						if(slow!=fast && runningCount==m) {
							count++;
							System.out.println(slow+" "+fast+": "+count);
						}
						if(a[slow]%2==1) {
							runningCount--;
						}
						slow++;
					}
				}
				else {
					count++;
					System.out.println(slow+" "+fast+": "+count);
				}
				
			}
			
			fast++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {2,4,5,6,7,4,9,4,2};
				// 0 1 2 3 4 5 6 7 8 9
		int n  = BeautyFullSubArray.checkIfGood(a, 1);
		System.out.println(n);
	}
}
