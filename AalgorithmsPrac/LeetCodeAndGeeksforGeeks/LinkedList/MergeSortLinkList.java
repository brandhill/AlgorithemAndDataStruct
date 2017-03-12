package LinkedList;

import LinkedList.LinkedList;
// http://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
public class MergeSortLinkList {
	
	public static Link MergeSort(Link node) {
		if(node == null || node.next == null)
			return node;
		Link right = SplitList(node);
		node = MergeSort(node);
		right = MergeSort(right);
		return MergeSortHelper(node,right);
	}
	
	public static Link MergeSortHelper(Link left, Link right) {
		if(left == null)
			return right;
		if(right==null)
			return left;
		System.out.println(left.id+" "+ right.id);
		if(left.id <= right.id) {
			left.next = MergeSortHelper(left.next,right);
			return left;
		}
		else {
			right.next = MergeSortHelper(left, right.next);
			return right;
		}
	}
	
	public static Link SplitList(Link node) {
		Link slow = node;
		Link fast = node;
		Link prev = null;
		while(fast!=null && fast.next!=null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if(prev!=null)
			prev.next = null;
		
		return slow;
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
		Link n = MergeSortLinkList.MergeSort(list.firstlink);
		while(n!=null) {
			System.out.print(n.id+" ");
			n = n.next;
		}
	}
}
