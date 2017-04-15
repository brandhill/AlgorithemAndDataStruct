package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Write a basic implementation of HashTable

public class ImplementHashTable<K,V> {
	private List<LinkedList<Node>> hashTable;
	
	ImplementHashTable() {
		hashTable = new ArrayList<LinkedList<Node>>();
	}
	
	private class Node {
		public K key;
		public V value;
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		
	}
	
	void put(K key, V value) {
		Node n = new Node(key,value);
		int index = hashFunction(key);
		LinkedList<Node> list = hashTable.get(index);
		
	}
	
	V get(K key) {
		int index = hashFunction(key);
		LinkedList<Node> list = hashTable.get(index);
		if(list==null)
			return null;
		for(Node n: list) {
			if(n.key.equals(key)) {
				return n.value;
			}
		}
		
		return null;
	}
	
	boolean containsKey(K key) {
		int index = hashFunction(key);
		LinkedList<Node> list = hashTable.get(index);
		if(list==null)
			return false;
		for(Node n: list) {
			if(n.key.equals(key)) {
				return true;
			}
		}
		
		return false;

	}
	
	
	int hashFunction(K key) {
		int index = (31*key.hashCode())%hashTable.size();
		return index;
	}
}
