package LinkedList;

import LinkedLists.LinkedList;

public class QuickSortDoubleLinkedList {
	
	static void QuickSort(LinkedLists list, Node start,Node end) {
			if(end==null || start==end || start==end.next) {
				return;
			}
			Node pIndex = partition(list,start,end);
			QuickSort(list,pIndex.next,end);
			/*If this is singlelinked list
			 * Node n = start;
			while(n!=null && n.next!=pIndex) {
				n = n.next;
				QuickSort(list,start,n);
			}*/
			QuickSort(list,start,pIndex.prev);
			
			
	}
	
	static Node partition(LinkedLists list,Node start,Node end) {
		Node pivot = end;
		Node pIndex = start;
		Node n = start;
		while(n!=pivot) {
			if(n.num <= pivot.num) {
				swap(pIndex,n);
				pIndex = pIndex.next;
			}
			n = n.next;
		}
		swap(pivot,pIndex);
		//list.printList();
		return pIndex;
	}
	
	static void swap(Node n,Node m ) {
		int temp = m.num; 
		m.num = n.num;
		n.num = temp;
	}
	public static void main(String[] args) {
		LinkedLists list = new LinkedLists();
		list.addStart(1);
		list.addStart(6);
		list.addStart(3);
		list.addStart(4);
		list.addStart(5);
		list.addStart(2);
		list.printList();
		QuickSortDoubleLinkedList.QuickSort(list,list.root, list.end);
		list.printList();
	}
}
