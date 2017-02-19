package LinkedList;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?tab=Description

// Time - O(n)
// Space - O(1)

public class DeleteDuplicateNodesFromSortedLinkedList {
	
	public static Link deleteDuplicates(Link head) {
		Link h = head;
		Link current = head;
		Link prev = null;
		while(current!=null) {
			boolean check = false;
			while( current.next!=null && current.id==current.next.id) {
				current.next = current.next.next;
				check = true;
			}
			if(check) {
				if(prev == null) {
					h = current.next;
				}
				else {
					prev.next = current.next;
				}
			}
			else {
				prev = current;
			}
			current = current.next;
		}
		return h;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.insert(5);
		list1.insert(5);
		list1.insert(4);
		list1.insert(3);
		list1.insert(3);
		list1.insert(1);
		list1.insert(0);
		Link n = DeleteDuplicateNodesFromSortedLinkedList.deleteDuplicates(list1.firstlink);
		while(n!=null) {
			System.out.println(n.id);
			n = n.next;
		}
	}
}
