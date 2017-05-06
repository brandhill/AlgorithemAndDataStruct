package CareerCup;

import LinkedLists1.Link;

// https://www.careercup.com/question?id=5107418422837248

public class Add1ToTheLinkedList {
	
	static Link AddOne(Link node) {
		
		Link temp = node.id==9?node:null;
		Link n = node;
		while(n.next!=null) {
			
			if(n.next.id==9) {
				if(temp==null)
					temp = n;
			}
			else {
				temp = null;
			}
			n = n.next;
		}
		if(temp!=null) {
			if(temp.id==9) {
				Link L = new Link(1);
				L.next = temp;
				node = L;
			} else {
				temp.id += 1;
				temp = temp.next;
			}
		}
		
		while(temp!=null && temp.id==9) {
			temp.id = 0;
			temp = temp.next;
		}
		return node;
	}
	
	public static void main(String[] args) {
		Link n1 = new Link(9);
		Link n2 = new Link(9);
		Link n3 = new Link(9);
		Link n4 = new Link(9);
		Link n5 = new Link(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		Link temp = AddOne(n1);
		while(temp!=null) {
			System.out.print(temp.id);
			temp = temp.next;
		}
	}
}
