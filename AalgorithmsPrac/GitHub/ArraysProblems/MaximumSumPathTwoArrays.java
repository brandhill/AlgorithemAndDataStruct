package ArraysProblems;

// http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/

// Time - O(n)
// Space - O(1)
public class MaximumSumPathTwoArrays {
	
	
	public int maxSum(int[] arr1,int[] arr2) {
		int maxSum = 0;
		int sum1 = 0,sum2 = 0;
		
		int i = 0, j = 0;
		
		while (i<arr1.length && j < arr2.length) {
			if(arr1[i]==arr2[j]) {
				//System.out.println(sum1+" "+sum2);
				maxSum += Math.max(sum1, sum2) + arr1[i];
				sum1 = 0;
				sum2 = 0;
				i++;
				j++;
			}
			else if(arr1[i]<arr2[j]){
				sum1 += arr1[i++];
			}
			else {
				sum2 += arr2[j++];
			}
		}
		
		while(i<arr1.length) {
			sum1 += arr1[i++];
		}
		
		while(j<arr2.length) {
			sum2 += arr2[j++];
		}
		//System.out.println(sum1+" "+sum2);
		maxSum += Math.max(sum1, sum2);
		
		return maxSum;
	}
	
	public static void main(String args[]) {
        //int input1[] = {2, 3, 7, 10, 12, 15, 30, 34};
        //int input2[] = {1, 5, 7, 8, 10, 15, 16, 19};
        //int input1[] = {2, 3, 7, 10, 12}, input2[] = {1, 5,6, 7, 8};
		int input1[] = {10, 12}, input2[] = {5, 7, 9};
        MaximumSumPathTwoArrays msp = new MaximumSumPathTwoArrays();
        System.out.println(msp.maxSum(input1, input2));
    }
}
