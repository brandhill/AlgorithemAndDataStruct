package LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class SortLinkedList4 {

	public LinkedList sortList(List<Link> list,Link L){
		LinkedList L2 = new LinkedList();
		L2.insertlink(L.Bookname, L.millionsold);
		Link pointer = L2.firstlink;
		for(Link link:list){
			if(link.millionsold<L.millionsold){
				link.next = L2.firstlink;
				L2.firstlink = link;
			}
			else{
				pointer.next = link;
				pointer = link;
			}
		}
		return L2;
	}
	
	public LinkedList sortList(LinkedList list,Link L){
		LinkedList L2 = new LinkedList();
		LinkedList L3 = new LinkedList();
		Link pointer = list.firstlink;
		Link endpoint = null;
		while(pointer!=null){
			if(pointer.millionsold<L.millionsold){
				L2.insertlink(pointer.Bookname, pointer.millionsold);
				if(endpoint==null){
					endpoint = L2.firstlink;
				}
			}
			else if(pointer.millionsold>L.millionsold){
				L3.insertlink(pointer.Bookname, pointer.millionsold);
			}
			pointer = pointer.next;
		}
		
		if(endpoint!=null){
			endpoint.next = L;
			L.next = L3.firstlink;
			return L2;
		}
		else{
			L.next = L3.firstlink;
			L3.firstlink = L;
			return L3;
		}
		
	}
	
	public static void main(String[] args) {
		 SortLinkedList4 q4 = new SortLinkedList4();
		/*Link L1 = new Link("book1",40);
		Link L2 = new Link("book2",20);
		Link L3 = new Link("book3",10);
		Link L4 = new Link("book4",50);
		Link L5 = new Link("book5",30);
		List<Link> list = new ArrayList<Link>();
		list.add(L1);
		list.add(L2);
		list.add(L3);
		list.add(L4);
		list.add(L5);
		Link L = new Link("book6",25);
		LinkedList result = q2.sortList(list, L);*/
		//Removeduplicates1 r = new Removeduplicates1();
		//r.printlists(result);
		 
			LinkedList linkedList = new LinkedList(); 
			linkedList.insertlink("book8",5);
			linkedList.insertlink("book1",20);
			linkedList.insertlink("book2",60);
			linkedList.insertlink("book3",40);
			linkedList.insertlink("book4",30);
			linkedList.insertlink("book5",50);
			linkedList.insertlink("book6",10);
			Link L = new Link("book7",30);
			LinkedList L2 = q4.sortList(linkedList, L);
			Removeduplicates1 r = new Removeduplicates1();
			r.printlists(L2);
	}
	
}
