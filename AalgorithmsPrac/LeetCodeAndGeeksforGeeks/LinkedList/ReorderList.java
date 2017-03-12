package LinkedList;

import java.util.Stack;

public class ReorderList {
	
	public static void reorderList(Link node) {
		if(node == null)
			return;
		Link start = node;
		Link slow = node;
		Link fast = node;
		Stack<Link> stack = new Stack<Link>();
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast!=null) {
			slow = slow.next;
		}
		while(slow!=null) {
			stack.push(slow);
			slow = slow.next;
		}
		Link next = start.next;
		boolean condition = true;
		while(!stack.isEmpty() || !condition) {
			if(condition) {
				start.next = stack.pop();
				condition = false;
			}
			else {
				condition = true;
				start.next = next;
				next = next.next;
			}
			start = start.next;
		}
		start.next = null;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
//		list.insert(5);
//		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		ReorderList.reorderList(list.firstlink);
		Link n = list.firstlink;
		while(n!=null) {
			System.out.println(n.id);
			n = n.next;
		}
	}
}
