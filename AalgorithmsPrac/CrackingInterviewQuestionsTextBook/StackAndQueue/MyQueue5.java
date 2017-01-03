package StackAndQueue;
import java.util.Stack;
public class MyQueue5 {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	void push1(int n){
		s1.push(n);
	}
	
	Integer pop1(){
		Integer result = queue(s1,s2);
		Integer add = queue(s2,s1);
		s1.push(add);
		return result;
	}
	
	private Integer queue(Stack s1,Stack s2){
		while(!s1.isEmpty()){
			Integer i = (Integer) s1.pop();
			if(s1.isEmpty())
				return i;
			else{
				s2.push(i);
			}	
		}
		
		return null;
	}
	
	public static void main(String[] args) {
	
		MyQueue5 q5 = new MyQueue5();
		q5.push1(1);
		q5.push1(2);
		q5.push1(3);
		q5.push1(4);
		System.out.println(q5.pop1().intValue());
		System.out.println(q5.pop1().intValue());
		System.out.println(q5.pop1().intValue());
		System.out.println(q5.pop1().intValue());
	}
	
	
}
