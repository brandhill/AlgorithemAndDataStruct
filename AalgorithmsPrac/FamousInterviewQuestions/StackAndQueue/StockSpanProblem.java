package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

// http://www.geeksforgeeks.org/the-stock-span-problem/

// Time - O(n)
// Space - O(n)

public class StockSpanProblem {
	public static int[] stockSpan(int[] prices){ 
		int[] span = new int[prices.length];
		Stack<Integer> stack = new Stack<Integer>();
		span[0] = 1;
		stack.push(0);
		for (int i = 1; i < prices.length; i++) {
			int count = 1;
			while(prices[i]>=prices[stack.peek()]) {
				count += span[stack.pop()];
			}
			span[i] = count;
			stack.push(i);
		}
		
		return span;
	}
	
	public static void main(String[] args) {
		 	int[] prices = {100, 80, 60, 70, 60, 75, 85};
	        int[] result = stockSpan(prices);
	        System.out.print(Arrays.toString(result));
	}
}
