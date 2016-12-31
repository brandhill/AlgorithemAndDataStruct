package ArraysProblems;

/**
 * http://stackoverflow.com/questions/4686823/given-2-sorted-arrays-of-integers-find-the-nth-largest-number-in-sublinear-time
 * http://articles.leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
 */


// Incomplete

public class KthLargestInTwoSortedArray {
	
	int KthLargest(int[] arr1, int[] arr2,int k) {
		return KthLargest(arr1, arr2,0,arr1.length-1,0,arr2.length-1,k);
		
	}
	
	int KthLargest(int[] arr1, int[] arr2,int l1,int h1,int l2,int h2,int k) {
		
		
		
		int m1 = (h1+l1)/2;
		int m2 = (h2+l2)/2;
		
		int count1 = m1-l1+1;
		int count2 = m2-l2+1;
		
		if(count1+count2==k) {
			return Math.max(arr1[m1], arr2[m2]);
		}
		else if(count1+count2>k){
			if(arr1[m1]>arr2[m2]) {
				KthLargest(arr1, arr2, l1, m1, l2, h2, k);
			}
			else {
				KthLargest(arr1, arr2, l1, h1, l2, m2, k);
			}
		}
		else {
			if(arr1[m1]>arr2[m2]) {
				KthLargest(arr1, arr2, l1, h1, m2+1, h2, k);
			}
			else {
				KthLargest(arr1, arr2, m1+1, h1, l2, h2, k);
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
	}
}
