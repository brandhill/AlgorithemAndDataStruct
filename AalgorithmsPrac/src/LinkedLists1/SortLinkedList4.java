package LinkedLists1;

public class SortLinkedList4 {
	
	static Link sortList(Link link, int k) {
		Link less = null;
		Link lesslast = null;
		Link greater = null;
		Link middle = null;
		Link middleLast = null;
		while (link != null) {
			Link pointer = link;
			link = link.next;
			if(pointer.id < k ) {
				if(less == null) {
					lesslast = pointer;
				}
				pointer.next = less;
				less = pointer;
			}
			else if (pointer.id > k) {
				pointer.next = greater;
				greater = pointer;
			}
			else {
				if(middleLast == null) {
					middleLast = pointer;
				}
				pointer.next = middle;
				middle = pointer;
			}
		}
		lesslast.next = middle;
		middleLast.next = greater;
		
		return less;
	}
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(2);
		list.insert(6);
		list.insert(5);
		list.insert(3);
		list.insert(2);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(4);
		list.firstlink = SortLinkedList4.sortList(list.firstlink, 6);
		list.printlist();
		/*while (L!=null) {
			System.out.println(L.id);
			L = L.next;
		}*/
	}
}
