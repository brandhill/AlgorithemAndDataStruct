package LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseDoubleLinkedList {
	
	static void ReverseListWithSingleList(LinkedLists List) {
		
		Queue<Node> queue = new LinkedList<Node>();
		Node n = List.root;
		while(n!=null) {
			queue.add(n);
			n = n.next;
		}
		List.root = null;
		while(!queue.isEmpty()) {
			if(List.root == null) {
				List.root = queue.poll();
				List.root.next = null;
			}
			else {
				Node m = queue.poll();
				List.root.prev = m;
				m.next = List.root;
				List.root = m;
			}
		}
		List.root.prev = null;
	}
	
	static void ReverseListWithDoubleList(LinkedLists List) {
		Node m = List.end;
		List.end = List.root;
		List.root = m;
		while(m!=null) {
			Node temp = m.prev;
			m.prev = m.next;
			m.next = temp;
			m = m.next;
		}
		Node a = List.root;
		while(a!=null) {
			System.out.print(a.num+" ");
			a = a.next;
		}
	}
	
	public static void main(String[] args) {
			LinkedLists List = new LinkedLists();
			List.addStart(7);
			List.addStart(6);
			List.addStart(5);
			List.addStart(4);
			List.addStart(3);
			List.addStart(2);
			List.addEnd(1);
			Node n = List.root;
			while(n!=null) {
				System.out.print(n.num+" ");
				n = n.next;
			}
			System.out.println();
			ReverseDoubleLinkedList.ReverseListWithDoubleList(List);
	}
}


class Node {
	int num;
	Node next;
	Node prev;
	
	Node(int num) {
		this.num = num;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (num != other.num)
			return false;
		if (prev == null) {
			if (other.prev != null)
				return false;
		} else if (!prev.equals(other.prev))
			return false;
		return true;
	}
	
	
}

class LinkedLists {
	Node root;
	Node end;
	int len;
	LinkedLists() {
		root = null;
		end = null;
		len = 0;
	}
	
	void printList() {
		Node n = root;
		while(n!=null) {
			System.out.print(n.num+" ");
			n = n.next;
		}
		System.out.println();
	}
	void addStart(int num) {
		len++;
		Node n = new Node(num);
		if(root==null) {
			root = n;
			end = n;
			return;
		}
		root.prev = n;
		n.next = root;
		root = n;
	}
	void addEnd(int num) {
		len++;
		Node n = new Node(num);
		if(root==null) {
			root = n;
			end = n;
			return;
		}
		end.next = n;
		n.prev = end;
		end = n;
	}
}