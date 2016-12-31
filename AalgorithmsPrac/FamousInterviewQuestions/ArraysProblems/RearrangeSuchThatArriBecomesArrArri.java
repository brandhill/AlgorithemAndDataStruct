package ArraysProblems;

import java.util.Arrays;

// http://www.geeksforgeeks.org/rearrange-given-array-place/

public class RearrangeSuchThatArriBecomesArrArri {
	
	// Time - O(n)
	// Space - O(n)
	public void rearrange(int arr[]){
		boolean[] check = new boolean[arr.length];
		int temp;
		int index;
		for(int i = 0; i < arr.length; i++) {
			temp = arr[i];
			index = i;
			while(!check[index]) {
				check[index] = true;
				int nextIndex = arr[index];
				if(nextIndex==i) {
					arr[index] = temp;
					break;
				}
				arr[index] = arr[nextIndex];
				//System.out.println(index+" "+arr[index]);
				index = nextIndex; 
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		 int arr[] = {3, 2, 0, 1};
		 int arr1[] = {4, 0, 2, 1, 3};
		 int arr2[] = {0, 1, 2, 3};
		 int arr3[] = {0};
	        RearrangeSuchThatArriBecomesArrArri rss = new RearrangeSuchThatArriBecomesArrArri();
	        rss.rearrange(arr);
	        rss.rearrange(arr1);
	        rss.rearrange(arr2);
	        rss.rearrange(arr3);
	}
}
