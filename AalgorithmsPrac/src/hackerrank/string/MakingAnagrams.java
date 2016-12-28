package hackerrank.string;

import java.util.Arrays;
import java.util.Scanner;

public class MakingAnagrams {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s1 = sc.next().toCharArray();
		char[] s2 = sc.next().toCharArray();
		Arrays.sort(s1);
		Arrays.sort(s2);
		int count = 0;
		int i = 0;
		int j = 0;
		while ( i < s1.length && j < s2.length) {
			if(s1[i]!=s2[j]) {
				if(s1[i]>s2[j]) {
					j++;
				}
				else {
					i++;
				}
			}
			else {
				count++;
				i++;
				j++;
			}
		}
		count = i-count+j-count+1;
		if(i<s1.length) {
			count += s1.length-1-i;
		}
		else {
			count += s2.length-1-j;
		}
		
		System.out.println(count);
	}
}
