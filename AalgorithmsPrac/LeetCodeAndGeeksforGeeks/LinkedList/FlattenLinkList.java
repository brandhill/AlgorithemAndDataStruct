package LinkedList;

import java.util.Queue;
import java.util.LinkedList;

// http://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/

// Time - O(n)
// Space - O(n) - if we have only childs and no next
public class FlattenLinkList {
	
	public static Link flatten(Link1 head) {
		if(head==null)
			return null;
		Link link = new Link(head.id);
		Link newHead = link;
		Queue<Link1> queue = new LinkedList<Link1>();
		queue.add(head);
		while(!queue.isEmpty()) {
			Link1 n = queue.poll();
			while(n!=null) {
				if(n.child!=null)
					queue.add(n.child);
				link.next = new Link(n.id);
				link = link.next;
				n = n.next;
			}
		}
		return newHead.next;
	}
	
	public static void main(String[] args) {
		LinkedList1 head1 = new LinkedList1();
		LinkedList1 head2 = new LinkedList1();
		LinkedList1 head3 = new LinkedList1();
		LinkedList1 head4 = new LinkedList1();
		LinkedList1 head5 = new LinkedList1();
		LinkedList1 head6 = new LinkedList1();
		LinkedList1 head7 = new LinkedList1();
		LinkedList1 head8 = new LinkedList1();
		int arr1[] = new int[]{10, 5, 12, 7, 11};
        int arr2[] = new int[]{4, 20, 13};
        int arr3[] = new int[]{17, 6};
        int arr4[] = new int[]{9, 8};
        int arr5[] = new int[]{19, 15};
        int arr6[] = new int[]{2};
        int arr7[] = new int[]{16};
        int arr8[] = new int[]{3};
        Link1 h1 = head1.createLinkedList(arr1);
        Link1 h2 = head2.createLinkedList(arr2);
        Link1 h3 = head3.createLinkedList(arr3);
        Link1 h4 = head4.createLinkedList(arr4);
        Link1 h5 = head5.createLinkedList(arr5);
        Link1 h6 = head6.createLinkedList(arr6);
        Link1 h7 = head7.createLinkedList(arr7);
        Link1 h8 = head8.createLinkedList(arr8);
        h1.child = h2;
        h1.next.next.next.child = h3;
        h3.child = h4;
        h4.child = h5;
        h2.next.child = h6;
        h2.next.next.child = h7;
        h7.child = h8;
        Link node = FlattenLinkList.flatten(h1);
        while(node!=null) {
        	System.out.print(node.id+" ");
        	node = node.next;
        }
	}
}

class Link1 {
	int id;
	Link1 next;
	Link1 child;
	Link1(int id) {
		this.id = id;
	}
}

class LinkedList1 {
	Link1 firstlink;
	LinkedList1() {
		firstlink = null;
	}
	
	public Link1 createLinkedList(int[] arr) {
		this.firstlink = new Link1(arr[0]);
		Link1 n = firstlink;
		for(int i = 1; i < arr.length; i++) {
			n.next = new Link1(arr[i]);
			n = n.next;
		}
		return this.firstlink;
	}
}