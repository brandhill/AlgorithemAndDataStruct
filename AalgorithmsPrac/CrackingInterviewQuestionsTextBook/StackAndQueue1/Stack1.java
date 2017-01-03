package StackAndQueue1;

import java.util.Stack;

public class Stack1 {
	
	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> min = new Stack<Integer>();
	
	static void push(int i) {
		if( stack.isEmpty() ) {
			min.push(i);
		}
		else {
			int min1 =  Math.min(min.peek(), i);
			min.push(min1);
		}
		
		stack.push(i);
	}
	
	static int pop(){
		min.pop();
		return stack.pop();
	}
	
	static int min() {
		return min.peek();
	}
	
	
	public static void main(String[] args) {
		Stack1.push(5);
		Stack1.push(4);
		Stack1.push(3);
		Stack1.push(2);
		Stack1.push(1);
		Stack1.push(5);
		System.out.println("min "+Stack1.min());
		System.out.println(Stack1.pop());
		System.out.println(Stack1.pop());
		System.out.println("min "+Stack1.min());
		System.out.println(Stack1.pop());
		System.out.println("min "+Stack1.min());
		
	}
}
