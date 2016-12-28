package LinkedList;


public class MergeSortedList {
	
	static Node MergeListsWithOutThirdList(Node n1,Node n2) {
		
		Node prev = null;
		Node pointer = n1;
		while(n2!=null && n1!=null) {
			if(n1.num >= n2.num) {
				Node n = n2;
				n2 = n2.next;
				if(prev == null) {
					prev = n;
					pointer = n;
				}
				else {
					prev.next = n;
					prev = n;
				}
				n.next = n1;
			}
			else {
				prev = n1;
				n1 = n1.next;
			}
		}
		
		while(n2!=null) {
			prev.next = n2;
			prev = n2;
			n2 = n2.next;
		}
		
		return pointer;
		
	}
	
	public static void main(String[] args) {
		LinkedLists List = new LinkedLists();
		List.addStart(6);
		List.addStart(3);
		List.addStart(2);
		List.addStart(1);
		List.printList();
		LinkedLists List1 = new LinkedLists();
		List1.addStart(8);
		List1.addStart(5);
		List1.addStart(4);
		List1.addStart(3);
		List1.addStart(0);
		List1.printList();
		List.root = MergeSortedList.MergeListsWithOutThirdList(List.root, List1.root);
		List.printList();
	}
}
