package String;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Given a string, return the longest repeated substring.

public class FindLongestRepeatedSubString {
	static String findLongestRepeatedSubString1(String s) {
		String maxCommon = "";

		int max = Integer.MIN_VALUE;

		List<Integer> stringIndicies = new ArrayList<Integer>(s.length());

		for (int i = 0; i < s.length(); i++) {

			stringIndicies.add(i);

		}

		Collections.sort(stringIndicies, new Comparator<Integer> (){

		@Override

		public int compare(Integer a, Integer b) {

		for (int i = 0; i + a < s.length() && i + b < s.length(); i++) {
			if (s.charAt(i + a) != s.charAt(i + b))
				return (int)s.charAt(i + a) - (int)s.charAt(i + b);
			}
			return 0;
		}

		});
		System.out.println(stringIndicies);
		for (int i = 1; i < s.length(); i++) {
		int com = CompareSubstring(s.toCharArray(), stringIndicies.get(i),
		stringIndicies.get(i - 1));
		if (com > max) {
			max = com;
			maxCommon = s.substring(stringIndicies.get(i),
			stringIndicies.get(i) + max);
		}
		}

		return maxCommon;
	}
	static String findLongestRepeatedSubString(String s) {
		String output = "";
		
		List<Integer> sortIndices = new ArrayList<Integer>();
		char[] chars = s.toCharArray();
		for(int i = 0; i < s.length(); i++) {
			sortIndices.add(i);
		}
		System.out.println(sortIndices);
		Collections.sort(sortIndices, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				if(chars[a]!=chars[b])
					return chars[a] - chars[b];
				return 0;
			}
			
		});

		System.out.println(sortIndices);
		int max = 0;
		for(int i = 0; i < s.length()-1; i++) {
//			System.out.println(i);
			int a = sortIndices.get(i);
			int j = i+1;
			while(j < s.length() && chars[sortIndices.get(j)]==chars[a]) {
				int b = sortIndices.get(j);
				int len = CompareSubstring(chars,a,b);
//				System.out.println(len);
				if(len>max) {
					max = len;
					output = s.substring(a,a+len);
//					System.out.println(output);
				}
				j++;
			}
			
		}
		
		
		return output;
	}
	
	static String withMap(String s) {
		String output = "";
		
		Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.get(c).add(i);
			}
			else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(c, list);
			}
		}
		
		Iterator<Character> it = map.keySet().iterator();
		int max = 0;
		while(it.hasNext()) {
			char c = it.next();
			List<Integer> list = map.get(c);
			System.out.println(c+" "+list);
			for(int i = 0; i < list.size(); i++) {
				int a = list.get(i);
				for(int j = i+1; j < list.size(); j++) {
					int b = list.get(j);
					int len = CompareSubstring(s.toCharArray(),a,b);
					System.out.println(c+" "+len);
					if(len>max) {
						max = len;
						output = s.substring(a, a+len);
					}
				}
			}
			
		}
		
		return output;
	}
	
	static int CompareSubstring(char[] s, int i, int j) {
		int len = 0;
		
		while(i+len < s.length && j+len < s.length && s[i+len]==s[j+len]) {
			len++;
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		String s = "banaana";
		String s1 = "tomato";
		String s2 = "aaaaaa";
		String s3 = "This is my country. my country is great";
		String s4 = "qwerta";
		String output = FindLongestRepeatedSubString.findLongestRepeatedSubString(s);
		System.out.println(output);
		String output1 = FindLongestRepeatedSubString.findLongestRepeatedSubString1(s);
		System.out.println(output1);
	}
}
