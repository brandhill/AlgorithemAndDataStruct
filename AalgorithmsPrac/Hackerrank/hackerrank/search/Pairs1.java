package hackerrank.search;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs1 {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int diff = sc.nextInt();
	    int[] array = new int[n];
	    for ( int i = 0; i < n; i++) { 
	    	array[i] = sc.nextInt();
	    }
    	Arrays.sort(array);
    	int i = 0;
    	int j = 1;
    	int count = 0;
    	while( j < n) {
    		
    		if((array[j] - array[i]) < diff) {
    			j++;
    		}
    		else if((array[j] - array[i]) > diff) {
    			i++;
    		}
    		else {
    			i++;
    			j++;
    			count++;
    		}
    		if(i==j) {
    			j++;
    		}
        }
    	System.out.println(count);
	}
}
