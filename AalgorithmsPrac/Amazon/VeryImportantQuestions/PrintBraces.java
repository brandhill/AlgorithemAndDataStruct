package VeryImportantQuestions;

import java.util.List;

//Curly braces can be used in programming to provide scope-limit. Write a function to print
//all valid( properly opened and closed) combinations of n-pairs of curly braces.
//Example:
//input: 1 output: {}
//input: 2 output: {}{}, {{}}
//input: 3 output: {}{}{}, {}{{}}, {{}}{}, {{}{}}, {{{}}}
//input: 4 output: {}{}{}{}, {}{}{{}}, {}{{}}{}, {}{{}{}}, {}{{{}}}, {{}}{}{}, {{}}{{}}, {{}{}}{}, {{}{}{}}, {{}
//{{}}}, {{{}}}{}, {{{}}{}}, {{{}{}}}, {{{{}}}}

public class PrintBraces {
	
	static void printBraces(int n) {
		printBraces("",n,n);
	}
	
	static private void printBraces(String s, int i, int j) {
		
		if(i==0 && j==0) {
			System.out.println(s);
			return;
		}
//		System.out.println("loop "+ s);
		if(i>0)
			printBraces(s+"{",i-1,j);
		if(i<j)
			printBraces(s+"}",i,j-1);
//		System.out.println("end "+ s);
	}
	
	public static void main(String[] args) {
		printBraces(2);
	}
}
