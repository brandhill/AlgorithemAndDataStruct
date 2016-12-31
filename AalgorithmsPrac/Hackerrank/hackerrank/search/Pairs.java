package hackerrank.search;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pairs {
	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int diff = sc.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        for ( int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int num1 = Math.abs(num-diff);
            int num2 = num+diff;
            int a = 0; 
            int b = 0;
            if(set.contains(num1)) {
            	if(!set.contains(num)) {
            		count++;
            		a++;
            	}
                
            }
            if(num1 != num2 && set.contains(num2)) {
            	if(!set.contains(num)) {
            		count++;
            		b++;
            	}
            }
            if(a==1 && a==b) {
            	System.out.println(num);
            }
            set.add(num);
        }
        
        System.out.println(count);
    }
    
}
