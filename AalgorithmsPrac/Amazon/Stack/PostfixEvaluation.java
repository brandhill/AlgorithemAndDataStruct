package Stack;

import java.util.Stack;

public class PostfixEvaluation {
	
	static int EvaluatePostfix(String s) {
		int value= 0;
		
		Stack<Integer> stack = new Stack<Integer>(); 
		
		int i =0;
		while(i<s.length()) {
			char c = s.charAt(i);
			if(c=='*' || c=='%' || c=='+' || c=='-' || c=='/') {
				break;
			}
			stack.push(Integer.valueOf(""+c));
			i++;
		}
		
		while(stack.size()!=1) {
			int n = stack.pop();
			int m = stack.pop();
			stack.push(performOperation(m,n,s.charAt(i)));
			i++;
		}
		
		return stack.pop();
	}
	
	static Integer performOperation(int m, int n, char c) {
		Integer result = null;
		if(c=='*') {
			result = m*n;
		} else if(c=='%') {
			result = m%n;
		} else if(c=='+') {
			result = m+n;
		} else if (c=='-') {
			result = m-n;
		} else if(c=='/') {
			result = m/n;
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(EvaluatePostfix("4320+-+"));
	}
	
}
