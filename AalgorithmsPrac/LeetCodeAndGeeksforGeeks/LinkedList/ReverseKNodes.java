package LinkedList;

// http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/

// Time - O(n)
// Space - O(1)
public class ReverseKNodes {
	
	public static Link pairWiseReverse(Link node) {
		
		if(node == null || node.next == null)
			return node;
		
		Link first = node;
		Link second = node.next;
		Link n = second;
		Link prev = null;
		while (first!=null && second !=null) {
			Link temp = first;
			first.next = first.next.next;
			second.next = first;
			first = first.next;
			if(prev!=null)
				prev.next = second;
			if(first!=null)
				second = first.next;
			prev = temp;
		}
		
		return n;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(6);
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		Link n = ReverseKNodes.pairWiseReverse(list.firstlink);
		
		while(n!=null) {
			System.out.print(n.id+"->");
			n = n.next;
		}
	}
}
