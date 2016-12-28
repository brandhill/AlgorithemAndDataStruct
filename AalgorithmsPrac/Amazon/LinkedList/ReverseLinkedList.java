package LinkedList;

import java.util.List;

public class ReverseLinkedList {
	
	static void ReverseWithTwoPointers(Node root) {
		
	}
	
	static Node ReverseWithThreePointers(Node root) {
		
		Node p1 = root;
		Node p2 = p1.next;
		p1.next = null;
		Node temp = null;
		while(p2!=null) {
			temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		LinkedLists l = new LinkedLists();
		l.addStart(4);
		l.addStart(1);
		l.addStart(5);
		l.addStart(3);
		l.addStart(2);
		l.printList();
		l.root = ReverseLinkedList.ReverseWithThreePointers(l.root);
		l.printList();
	}
}
