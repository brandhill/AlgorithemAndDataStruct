package hackerrank.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
	private static Stack<Integer> stack = new Stack<Integer>();
	private static List<Integer> maxlist = new ArrayList<Integer>();
	private static int pointer;
	
	static void push(int N){
		
		if(stack.isEmpty()){
			stack.push(N);
			pointer = 0;
			maxlist.add(pointer, N);
		}
		else{
			int max = maxlist.get(pointer);
			stack.push(N);
			pointer = pointer+1;
			if(N>max) {
				maxlist.add(pointer,N);
			}
			else {
				maxlist.add(pointer, max);	
			}
			
		}
		
	}
	static void pop(){
		stack.pop();
		pointer = pointer - 1;
	}
	
	static int max(){
		if(stack.isEmpty()){
			return 0;
		}
		else {
			return maxlist.get(pointer);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = Integer.valueOf(in.nextLine());
		List<String> list = new ArrayList<String>();
		for( int i = 0; i < count; i++) {
			list.add(in.nextLine());
		}
		for( int i = 0; i < count; i++ ) {
			String s = list.get(i);
			if(s.substring(0,1).equals("2"))
				MaximumElement.pop();
			else if(s.substring(0,1).equals("3"))
				System.out.println(MaximumElement.max());
			else
				MaximumElement.push(Integer.valueOf(s.substring(2, s.length())));
		}
	}
}
