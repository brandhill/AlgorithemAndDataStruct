package DynamicProgramming;

import GraphsDataStructures.mainclass;

public class Fibonicnumber {
	 //0,1,2,3,4 ... 14
	 //0,1,1,2,3
	static int[] fib = new int[100];
	static int NthFinbonic(int n) {
		if(n==0)
			return 0;
		if(n==1) {
			fib[n] = 1;
			return 1;
		}
		if(fib[n]!=0)
			return fib[n];
		System.out.println("Step 1 "+n+" "+fib[n-1]);
		fib[n] = NthFinbonic(n-1) + NthFinbonic(n-2);
				//1 + 1;
			// fib[3] = 2;
		System.out.println("Step 2 "+n+" "+fib[n]);
		return fib[n];
	}
	
	public static void main(String[] args) {
		System.out.println(Fibonicnumber.NthFinbonic(15));
	}
}
