package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import GraphsDataStructures.mainclass;

public class Gemstones {
	
	static int getGemStones(List<String> list,int num) {
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int count = 0;
		for (String s:list) {
			Set<Character> set2 = new HashSet<Character>();
			char[] chars = s.toCharArray();
			for (int i = 0 ; i < chars.length; i++) {
				char c = chars[i];
				if(!set2.contains(c)) {
					set2.add(c);
					if(map.containsKey(c)) {
						map.put(c, map.get(c)+1);
						if(map.get(c)==num)
							count++;
					}
					else
						map.put(c, 1);
				}
			}
			
		}
		
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		List<String> list = new ArrayList<String>();
		for(int i = 0; i< num;i++) {
			list.add(in.next());
		}
		int count = Gemstones.getGemStones(list,num);
		System.out.println(count);
	}
}
