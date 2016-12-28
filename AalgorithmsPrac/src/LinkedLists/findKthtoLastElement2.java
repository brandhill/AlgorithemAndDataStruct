package LinkedLists;

public class findKthtoLastElement2 {
	LinkedList L1;
	
	public findKthtoLastElement2(){
		this.L1 = new LinkedList();
	}
	
	LinkedList returnListfrom(int begin){
		if(L1.firstlink==null)
			return null;
		int count=0;
		LinkedList L2 = new LinkedList();
		Link link = L1.firstlink;
		while(link!=null){
			if(count>=begin){
				L2.insertlink(link.Bookname, link.millionsold);	
			}
			link = link.next;
			count++;
		}
		return L2;
	}
	
	//Delete node from the linked list
	public void deleteNode(Link L){
		if(L1.firstlink==null)
			return;
		Link link = L1.firstlink;
		if(link.equals(L)){
			L1.firstlink = link.next;
			return;
		}
			 
		while(link.next!=null){
			if(link.next.equals(L)){
				link.next = link.next.next;
				break;
			}
			else{
				link = link.next;
			}
		}
	}
	
	public static void main(String[] args) {
		 findKthtoLastElement2 q2 = new findKthtoLastElement2();
		q2.L1.insertlink("book1",10);
		q2.L1.insertlink("book1",10);
		q2.L1.insertlink("book2",20);
		q2.L1.insertlink("book3",10);
		q2.L1.insertlink("book4",20);
		q2.L1.insertlink("book2",20);
		Link L = new Link("book2",20);
		//LinkedList result = q2.returnListfrom(6);
		Removeduplicates1 r = new Removeduplicates1();
		r.printlists(q2.L1);
		q2.deleteNode(L);
		System.out.println("-------");
		r.printlists(q2.L1);
		q2.deleteNode(L);
		System.out.println("-------");
		r.printlists(q2.L1);
	}
}
