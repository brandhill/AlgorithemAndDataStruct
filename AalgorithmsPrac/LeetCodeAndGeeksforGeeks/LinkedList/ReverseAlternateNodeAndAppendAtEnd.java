package LinkedList;

// http://www.geeksforgeeks.org/given-linked-list-reverse-alternate-nodes-append-end/

// Time - O(n)
// Space - O(1)

public class ReverseAlternateNodeAndAppendAtEnd {
	
	public static Link reverseAndAppend(Link node) {
		if(node == null || node.next == null)
			return node;
		Link send = node;
		Link head = node;
		Link back = node.next;
		node = node.next.next;
		back.next = null;
		boolean check = true;
		while(node!=null) {
			if(check) {
				head.next = node;
				head = head.next;
				check = false;
				node = node.next;
			}
			else {
				Link temp = back;
				back = node;
				node = node.next;
				back.next = temp;
				check = true;
			}
		}
		
		while(back!=null) {
			head.next = back;
			head = head.next;
			back = back.next;
		}
		
		return send;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(6);
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		Link n = ReverseAlternateNodeAndAppendAtEnd.reverseAndAppend(list.firstlink);
		
		while(n!=null) {
			System.out.print(n.id+"->");
			n = n.next;
		}
		System.out.println();
		LinkedList list1 = new LinkedList();
		list1.insert(20);
		list1.insert(18);
		list1.insert(16);
		list1.insert(14);
		list1.insert(12);
		Link n1 = ReverseAlternateNodeAndAppendAtEnd.reverseAndAppend(list1.firstlink);
		
		while(n1!=null) {
			System.out.print(n1.id+"->");
			n1 = n1.next;
		}
	}
}
