package LinkedLists1;

import java.util.HashSet;
import java.util.Set;

public class Removeduplicates1 {
	
	
	
	static void removeduplicates(Link link) {
		
		if(link == null)
			return ;
		Set<Link> set = new HashSet<Link>();
		Link prev = null;
		while(link!=null) {
			if(!set.contains(link)) {
				set.add(link);
				prev = link;
			}
			else {
				prev.next = link.next;
			}
			link = link.next;
		}
	}
	
	static void removeduplicateswithoutbuffer(Link link) {
	
		Link point1 = link;
		
		while(point1!=null) {
			Link prev = point1;
			Link point2 = point1.next;
			
			while(point2!=null) {
				if( point1.equals(point2) ) {
					prev.next = point2.next;
				}
				else {
					prev = point2;
				}
				point2 = point2.next;
			}
			
			point1 = point1.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(2);
		list.insert(1);
		list.insert(1);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		//Removeduplicates1.removeduplicates(list.firstlink);
		Removeduplicates1.removeduplicateswithoutbuffer(list.firstlink);
		list.printlist();
	}
}
