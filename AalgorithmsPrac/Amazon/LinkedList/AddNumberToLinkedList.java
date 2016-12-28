package LinkedList;

import java.util.Stack;

public class AddNumberToLinkedList {
	
	static void AddOne(Node root) {
		
		Stack<Node> stack = new Stack<Node>();
		Node n = root;
		while(n!=null) {
			stack.push(n);
			n = n.next;
		}
		//Node m = stack.pop();
		int val = 1;
		
		while(!stack.isEmpty()) {
			Node m = stack.pop();
			val += m.num;
			m.num = val%10;
			if(val>9) {
				val = val/10;
			}
			else {
				//m.num = val;
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		LinkedLists l = new LinkedLists();
		l.addStart(0);
		l.addStart(1);
		l.addStart(1);
		l.addStart(2);
		l.printList();
		AddNumberToLinkedList.AddOne(l.root);
		l.printList();
	}
}
