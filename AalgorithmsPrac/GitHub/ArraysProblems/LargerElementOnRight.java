package ArraysProblems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/next-greater-element/
 * Find next larger element on right side of a number in array for 
 * all positions in array
 * This is different than finding largest element on right side which can 
 * be done by keeping max while iterating from right
 * It is also different from find next higher number on right side which can
 * be found by keeping AVL tree and finding ceiling.
 */
// Time - O(n), Space - O (n)
public class LargerElementOnRight {
	
	static int[] NextLargestElementOnRight(int[] input) {
		
		int[] output = new int[input.length];
		Arrays.fill(output, -1);
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for(int i = 1; i < input.length; i++) {
				while(!stack.isEmpty()) {
					int t = stack.peek();
					if(input[t] < input[i]) {
					output[t] = i;
					stack.pop();
					}
					else {
						break;
					}
				}
				stack.push(i);
			}
			
		
		return output;
	}
	
	
    public static void main(String args[]){
        int input[] = {4,2,-8,6,5,-3,-1,9,1};
        int result[] = LargerElementOnRight.NextLargestElementOnRight(input);
        for(int i=0; i < result.length; i++){
        		if(result[i]!=-1)
                System.out.print(input[result[i]] + " ");
        		else {
        			System.out.print("-1"+" ");
        		}
        }
    }
	
}
