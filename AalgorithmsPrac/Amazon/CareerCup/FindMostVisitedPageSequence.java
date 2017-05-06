package CareerCup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import javax.swing.plaf.synth.SynthSpinnerUI;

// https://www.careercup.com/question?id=5768545044529152

public class FindMostVisitedPageSequence {
	
	static List<String> findTop3OccuringKSequence(List<List<Character>> user, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(List<Character> page: user) {
			for(int i=0; i<=page.size()-k; i++) {
					String s = convertToString(page,i,i+k);
					if(map.containsKey(s)) {
						map.put(s,map.get(s)+1);
					} else {
						map.put(s,1);
					}
			}
		}
		
		Queue<String> queue = new PriorityQueue<String>();
		
		for(String s: map.keySet()) {
			int count = map.get(s);
			if(queue.size()==k) {
				if(map.get(queue.peek())<count) {
					queue.poll();
					queue.offer(s);
				}
			} else {
				queue.offer(s);
			}
		}
		
		return new ArrayList<String>(queue);
	}
	
	static String convertToString(List<Character> page, int i, int j) {
		StringBuilder s = new StringBuilder("");
		for(int a=i; a<j; a++) {
			s.append(page.get(a)+"->");
		}
		return s.toString();
	}
	
	
	public static void main(String[] args) {
		Map<Integer, String> hashLookUp = new HashMap<Integer, String>();
		List<Character> user1 = new ArrayList<Character>();
		user1.add('a');
		user1.add('b');
		user1.add('c');
		user1.add('d');
		List<Character> user2 = new ArrayList<Character>();
		user2.add('f');
		user2.add('g');
		user2.add('h');
		List<Character> user3 = new ArrayList<Character>();
		user3.add('f');
		user3.add('g');
		user3.add('h');
		List<Character> user4 = new ArrayList<Character>();
		user4.add('c');
		user4.add('d');
		user4.add('f');
		user4.add('g');
		user4.add('h');
		List<Character> user5 = new ArrayList<Character>();
		user5.add('c');
		user5.add('d');
		user5.add('f');
		List<List<Character>> user = new ArrayList<List<Character>>();
		user.add(user1);
		user.add(user2);
		user.add(user3);
		user.add(user4);
		user.add(user5);
		System.out.println(findTop3OccuringKSequence(user,3));
	}
	
}
