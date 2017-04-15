package VeryImportantQuestions;

import java.util.Arrays;

public class FindFirstOccurenceofPatternInStringKMP {
	
	static int findPattern(char[] string, char[] pattern) {
		if(string.length==0 || pattern.length==0 || string==null || pattern==null) {
			return -1;
		}
		int i = 0;
		int j = 0;
		while(i<string.length) {
			if(string[i]==pattern[j]) {
				int k = i;
				while(k<string.length && j < pattern.length) {
					if(string[k]!=pattern[j]) {
						j = 0;
						break;
					}
					k++;
					j++;
				}
				if(j==pattern.length)
					return i;
			}
			i++;	
		}
		
		return -1;
	}
	
	static int findPatternKMP(char[] string, char[] pattern) {
		if(string.length==0 || pattern.length==0 || string==null || pattern==null) {
			return -1;
		}
		
		int[] indexs = new int[pattern.length];
		fillIndexs(indexs,pattern);
		int i = 0;
		int j = 0;
		int index = -1;
		while(i<string.length) {
//			System.out.println(i+" "+j);
			if(string[i]==pattern[j]) {
				while(i < string.length && j < pattern.length) {
					if(string[i]!=pattern[j]) {
						j = indexs[j-1];
						break;
					}
					i++;
					j++;
				}
				if(j==pattern.length) {
					return i-pattern.length;
				}
			}
			else 
				i++;
		}
		
		return -1;
	}
	
	static void fillIndexs(int[] indexs, char[] pattern) {
		indexs[0] = 0;
		for(int i = 1; i< pattern.length; i++) {
			if(pattern[i] == pattern[indexs[i-1]]) {
				indexs[i] = indexs[i-1]+1;
			}
			else {
				indexs[i] = 0;
			}
		}
		System.out.println(Arrays.toString(indexs));
	}
	
	public static void main(String[] args) {
		char[] string = "abxabcabcaby".toCharArray();
		char[] pattern = "abcabya".toCharArray();
		System.out.println(findPatternKMP(string, pattern));
	}
}
