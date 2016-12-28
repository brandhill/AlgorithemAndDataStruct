package hackerrank.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	
	static String checkbalance(String s){
		Stack<Character> stack = new Stack<Character>();
		char[] chars = s.toCharArray();
		
		for( int i = 0; i < s.length(); i++) {
			char input = chars[i];
			if( input == '[' || input == '{' || input=='(')
				stack.push(input);
			else {
				if(!stack.isEmpty()) {
					char check = stack.pop();
					if(input == ']' && check != '['){
						return "NO";
					}
					else if(input == ')' && check != '('){
						return "NO";
					}
					else if(input == '}' && check != '{'){
						return "NO";
					}
				}
				else {
					return "NO";
				}
			}
		}
		
		if(stack.isEmpty())
			return "YES";
		else
			return "NO";
		
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<String> list = new ArrayList<String>();
        for(int a0 = 0; a0 < t; a0++) {
            list.add(in.next());
        }
        
        for(int i = 0; i < t; i++) {
        	System.out.println(BalancedBrackets.checkbalance(list.get(i)));
        }
    }
}
