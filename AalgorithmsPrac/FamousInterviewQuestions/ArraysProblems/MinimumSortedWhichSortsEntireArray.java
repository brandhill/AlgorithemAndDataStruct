package ArraysProblems;

// http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/

// Time - O(n)
// Space - O(1)

public class MinimumSortedWhichSortsEntireArray {
	
	public int minLength(int[] input) {
		int len = 0;
		
		int min = input[0];
		int max = input[0];
		int start = -1;
		int end = -1;
		for(int i = 0; i < input.length-1; i++) {
			if(input[i]>max) {
				max = input[i];
			}
			else if(input[i]<min) {
				min = input[i];
				start = 0;
				continue;
			}
			
			if(start!=-1) {
				if(input[i]>input[i+1] || input[i] < max || input[i] < min) {
					end = i+1;
				}
			}
			else {
				if(input[i]>input[i+1]) {
					int j = i;
					while(j>=0) {
						if(input[j]<input[i+1]) {
							break;
						}
						j--;
					}
					start = j+1;
					end = i+1;
				}
			}
		}
		System.out.println(start+" "+end);
		if(start==-1)
			return -1;
		else			
			return end-start+1;
	}
	public static void main(String args[]){
        int arr[] = {4,5,10,21,18,23,7,8,19,34,38};
        int arr1[] = {4,5,6,12,11,15};
        int arr2[] = {4,5,6,10,11,15};
        int arr3[] = {0, 1, 15, 25, 6, 7, 30, 40, 50};
        MinimumSortedWhichSortsEntireArray msw = new MinimumSortedWhichSortsEntireArray();
        System.out.println(msw.minLength(arr3));
    }
}
