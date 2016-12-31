package hackerrank.dynamic;

// http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
// https://www.hackerrank.com/challenges/longest-increasing-subsequent

// Time - O(n log n)
// Space - O(n)
public class LongestIncreasingSubsequence {
	
	// Binary Search
	static int getIndex(int[] result,int start,int end,int key) {
		
		while(end>=start) {
			//System.out.println(end+" "+start);
			int index = ((end+start)/2);
			if(result[index]<key) {
				if(result[index+1]>key)
					return index;
				start = index+1;
			}
			else {
				end = index-1;
			}
		}
		
		return end;
	}
	
	static int LongestSubSequence1(int[] input) {
		if(input.length<1) {
			return 0;
		}
		
		int[] result = new int[input.length];
		int k = 1;
		result[0] = input[0];
		
		for(int i = 1; i < input.length; i++) {
			if(input[i]<result[0]) {
				result[0] = input[i];
			}
			else if(input[i]>result[k-1]) {
				result[k++] = input[i];
			}
			else {
				result[getIndex(result, 0, k-1, input[i])+1] = input[i];
			}
			//System.out.println(Arrays.toString(result));
		}
		return k; 
	}
	
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = new int[size];
		for( int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}*/
		//int[] array =  { 15, 27, 14, 38, 26, 55, 46, 65, 85 };
		//int[] array =  { 5,4,3,2,1 };
		//int[] array =  { 10,8,9,15,13,14,20,18,19 };
		//int[] array = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		//int[] array = {7,9,12,13,14,15,18,20,8};
		int[] array = {7,9,12,13,14,15,18,20,17};
		int result = LongestIncreasingSubsequence.LongestSubSequence1(array);
		System.out.println(result);
	}
}
