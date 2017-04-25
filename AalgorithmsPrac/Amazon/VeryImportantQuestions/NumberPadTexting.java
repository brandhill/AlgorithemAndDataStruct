package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import StandardAlgorithems.TrieDataStruture;
import StandardAlgorithems.TrieDataStruture.Trie;


//Write a function which, given a digit string like "222", returns a list of all possible words which start
//with those letters.
//The sequence 43556 produces the word 'hello'.
//The sequence 227 produces the words car, cap, bar, etc.

public class NumberPadTexting {
	
	class Trie {
		Map<Character,Trie> map = new ConcurrentHashMap<Character,Trie>();
		boolean end;
	}
	
	Trie root;
	
	Map<Integer,List<Character>> pad = new HashMap<Integer,List<Character>>();
	
	NumberPadTexting() {
		root = null;
		char text = 'a';
		for(int i=2; i<=9; i++) {
			int len = 3;
			if(i==7||i==9) {
				len = 4;
			}
			int j=0;
			List<Character> chars = new ArrayList<Character>();
			while(j<len) {
				chars.add(text);
				text =(char) (text + 1);
				j++;
			}
			pad.put(i,chars);
		}
		System.out.println("------");
	}
	
	List<String> findStrings(String number) {
		System.out.println("Called");
		List<List<Character>> list = new ArrayList<List<Character>>();
		for(int i=0; i<number.length(); i++) {
			Integer num = Integer.valueOf(number.charAt(i)-'0');
			System.out.println(num);
			list.add(pad.get(num));
		}
		System.out.println(list);
		List<String> output = new ArrayList<String>();
		
		findStringsHelper(list, "", root, 0, output);
		return output;
	}
	
	void findStringsHelper(List<List<Character>> list,String s, Trie trie, int listIndex, List<String> output) {
		if(s.length()==list.size()) {
			searchSuggestions(s, trie, output);
			return;
		}
		for(int i=0; i< list.get(listIndex).size(); i++) {
			char c = list.get(listIndex).get(i);
			System.out.println(listIndex+" "+c);
			if(trie.map.containsKey(c)) {
				findStringsHelper(list,s+c,trie.map.get(c),listIndex+1, output);
			}
		}
	}
	
	void searchSuggestions(String s, Trie trie, List<String> output) {
		if(trie.end)
			output.add(s);
		for(char c: trie.map.keySet()) {
			searchSuggestions(s+c, trie.map.get(c), output);
		}
	}
	
	void insertWord(String word) {
		char[] input = word.toCharArray();
		if(root==null) {
			root = new Trie();
		}
		Trie current = root;
		for(int i = 0; i < input.length; i++) {
			char c = input[i];
			if(!current.map.containsKey(c)) {
				Trie next = new Trie();
				current.map.put(c, next);
				current = next;
			} else {
			current = current.map.get(c);
			}
		}
		current.end = true;
	}
	
	public static void main(String[] args) {

		
		NumberPadTexting trie = new NumberPadTexting();
//		trie.insertWord("cloth");
//		trie.insertWord("clone");
//		trie.insertWord("cloud");
//		trie.insertWord("bat");
//		trie.insertWord("ball");
		trie.insertWord("car");
		trie.insertWord("cap");
		trie.insertWord("bar");
		trie.insertWord("bartender");
		trie.insertWord("carpool");
		trie.insertWord("captain");
		System.out.println("Started");
		System.out.println(trie.findStrings("227"));
		System.out.println("Ended");
		
	}
}
