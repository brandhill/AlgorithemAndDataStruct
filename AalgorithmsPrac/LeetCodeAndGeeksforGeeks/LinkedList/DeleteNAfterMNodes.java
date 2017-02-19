package LinkedList;
// http://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/

// time - O(n)
// space - O(1)
public class DeleteNAfterMNodes {
	
	static Link deleteNAfterMNodes(int N, int M, Link head) {
		if(head==null)
			return null;
		
		Link current = head;
		while(current!=null) {
			int n = N;
			int m = M-1;
			while(m>0 && current.next!=null) {
				current = current.next;
				m--;
			}
			while(n>0 && current.next!=null) {
				current.next = current.next.next;
				n--;
			}
			current = current.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.insert(10);
		list1.insert(9);
		list1.insert(8);
		list1.insert(7);
		list1.insert(6);
		list1.insert(5);
		list1.insert(4);
		list1.insert(3);
		list1.insert(2);
		list1.insert(1);
		Link node = DeleteNAfterMNodes.deleteNAfterMNodes(1, 1, list1.firstlink);
		while(node!=null) {
			System.out.println(node.id);
			node = node.next;
		}
	}
}
