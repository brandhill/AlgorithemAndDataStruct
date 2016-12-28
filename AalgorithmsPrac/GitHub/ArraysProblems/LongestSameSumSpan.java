package ArraysProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* * Give two arrays of same size consisting of 0s and 1s find span (i, j) such that
 * sum of input1[i..j] = sum of input2[i..j]
 *
 * Time complexity O(n)
 * Space complexity O(n)
 *
 * http://www.geeksforgeeks.org/longest-span-sum-two-binary-arrays/
 */

public class LongestSameSumSpan {
	
	// Span should have equal number of 0 and 1 -- Incorrect Solution
	static int findLargestSpan(int[] arr1,int[] arr2) { 
		int maxLen = 0;
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
		int sum1 = 0;
		int sum2 = 0;
		int start = 0;
		int end = 0;
		map1.put(0, 0);
		map2.put(0, 0);
		for(int i=0; i < arr1.length; i++ ) {
			sum1 += (arr1[i]==1)?1:-1;
			sum2 += (arr2[i]==1)?1:-1;
			if(map1.containsKey(sum1) && map2.containsKey(sum2)) {
				int num1 = map1.get(sum1);
				int num2 = map2.get(sum2);
				if(num1==num2 && i-num1+1>maxLen) {
					maxLen = i-num1+1;
					start = num1;
					end = i;
				}
			}
			else {
				if(!map1.containsKey(sum1))
						map1.put(sum1, i);
				if(!map2.containsKey(sum2))
						map2.put(sum2, i);
			}
		}
		System.out.println(start+" "+end);
		return maxLen;
	}
	
	// Span need not have equal number of 0 and 1
	static int findLargestSpan1(int[] arr1,int[] arr2) {
		int n = arr1.length;
		int[] lookUp = new int[2*n+1];
		Arrays.fill(lookUp, -1);
		int maxLen = 0;
		int sum1 = 0;
		int sum2 = 0;
		int start = 0;
		int end = 0;
		for(int i = 0; i < n; i++) {
			sum1 += arr1[i];
			sum2 += arr2[i];
			int diff = sum1-sum2;
			if(diff==0) {
				maxLen = i+1;
				start = 0;
				end = i+1;
			}
			else if(lookUp[n+diff]==-1) {
				System.out.println(diff);
				lookUp[n+diff] = i;
			}
			else {
				int len = i - lookUp[n+diff];
				//maxLen = Math.max(maxLen,len);
				if(len>maxLen) {
					maxLen = len;
					start = lookUp[n+diff]+1;
					end = i;
				}
			}
		}
		System.out.println(start+" "+end);
		return maxLen;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,0,0,1,0,1,1,1,1};
		int[] arr2 = {0,0,1,0,1,0,1,1,1};
		int len = LongestSameSumSpan.findLargestSpan1(arr1, arr2);
		System.out.println(len);
	}
}
