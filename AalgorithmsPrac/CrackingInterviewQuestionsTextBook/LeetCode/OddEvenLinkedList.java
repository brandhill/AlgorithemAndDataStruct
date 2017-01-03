package LeetCode;

public class OddEvenLinkedList {

public ListNode oddEvenList(ListNode head) {
	if (head==null)
		return null;
	ListNode root = head;
	ListNode node = head.next;
	ListNode node1 = node;
	while(head.next!=null && node.next !=null){
		head.next = node.next;
		head = head.next;
		node.next = head.next;
		node = node.next;
	}
		head.next = node1;
	
	return root;
        
    }

	public static void main(String[] args) {
		
	}
}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
}