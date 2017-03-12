package LinkedList;

import java.util.Stack;

public class ReverseAlternateKNodes {
	
	public static Link reverseAlternateKNodes(Link node, int k) {
		
		if(node==null)
			return null;
		Stack<Link> stack = new Stack<Link>();
		Link temp = null;
		Link head = null;
		int n = k;
		boolean check = true;
		while(node!=null ) {
			if(check) {
				if(n>0) {
					stack.push(node);
					node = node.next;
					n--;
				}
				else {
					if(head == null) {
						Link m = stack.pop();
						head = m;
						temp = head;
					}
					head = emptyStack(stack,head);
					check = false;
				}
			}
			else {
				if(n<k && node!=null) {
					head.next = node;
					node = node.next;
					head = head.next;
					n++;
				}
				else {
					check = true;
				}
				
			}
		}
		
		if(head == null) {
			Link m = stack.pop();
			head = m;
			temp = head;
		}
		head = emptyStack(stack,head);
		head.next = null;
		return temp;
		
	}
	
	private static Link emptyStack(Stack<Link> stack,Link head) {
		while(!stack.isEmpty()) {
			Link m = stack.pop();
			head.next = m;
			head = head.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(2);
		list.insert(6);
		list.insert(5);
		list.insert(3);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(4);
		Link n = ReverseAlternateKNodes.reverseAlternateKNodes(list.firstlink, 3);
		while(n!=null) {
			System.out.println(n.id);
			n = n.next;
		}
	}
}
