package VeryImportantQuestions;

public class HashTable<K,V> {
	private Node<K,V>[] list;
	private int capacity;
	private int size;
	
	
	
	public HashTable(int capacity) {
		list = new Node[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	private class Node<K,V> {
		public K key;
		public V value;
		public Node next;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	void put(K key, V value) {
		
		if(key==null)
			return;
		int index = hashFunction(key);
		Node n = list[index];
		if(n==null) {
			list[index] = new Node(key, value);
			size++;
			return;
		}
		Node prev = null;
		while(n!=null) {
			if(n.key.equals(key)) {
				n.value = value;
				return;
			}
			prev = n;
			n = n.next;
		}
		
		prev.next = new Node(key,value);
		size++;
	}
	
	int hashFunction(K key) {
		int index = (31*key.hashCode())%capacity;
//		System.out.println(index);
		return index;
	}
	
	V get(K key) {
		
		if(key==null)
			return null;
		
		int index = hashFunction(key);
		
		Node n = list[index];
		while(n!=null) {
			if(n.key.equals(key)) {
				return (V) n.value;
			}
			n = n.next;
		}
		
		return null;
	}
	
	void remove(K key) {
		
		if(key==null)
			return;
		int index = hashFunction(key);
		Node n = list[index];
		Node prev = null;
		while(n!=null) {
			if(n.key.equals(key)) {
				if(prev==null) {
					list[index] = null;
				}
				else {
					prev.next = n.next;
				}
				size--;
				return;
			}
			prev = n;
			n = n.next;
		}
		
	}
	
	boolean containsKey(K key) {
		if(key==null)
			return false;
		int index = hashFunction(key);
		Node n = list[index];
		while(n!=null) {
			if(n.key.equals(key)) {
				return true;
			}
			n = n.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		HashTable<Integer,Integer> table = new HashTable<Integer,Integer>(10);
		table.put(null, 1);
		table.put(2, 2);
		table.put(3, 3);
		table.put(11, 11);
		System.out.println(table.get(1));
		System.out.println(table.get(2));
		System.out.println(table.get(3));
		System.out.println(table.containsKey(3));
		table.remove(3);
		System.out.println(table.containsKey(3));
	}
}
