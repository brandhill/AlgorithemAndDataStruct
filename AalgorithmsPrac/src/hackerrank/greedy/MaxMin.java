package hackerrank.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxMin {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    int k = input.nextInt();
	    List<Integer> list = new ArrayList<Integer>();
	    for(int i = 0; i < n; i++) {
	    	list.add(input.nextInt());
	    }
	    Collections.sort(list);
	    int value = Integer.MAX_VALUE;
	    for(int i = 0; i+k-1 < n; i++) {
	    	int num1 = list.get(i);
	    	int num2 = list.get(i+k-1);
	    	value = Math.min(value, num2-num1);
	    }
	    System.out.println(value);
	}
}
