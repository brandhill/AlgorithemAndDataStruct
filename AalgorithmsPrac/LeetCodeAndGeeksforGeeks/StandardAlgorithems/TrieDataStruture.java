package StandardAlgorithems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Used for auto complete and word search

public class TrieDataStruture {
	
	class Trie {
		Map<Character,Trie> map = new ConcurrentHashMap<Character,Trie>();
		boolean end;
	}
	
	Trie root;
	
	TrieDataStruture() {
		root = null;
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
	
	boolean SearchWord(String word) {
		char[] input = word.toCharArray();
		if(root==null)
			return false;
		Trie current = root;
		for(int i=0; i < input.length; i++) {
			char c = input[i];
			if(current.map.containsKey(c)) {
				current = current.map.get(c);
			} else {
				return false;
			}
		}
		return current.end;
	}
	
	List<String> WordSuggestions(String prefix) {
		char[] input = prefix.toCharArray();
		if(root==null)
			return null;
		List<String> suggestions = new ArrayList<String>();
		Trie current = root;
		for(int i=0; i < input.length; i++) {
			char c = input[i];
			if(current.map.containsKey(c)) {
				current = current.map.get(c);
			} else {
				return null;
			}
		}
		
		if(current.end)
			suggestions.add(prefix);
		WordSuggestionsHelper(suggestions, current.map, prefix);
		return suggestions;
	}
	
	private void WordSuggestionsHelper(List<String> suggestions, Map<Character, Trie> map,String prefix) {
		
		for(Character c: map.keySet()) {
			Trie node = map.get(c);
			if(node.end) {
				suggestions.add(prefix+c);
			}
			WordSuggestionsHelper(suggestions,node.map,prefix+c);
		}
		
	}
	
	void deleteWord(String word) {
		char[] input = word.toCharArray();
		if(root==null)
			return;
		deleteWordHelper(input,0,root);
	}
	
	private boolean deleteWordHelper(char[] input, int index, Trie node) {
		if(index==input.length) {
			if(!node.end)
				return false;
			node.end = false;
			return node.map.size()==0;
		}
		Trie current = node.map.get(input[index]);
		if(current==null)
			return false;
		boolean shouldDeleteWord = deleteWordHelper(input,index+1,current);
		if(shouldDeleteWord) {
			node.map.remove(input[index]);
			return node.map.size()==0;
		}
		return false;
	}
	
	void deleteAllStartingWith(String prefix) {
		char[] input = prefix.toCharArray();
		if(root==null)
			return;
		List<String> suggestions = new ArrayList<String>();
		Trie current = root;
		Trie prev = null;
		for(int i=0; i < input.length; i++) {
			char c = input[i];
			if(current.map.containsKey(c)) {
				if(i==input.length-1)
					prev = current;
				current = current.map.get(c);
			} else {
				return;
			}
		}
		deleteAllStartingWith(current);
	}
	
	private boolean deleteAllStartingWith(Trie current) {
		current.end = false;
		for(Character c: current.map.keySet()) {
			boolean delete = deleteAllStartingWith(current.map.get(c));
			if(delete) {
				current.map.remove(c);
			}
		}
		return current.map.size()==0;
	}
	
	public static void main(String[] args) {
		TrieDataStruture trie = new TrieDataStruture();
		trie.insertWord("cloth");
		trie.insertWord("clone");
		trie.insertWord("cloud");
		trie.insertWord("bat");
		trie.insertWord("ball");
		System.out.println(trie.SearchWord("cloth"));
		System.out.println(trie.WordSuggestions("clo"));
//		trie.deleteWord("cloth");
//		System.out.println(trie.WordSuggestions("clo"));
		trie.deleteAllStartingWith("cloth");
		System.out.println(trie.WordSuggestions("clo"));

	}
}
