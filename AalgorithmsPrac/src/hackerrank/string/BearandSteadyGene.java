package hackerrank.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class BearandSteadyGene {
	
	static int steadyLength(String s) {
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int n = s.length()/4;
		StringBuffer str = new StringBuffer("");
		boolean check  = false;
		for ( int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
				if(map.get(c)>n ) {
					str.append(c);
				}
			}
			else {
				map.put(c, 1);
			}
		}
		Iterator<Character> it = map.keySet().iterator();
		while(it.hasNext()) {
			char c = it.next();
			System.out.println(c+" "+map.get(c));
		}
		System.out.println(str.toString());
		//System.out.println(s);
		char[] chars = str.toString().toCharArray();
		int track = 0;
		int j = 0;
		while(j < s.length()) {
			int index = 0;
			int len = 0;
			if(s.charAt(j)==chars[0]) {
				for(int i = j; i < s.length(); i++) {
					if(len > 0)
						len++;
					if(s.charAt(i)==chars[index]){
						index++;
						if(len == 0)
							len++;
					}
					if(index==chars.length){
						if(track>len || track == 0)
							track = len;
						break;
					}
				}
			}
			if(track==chars.length)
				break;
			j++;
		}
		
		//System.out.println(track);
	
		return track;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		String s = sc.next();
		int i = BearandSteadyGene.steadyLength(s);
		System.out.println(i);
	}
}
