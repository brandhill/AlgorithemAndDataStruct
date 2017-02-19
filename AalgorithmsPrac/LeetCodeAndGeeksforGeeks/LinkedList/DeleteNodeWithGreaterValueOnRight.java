package LinkedList;

import java.util.Stack;

// http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/

// Time - O(n)
// Space  O(n)
public class DeleteNodeWithGreaterValueOnRight {
	
	public static Link deleteNode(Link node) {
		
		Stack<Link> stack = new Stack<Link>();
		
		while(node!=null) {
			stack.add(node);
			node = node.next;
		}
		int max = Integer.MIN_VALUE;
		Link current = null;
		Link next = null;
		while(!stack.isEmpty()) {
			current = stack.pop();
			if(current.id>max) {
				max = current.id;
				current.next = next;
				next = current;
			}
		}
		
		return next;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.insert(3);
		list1.insert(2);
		list1.insert(6);
		list1.insert(5);
		list1.insert(11);
		list1.insert(10);
		list1.insert(15);
		list1.insert(12);
		LinkedList list2 = new LinkedList();
		list2.insert(40);
		list2.insert(30);
		list2.insert(20);
		list2.insert(10);
		Link node = DeleteNodeWithGreaterValueOnRight.deleteNode(list2.firstlink);
		while(node!=null) {
			System.out.print(node.id+" ");
			node = node.next;
		}
	}
}
