package hackerrank.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		String[] strs = new String[loop];
		for ( int k = 0; k < loop; k++) { 
			strs[k] = sc.next();
		}
		
		for ( int k = 0; k < loop; k++) {
		String str  = strs[k];
		if(str.length()%2!=0) {
			System.out.println("-1");
		}
		else {
			char[] str1 = str.substring(0,str.length()/2).toCharArray();
			char[] str2 = str.substring(str.length()/2).toCharArray();
			Arrays.sort(str1);
			Arrays.sort(str2);
			int count = 0;
			int i = 0;
			int j = 0;
			while (i < str1.length && j < str1.length) {
				if(str1[i]!=str2[j]) {
					if(str1[i]>str2[j]) {
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
			System.out.println(str1.length-count);
		}
	}
	}
}
