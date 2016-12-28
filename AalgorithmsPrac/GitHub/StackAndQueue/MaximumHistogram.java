package StackAndQueue;

import java.util.Stack;

import javax.swing.plaf.synth.SynthStyle;

// http://www.geeksforgeeks.org/largest-rectangle-under-histogram/

// Time - O(n)
// Space - O(n)
public class MaximumHistogram {
	static int maxAreaHistogram(int[] array) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while(i < array.length) {
			if(stack.isEmpty() || array[i] >= array[stack.peek()]) {
				stack.push(i);
				i++;
			}
			else {
				maxArea = calArea(array,stack,i,maxArea);
			}
		}
		while(!stack.isEmpty()) {
			maxArea = calArea(array,stack,array.length,maxArea);
		}
		return maxArea;
	}
	
	private static int calArea(int[] array,Stack<Integer> stack,int i,int maxArea) {
		int val = array[stack.pop()];
		int area = val*(stack.isEmpty()?i:i-stack.peek()-1);
		if(area>maxArea) {
			maxArea = area;
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		MaximumHistogram mh = new MaximumHistogram();
        //int input[] = {2,2,2,6,1,5,4,2,2,2,2};
		int input[] = {6, 2, 5, 4, 5, 1, 6};
		//int input[] = {3,3,1,3,3,1,3,1,2};
        int maxArea = mh.maxAreaHistogram(input);
        System.out.println(maxArea);
	}
}
