package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsOfSet {
	
	static Set<Set<Character>> findSubsets(char[] arr) {
		Set<Set<Character>> list = new HashSet<Set<Character>>();
		Set<Character> set = new HashSet<Character>();
		set.add(' ');
		list.add(set);
		for(int i = 0; i < arr.length; i++) {
			Set<Set<Character>> tempList = new HashSet<Set<Character>>();
			for(Set<Character> sets: list) {
				Set<Character> temp = new HashSet<Character>(sets);
				temp.add(arr[i]);
				temp.remove(' ');
				tempList.add(temp);
			}
			list.addAll(tempList);
		}
		System.out.println(list);
		
		return list;
	}
	
	public static void main(String[] args) {
		char[] arr = {'a','b','c','b'};
		findSubsets(arr);
	}
}
