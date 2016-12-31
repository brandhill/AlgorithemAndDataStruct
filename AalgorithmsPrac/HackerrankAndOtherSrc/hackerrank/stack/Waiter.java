package hackerrank.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Waiter {
	private static ArrayList<Integer> primes = new ArrayList<>();
	
	static void sortPlates(Stack<Integer> stack,int iter){
		Stack<Integer> B = new Stack<Integer>();
		int prime;
		for ( int i = 0; i < iter; i++) {
			prime = primes.get(i);
			Stack<Integer> A = new Stack<>();
			while(!stack.isEmpty()) {
				int pop = stack.pop();
				if( pop%prime == 0 ) {
					B.push(pop);
				}
				else {
					A.push(pop);
				}
			}
			stack = A;
			while(!B.isEmpty()) {
				B.pop();
				System.out.println(B.pop());
			}
		}
		while(!stack.isEmpty()){
			stack.pop();
			System.out.println(stack.pop());
		}
		
		
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int iter = in.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i < len; i++){
			stack.push(in.nextInt());
        }
	    boolean[] isPrime=new boolean[10000];
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;
        for (int i=2;i<isPrime.length;i++) {
            if(isPrime[i]) {
                for (int j=2;i*j<isPrime.length;j++) {
                    isPrime[i*j]=false;
                }
                primes.add(i);
            }
        }
        Waiter.sortPlates(stack, iter);
	}
}
