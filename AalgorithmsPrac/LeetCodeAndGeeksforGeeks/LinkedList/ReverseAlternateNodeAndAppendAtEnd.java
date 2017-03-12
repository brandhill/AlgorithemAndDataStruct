package LinkedList;

public class ReverseAlternateNodeAndAppendAtEnd {
	
	public Link reverseAndAppend(Link node) {
		if(node == null)
			return null;
		Link head = node;
		Link next = node.next;
		boolean check = true;
		while (head!=null && next!=null && next.next !=null) {
			head.next = next.next;
			head = head.next;
			head.next = next;
			if(check) {
				next.next = null;
				check = false;
			}
			next = next.next.next;
		}
		return node;
	}
}
