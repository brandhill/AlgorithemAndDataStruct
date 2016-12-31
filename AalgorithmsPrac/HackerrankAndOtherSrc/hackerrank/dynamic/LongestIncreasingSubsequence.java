package hackerrank.dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LongestIncreasingSubsequence {
	
	static int LongestSubSequence(int[] input) {
		if(input.length<1) {
			return 0;
		}
		List<index> list = new ArrayList<index>();
		int maxLen = 1;
		for (int i = 0; i < input.length; i++) {
			int check = -1;
			int len = 0;
			/*for(int j = 0; j < list.size(); j++) {
				System.out.println(list.get(j).num+" "+list.get(j).len);
			}
			System.out.println("----");*/
			for(int j = 0; j < list.size(); j++) {
					index in = list.get(j);
					if(in.num < input[i] && in.len > len) {
						check = j;
						len = in.len;
					}
			}
			if(check==-1) {
				index in = new index();
				in.num = input[i];
				in.len = 1;
				list.add(in);
			}
			else {
				index n = list.get(check);
				n.num = input[i];
				n.len++;
				if(n.len > maxLen) {
					maxLen = n.len;
				}
			}
			
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = new int[size];
		for( int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		//int[] array =  { 15, 27, 14, 38, 26, 55, 46, 65, 85 };
		//int[] array =  { 5,4,3,2,1 };
		int result = LongestIncreasingSubsequence.LongestSubSequence(array);
		System.out.println(result);
	}
}

class index implements Comparable{
	int num;
	int len;
	@Override
	public int compareTo(Object o) {
		index i = (index) o;
		if(this.len > i.len) {
			return -1;
		}
		else if(this.len < i.len) {
			return 1;
		}
		return 0;
	}
}