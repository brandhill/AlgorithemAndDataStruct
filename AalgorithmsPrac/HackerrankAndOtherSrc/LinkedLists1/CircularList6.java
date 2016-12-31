package LinkedLists1;

import java.util.Stack;

public class CircularList6 {
	
	static Link findLoopStart(Link link) {
		Link Pointer1 = link.next;
		if(Pointer1 == null)
			return null;
		Link Pointer2 = link.next.next;
		if(Pointer2 == null)
			return null;
		
		while(!Pointer1.equals(Pointer2)) {
			Pointer1 = Pointer1.next;
			Pointer2 = Pointer2.next.next;
		}
		Pointer2 = link;
		while(!Pointer1.equals(Pointer2)) {
			Pointer1 = Pointer1.next;
			Pointer2 = Pointer2.next;
		}
		
		return Pointer1;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(2);
		list.insert(1);
		list.insert(6);
		list.insert(7);
		Link L = CircularList6.findLoopStart(list.firstlink);
		System.out.println(L.id);
	}
}
