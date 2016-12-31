package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class CirculatList6 {

	Link findroot(LinkedList L){
		if(L.isEmpty())
		return null;
		Set<Link> set = new HashSet<Link>();
		int count = 0;
		Link pointer = L.firstlink;
		while(true){
			count = count+1;
			if(set.contains(pointer)){
				System.out.println(count);
				return pointer;
			}
			else{
				set.add(pointer);
			}
			pointer = pointer.next;
			if(pointer==null)
				return null;
		}
		
	}
	
	Link findroot1(LinkedList L){
		Link slowRunner = L.firstlink;
		Link fastRunner = L.firstlink;
		boolean breakpoint = false;
		int count = 0;
		while(!breakpoint){
			count = count+1;
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if(slowRunner.equals(fastRunner))
			{
				slowRunner = L.firstlink;
				breakpoint = true;
			}
			if(fastRunner==null || fastRunner.next.next==null)
				return null;
		}
		while(breakpoint){
			count = count+1;
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
				if(slowRunner.equals(fastRunner)){
					System.out.println(count);
					return slowRunner;
				}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(); 
		linkedList.insertlink("book8",5);
		linkedList.insertlink("book1",20);
		linkedList.insertlink("book2",60);
		linkedList.insertlink("book4",30);
		linkedList.insertlink("book3",40);
		linkedList.insertlink("book5",50);
		linkedList.insertlink("book6",10);
		linkedList.insertlink("book9",10);
		linkedList.insertlink("book10",10);
		linkedList.insertlink("book11",10);
		linkedList.insertlink("book12",10);
		linkedList.insertlink("book13",10);
		linkedList.insertlink("book14",10);
		linkedList.insertlink("book15",10);
		linkedList.insertlink("book16",10);
		linkedList.insertlink("book17",10);
		linkedList.insertlink("book18",10);
		linkedList.insertlink("book19",10);
		linkedList.insertlink("book20",10);
		linkedList.insertlink("book21",10);
		Link L = linkedList.firstlink;
		Link point = null;
		while(L.next!=null){
			L = L.next;
			if(L.Bookname.equals("book3"))
				point = L;
		}
		L.next = point;
		CirculatList6 q6 = new CirculatList6();
		Link result1 = q6.findroot(linkedList);
		Link result = q6.findroot1(linkedList); 
		result1.display();
		result.display();
		/*Link L1 = linkedList.firstlink;
		int count = 0;
		while(count<2){
			L1.display();
			L1 = L1.next;
			if(L1.Bookname.equals("book3")){
				count++;
			}
		}
		System.out.println("----");
		L1.display();*/
	}
}
