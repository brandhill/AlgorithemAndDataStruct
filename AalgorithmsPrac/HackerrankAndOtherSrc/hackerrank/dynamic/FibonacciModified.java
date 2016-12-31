package hackerrank.dynamic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

import GraphsDataStructures.mainclass;

public class FibonacciModified {
	static BigInteger FindFibonacci(int n,BigInteger i,BigInteger j) {
		BigInteger[] num = new BigInteger[n];
		Arrays.fill(num, new BigInteger("-1"));
		//System.out.println(num.toString());
		num[0] = i;
		num[1] = j;
		return FindFibonacciHelper(n,num);
	}
	static BigInteger FindFibonacciHelper(int n,BigInteger[] num) {
		if(!num[n-1].equals(new BigInteger("-1"))) {
			return num[n-1];
		}
		BigInteger i1 = FindFibonacciHelper(n-1,num);
		BigInteger i2 = FindFibonacciHelper(n-2,num);
		num[n-1] = (i1.multiply(i1)).add(i2); 
		System.out.println(n+" "+num[n-1]);
		return num[n-1];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger i = in.nextBigInteger();
		BigInteger j = in.nextBigInteger();
		int n = in.nextInt();
		System.out.println(FibonacciModified.FindFibonacci(n, i, j));
	}
}
