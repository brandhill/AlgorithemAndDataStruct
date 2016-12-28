package hackerrank.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Candies {
	
	static int countCandies(int[] ch) {
		int sum = 0;
		int count = 0;
		int prev = 0;
		int[] c = new int[ch.length];
		for(int i = 0; i < ch.length-1;) {
			/*if(i==0 && ch[i]<=ch[i+1]) {
				System.out.println(sum);
				sum += 1;
				i++;
			}*/
			while(i < ch.length-1 && ch[i]<ch[i+1]) {
				if(i==0) {
					sum += 1;
				}
				count++;
				i++;
				if(i >= ch.length-1) {
					break;
				}
			}
			if(count>0) {
				sum += ((count+1)*(count+2)/2) -1;
				prev = count+1;
				count = 0;
			}
			while(i < ch.length-1 && ch[i]>=ch[i+1]) {
				if(i==0)
					count++;
				count++;
				i++;
				if(i >= ch.length-1) {
					break;
				}
			}
			if(count>0) {
				sum += ((count)*(count+1)/2);
				if(prev!=0 && prev<=count) {
					sum += count-prev+1;
				}
				count = 0;
				prev = 0;
			}
		}
		
		return sum;
	}
	
	static int countCandies1(int[] ch) {
		int sum = 0;
		int[] c = new int[ch.length];
		Arrays.fill(c, 1);
		
		for(int i=1; i < ch.length;i++) {
			if(ch[i]>ch[i-1]) {
				c[i] = c[i-1]+1;
			}
		}
		for(int i=ch.length-2; i >= 0;i--) {
			if(ch[i]>ch[i+1] && c[i] < c[i+1]+1) {
				c[i] = c[i+1]+1;
			}
		}
		for(int i=0; i < ch.length;i++) {
				sum += c[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		int count =  sc.nextInt();
		int[] children = new int[count];
		for(int i = 0; i < count; i++) {
			children[i] = sc.nextInt();
		}
		int n = Candies.countCandies1(children);
		System.out.println(n);
	}
}
