package DynamicProgramming;

import GraphsDataStructures.mainclass;

public class Fibonicnumber {
	
	 
	static int[] fib = new int[51];
	static int NthFinbonic(int n) {
		System.out.println(n+" "+fib[n]);
		if(n==0)
			return 0;
		if(n==1) {
			fib[n] = 1;
			return 1;
		}
		if(fib[n]!=0)
			return fib[n];
		fib[n] = NthFinbonic(n-1) + NthFinbonic(n-2);
		//System.out.println(n+" "+fib[n]);
		return fib[n];
	}
	
	public static void main(String[] args) {
		System.out.println(Fibonicnumber.NthFinbonic(15));
	}
}
