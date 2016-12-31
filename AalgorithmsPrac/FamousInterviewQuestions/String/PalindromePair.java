package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePair {
	public List<List<Integer>> palindromePairs(String[] words) {
		if(words.length<=1) {
			return null;
		}
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i = 0; i < words.length; i++) { 
			map.put(words[i], i);
		}
		
		for(int i = 0; i < words.length; i++) {
			for(int j = 0; j < words[i].length(); j++ ) {
				String s1 = words[i].substring(0, j+1);
				String s2 = words[i].substring(j+1,words[i].length());
				if(isPalidrome(s2.toCharArray())) {
					String revS1 = new StringBuilder(s1).reverse().toString();
					if(map.get(revS1)!=null) {
						addList(i,map.get(revS1),list);
					}
				}
				if(isPalidrome(s1.toCharArray())) {
					String revS2 = new StringBuilder(s2).reverse().toString();
					if(map.get(revS2)!=null) {
						addList(map.get(revS2),i,list);
						if(revS2.equals(""))
							addList(i,map.get(revS2),list);
					}
				}
					
			}
		}
		
		return list;
	}
	
	private void addList(int a,int b, List<List<Integer>> list) {
		if(a==b)
			return;
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(a);
		list2.add(b);
		list.add(list2);
	}
	
	private boolean isPalidrome(char[] chars) {
		int i = 0;
		int j = chars.length-1;
		while(i<j) {
			if(chars[i]!=chars[j])
				return false;
			i++;
			j--;
		}
		return true;
	}
	


    public static void main(String args[]) {
        PalindromePair palindromePair = new PalindromePair();
        String[] words = {"bat", "tab"};
        List<List<Integer>> result = palindromePair.palindromePairs(words);
        System.out.println(result);
        String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
        result = palindromePair.palindromePairs(words1);
        System.out.println(result);
        String[] words2 = {"", "abcd", "abba"};
        result = palindromePair.palindromePairs(words2);
        System.out.println(result);
        String[] words3 = {"a","abc","aba",""};
        result = palindromePair.palindromePairs(words3);
        System.out.println(result);
        String[] words4 = {"abcd","dcba","lls","s","sssll"};
        result = palindromePair.palindromePairs(words4);
        System.out.println(result);
        String[] words5 = {"a",""};
        result = palindromePair.palindromePairs(words5);
        System.out.println(result);
    }
	
}
