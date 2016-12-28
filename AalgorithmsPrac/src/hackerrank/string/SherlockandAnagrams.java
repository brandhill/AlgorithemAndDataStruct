package hackerrank.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class SherlockandAnagrams {
	
	public static int findAnagrams(String s){
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for ( int i = 0; i < s.length(); i++) {
			int len = 1;
			while(i+len <= s.length()) {
				String s1 = sortString(s.substring(i, i+len));
				if(!map.containsKey(s1)) {
					map.put(s1, 1);
				}
				else {
					map.put(s1, map.get(s1)+1);
				}
				len++;
			}
		}
		int count = 0;
		Iterator<Integer> it = map.values().iterator();
		//System.out.println(map.size());
		while(it.hasNext()) {
			int i = it.next();
			//System.out.println(i);
			if(i>1){
				count +=  (i*(i-1))/2;
				//count++;
			}
		}
		//System.out.println("---");
		return count;
	}
	
	private static  String sortString(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return String.valueOf(c);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = Integer.valueOf(in.nextLine());
		//in.next();
		List<String> list = new ArrayList<String>();
		for( int i = 0; i < count; i++) {
			list.add(in.nextLine());
		}
		for( int i = 0; i < count; i++) {
			System.out.println(SherlockandAnagrams.findAnagrams(list.get(i)));
		}
	}
}
