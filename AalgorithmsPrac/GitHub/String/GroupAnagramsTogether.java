package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/anagrams/

// Time - O(n)
// Space - O(n) 
public class GroupAnagramsTogether {
	
	 public List<List<String>> groupAnagrams(String[] strs) { 
		 List<List<String>> output = new ArrayList<List<String>>();
		 if (strs == null || strs.length == 0 ){
			 List<String> list = new ArrayList<String>();
			 output.add(list);
			 return output;
		 }
		 Map<String,List<String>> map = new HashMap<String,List<String>>();
		 for(String s: strs) {
			 char[] chars = s.toCharArray();
			 Arrays.sort(chars);
			 String s1 = String.valueOf(chars);
			 if(map.containsKey(s1)) {
				 map.get(s1).add(s);
			 }
			 else {
				 List<String> list = new ArrayList<String>();
				 list.add(s);
				 map.put(s1, list);
			 }
		 }
		 output.addAll(map.values());
		 return output;
	 }
	 
	 public static void main(String[] args) {
		 GroupAnagramsTogether grp = new GroupAnagramsTogether();
		 String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		 //String[] str = {""};
		 List<List<String>> output = grp.groupAnagrams(str);
		 System.out.println(output);
	}
}
