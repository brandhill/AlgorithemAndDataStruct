package hackerrank.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GreedyFlorist {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    int k = input.nextInt();
	    List<Integer> cost = new ArrayList<Integer>();
	    for(int i = 0; i < n; i++) {
	    	cost.add(input.nextInt());
	    }
	    Collections.sort(cost);
	    int pointer = n-1;
	    int totalCost = 0;
	    int num = 1;
	    while(k<n) {
	    	for (int i = 0; i < k; i++) {
	    		totalCost += num*cost.get(pointer);
	    		pointer--;
	    		n--;
	    	}
	    	num++;
	    }
	    for (int i = 0; i < n; i++) {
    		totalCost += num*(cost.get(i));
    	}
	    System.out.println(totalCost);
	}
}
