package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class Removeduplicates1 {
	//Remove duplicate with cache
	public void removeduplicates(LinkedList L1){
		if(L1.firstlink==null)
			return;
		Set<Link> set = new HashSet<Link>();
		Link link = L1.firstlink;
		Link prev = null;
		while(link!=null){
			if(set.contains(link)){
				prev.next = link.next;
				link = link.next;
			}
			else{
				set.add(link);
				prev = link;
				link = link.next;
			}
		}
		printlists(L1);
	}
	//Remove duplicate without cache
	public void removeduplicates1(LinkedList L1){
		if(L1.firstlink==null)
			return;
		Link link = L1.firstlink;
		while(link!=null){
			Link link1 = link;
			while(link1.next!=null){
				if(link1.next.equals(link)){
					link1.next = link1.next.next;
				}
				else{
					link1 = link1.next;
				}
				}
			link = link.next;
		}
		printlists(L1);
	}
	
	public void printlists(LinkedList L1){
		Link link1 = L1.firstlink;
		while(link1!=null){
			link1.display();
			link1 = link1.next;
		}
	}
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(); 
		linkedList.insertlink("book1",10);
		linkedList.insertlink("book1",10);
		linkedList.insertlink("book2",20);
		linkedList.insertlink("book3",10);
		linkedList.insertlink("book4",20);
		linkedList.insertlink("book2",20);
		Removeduplicates1 r = new Removeduplicates1();
		r.removeduplicates1(linkedList);
	}
}
