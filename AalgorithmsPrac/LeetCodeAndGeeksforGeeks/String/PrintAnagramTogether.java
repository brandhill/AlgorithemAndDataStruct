package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time - O(n)
// Space - O(n)
public class PrintAnagramTogether {
	public void print(String[] string){
        Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
        
        for(int i = 0; i < string.length; i++) {
        	char[] chars = string[i].toCharArray();
        	Arrays.sort(chars);
        	String s = Arrays.toString(chars);
        	if(map.containsKey(s)) {
        		map.get(s).add(i);
        	}
        	else {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(s, list);
        	}
        }
        
        for(String s: map.keySet()) {
        	for(Integer i:map.get(s)) {
        		System.out.println(string[i]);
        	}
        }
    }
    
    public static void main(String args[]){
        String str[] = {"cat","dog","tac","god","act"};
        PrintAnagramTogether pat = new PrintAnagramTogether();
        pat.print(str);
    }
}
