package hackerrank.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
	//static StringBuffer editor = new StringBuffer("");
	static String editor = "";
	static Stack<String> stack = new Stack<String>();
	static Character textEditor(String input){
		int index = Integer.valueOf(input.substring(0,1));
		if( index == 1 ) {
			editor = editor + input.substring(2);
			stack.push(input);
		}
		else if( index == 2) {
			int start = editor.length()-Integer.valueOf(input.substring(2));
			//int end = editor.length();
			String deleteChars = editor.substring(start);
			stack.push(input.substring(0, 1)+" "+deleteChars);
			editor = editor.substring(0, start);
			
		}
		else if( index == 3) {
			char x = editor.charAt(Integer.valueOf(input.substring(2))-1);
			return x;
		}
		else {
			String output = stack.pop();
			int index1 = Integer.valueOf(output.substring(0,1));
			if( index1 == 2) {
				editor = editor + output.substring(2);
			}
			else if( index1 == 1) {
				editor = editor.substring(0,editor.length()-output.substring(2).length() );
			}
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = Integer.valueOf(in.nextLine());
		List<Character> list = new ArrayList<Character>();
		long startTime = System.currentTimeMillis();
		//for(int i = 0 ; i < count;i++){
			
		//}
		for( int i = 0; i < count; i++) {
			String s = in.nextLine();
			Character x = SimpleTextEditor.textEditor(s);
			if(x != null)
				list.add(x);
		}
		for ( int i= 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);
		//long startTime = System.currentTimeMillis();
		/*for( int i = 0; i < count; i++) {
			SimpleTextEditor.textEditor(list.get(i));
		}*/
		//long stopTime = System.currentTimeMillis();
	      //long elapsedTime = stopTime - startTime;
	      //System.out.println(elapsedTime);
		
	}
}
