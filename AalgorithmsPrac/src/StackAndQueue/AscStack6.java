package StackAndQueue;

import java.util.Stack;

public class AscStack6 {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	Stack<Integer> getStack(){
		return s1;
	}
	
	void push1(int i){
		if(s1.isEmpty()){
			s1.push(i);
		}
		else{
			
			while(!s1.isEmpty() && i<s1.peek() ){
				s2.push(s1.pop());
			}
			s1.push(i);
			while(!s2.isEmpty()){
				s1.push(s2.pop());
			}
		}
	}
	
	Integer pop(){
		return s1.pop();
	}
	
	Integer peek(){
		return s1.peek();
	}
	
	public static void main(String[] args) {
		AscStack6 q6 = new AscStack6();
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(2);
		s.push(6);
		s.push(3);
		s.push(10);
		s.push(0);
		while(!s.isEmpty()){
			q6.push1(s.pop());
		}
		
		s = q6.getStack();
		
		System.out.println(s.pop().intValue());
		System.out.println(s.pop().intValue());
		System.out.println(s.pop().intValue());
		System.out.println(s.pop().intValue());
		System.out.println(s.pop().intValue());
		System.out.println(s.pop().intValue());
	}
}
