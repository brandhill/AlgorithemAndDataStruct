package StackAndQueue;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 */

// Time  - O(n)
// Space - O(n)
public class ReverseStack {
	public void reverse(Stack<Integer> stack,int size){
		int[] array = new int[size];
		reverseHelper(stack,array,0,size-1);
	}
	
	public void reverseHelper(Stack<Integer> stack,int[] array,int i,int j){
		if(stack.isEmpty())
			return;
		array[i] = stack.pop();
		reverseHelper(stack,array,i+1,j-1);
		stack.push(array[j]);
	}
	public static void main(String[] args) {
		ReverseStack rs = new ReverseStack();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.peek());
		rs.reverse(stack,stack.size());
		//System.out.println(stack.peek());
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
