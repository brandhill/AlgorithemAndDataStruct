package StackAndQueue1;

import java.util.Stack;

public class MyQueue5 {
	
	private  Stack<Integer> stack1  = new Stack<Integer>();
	private  Stack<Integer> stack2  = new Stack<Integer>();
	
	/*void MyQueue5 (){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}*/
	
	void push(int item) {
		stack1.push(item);
	}
	
	int pop() {
		if(stack2.isEmpty()) {
			pushData();
		}
			return stack2.pop();
	}
	
	int peek() {
		if(stack2.isEmpty()) {
			pushData();
		}
			return stack2.peek();
	}
	
	
	private void pushData() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}
	
	public static void main(String[] args) {
		MyQueue5 queue = new MyQueue5();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.peek());
	}
}
