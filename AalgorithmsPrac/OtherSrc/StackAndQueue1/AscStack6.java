package StackAndQueue1;

import java.util.Stack;

public class AscStack6 {
	
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> buffer = new Stack<Integer>();
	
	
	
	Stack<Integer> SortStack(Stack<Integer> input) {
		Stack<Integer> buffer1 = new Stack<Integer>();
		while(!input.isEmpty()) {
			int tmp = input.pop();
			while (!buffer1.isEmpty() && buffer1.peek() > tmp){
				input.push(buffer1.pop());
			}
			buffer1.push(tmp);
		}
		return buffer1;
	}
	
	boolean isEmpty() {
		
		if(stack.isEmpty())
			return true;
		return false;
		
	}
	
	void push(int item) {
		if (stack.isEmpty()) {
			stack.push(item);
			return;
		}
		
		if (stack.peek() > item) {
			while (!stack.isEmpty() && stack.peek() > item ) {
			buffer.push(stack.pop());
			}
		}
		else if(!buffer.isEmpty()) {
			if (buffer.peek() < item) {
					while(!buffer.isEmpty() && buffer.peek() > item) {
						stack.push(buffer.pop());
					}
				}
		}
			stack.push(item);
	}
	
	int pop() {
		if(buffer.isEmpty()) {
			return stack.pop();
		}
		while(!buffer.isEmpty()) {
			stack.push(buffer.pop());
		}
		return stack.pop();
	}
	
	int peek() {
		if(buffer.isEmpty()) {
			return stack.peek();
		}
		while(!buffer.isEmpty()) {
			stack.push(buffer.pop());
		}
		return stack.peek();
	}
	
	public static void main(String[] args) {
		AscStack6 stack = new AscStack6();
		Stack<Integer> input = new Stack<Integer>();
		
		input.push(5);
		input.push(3);
		input.push(4);
		input.push(5);
		input.push(1);
		Stack<Integer> output = stack.SortStack(input);
		System.out.println("pop"+output.pop());
		System.out.println("pop"+output.pop());
		System.out.println("pop"+output.pop());
		System.out.println("pop"+output.pop());
		System.out.println("pop"+output.pop());
		
	}
	
}
