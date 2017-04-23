package StandardAlgorithems;

import java.util.ArrayList;
import java.util.List;

public class FindSubStringSearchRabinKarpAlgorithm {
	
	static List<Integer> findSubStrings(char[] str, char[] pattern) {
		int prime = 31;
		int hashValue = 0;
		for(int i =0; i< pattern.length; i++) {
			hashValue += pattern[i]*Math.pow(prime, i);
		}
		List<Integer> list = new ArrayList<Integer>();
		int start = 0;
		int end = 0;
		int currentHashValue = 0;
		while(end<str.length) {
			if(end-start+1==pattern.length) {
				currentHashValue += str[end]*Math.pow(prime, pattern.length-1);
				if(currentHashValue==hashValue && checkIfEqual(str,start,end,pattern)) {
					list.add(start);
				}
				currentHashValue -= str[start];
				currentHashValue /= prime;
				start++;
			} else 
				currentHashValue += str[end]*Math.pow(prime, end);
			end++;
		}
		return list;
	}

	private static boolean checkIfEqual(char[] str, int start, int end, char[] pattern) {
		String s = String.valueOf(str).substring(start, end+1);
		System.out.println(s);
		System.out.println(String.valueOf(pattern));
		return s.equals(String.valueOf(pattern));
	}
	
	public static void main(String[] args) {
		char[] string = "aabaaa".toCharArray();
		char[] pattern = "aaa".toCharArray();
		System.out.println(findSubStrings(string, pattern));
		char[] string1 = "ababcababcabc".toCharArray();
		char[] pattern1 = "abcab".toCharArray();
		System.out.println(findSubStrings(string1, pattern1));
		char[] string2 = "aaaaaa".toCharArray();
		char[] pattern2 = "aaaa".toCharArray();
		System.out.println(findSubStrings(string2, pattern2));
	}
	
}
