package StandardAlgorithems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
				i++;
				j++;
			}
			else if(j==0) {
				i++;
			} else {
				j = indexs[j-1];
			}
		
			if(j==pattern.length) {
				return i-pattern.length;
			}
		}
		return -1;
	}
	
	
	static List<Integer> findAllPatternsKMP(char[] string, char[] pattern) {
		
		int[] indexs = new int[pattern.length];
		List<Integer> list = new ArrayList<Integer>();
		fillIndexs(indexs,pattern);
		int start = 0;
		int end = 0;
		int j = 0;
		while(end<string.length) {
			System.out.println("Start "+start+", End "+end);
			if(string[end]==pattern[j]) {
				if(j==pattern.length-1) {
					list.add(start);
					j = indexs[j];
					end++;
					start = end - j;
				} 
				else {
					end++;
					j++;
				}
			} else if(j==0) {
				end++;
				start++;
			}	else {
				j = indexs[j-1];
				start = end - j;
			} 
			
		}
		
		return list;
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
		char[] string = "aabaaa".toCharArray();
		char[] pattern = "aaa".toCharArray();
		System.out.println(findAllPatternsKMP(string, pattern));
		char[] string1 = "ababcababcabc".toCharArray();
		char[] pattern1 = "abcab".toCharArray();
		System.out.println(findAllPatternsKMP(string1, pattern1));
		char[] string2 = "aaaaaa".toCharArray();
		char[] pattern2 = "aaaa".toCharArray();
		System.out.println(findAllPatternsKMP(string2, pattern2));
	}
}
