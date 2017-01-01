package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/

// Time - O(n)
// Space - O(n)

public class RearrangeDuplicateCharKDistanceAway {
	
	static String reArrangeString(char[] s,int k) {
		// s - n
		char[] output = new char[s.length];
		Arrays.fill(output,'/');
		// s - n
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < s.length; i++) {
			char c = s[i];
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		int maxGap = (s.length)/k;
		if(s.length%2!=0)
			maxGap++;
		// s - n
		List<List<Character>> list = new ArrayList<List<Character>>(maxGap);
		// t - n
		for(int i = 0; i < maxGap; i++) {
			List<Character> list1 = new  ArrayList<Character>(map.size());
			list.add(list1);
		}
		// t - n
		for(Character c: map.keySet()) {
			int i = map.get(c);
			if(i>maxGap) {
				//System.out.println(i+" "+maxGap);
				return null;
			}
			else {
					list.get(i-1).add(c);
			}
		}
		int index = 0;
		// t - n
		for(int i = maxGap; i>=1; i--) {
			List<Character> list1 = list.get(i-1);
			if(list1.isEmpty())
				continue;
			else {
				for(Character c:list1) {
					if(!fillArray(index, output, c, k,i))
						return null;
					//System.out.println(String.valueOf(output));
					index++;
				}
			}
		}
		
		//System.out.println(output.toString());
		
		return String.valueOf(output);
	}
	
	private static boolean fillArray(int index,char[] output,char c,int k,int count) {
		
		while(count!=0) {
			if(index>output.length-1)
				return false;
			if(output[index]=='/') {
				output[index] = c;
				index +=k;
				count--;
			}
			else {
				index++;
			}
		} 
		
		return true;
	}
	
	public static void main(String[] args) {
		//String s = "geeksforgeeks"; //k = 3
		//String s = "aacbbc"; // k = 3
		//String s = "abb"; // k = 2
		//String s = "aaa"; // k = 2
		String s = "ABBACCCAD"; // k = 3
		
		String s1 = RearrangeDuplicateCharKDistanceAway.reArrangeString(s.toCharArray(), 3);
		if(s1==null)
			System.out.println("Cannot be rearranged");
		else
			System.out.println(s1);
	}
}

// esgesgekrekfo
// egkegkesfesor