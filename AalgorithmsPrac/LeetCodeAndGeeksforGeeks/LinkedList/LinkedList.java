package LinkedList;

public class LinkedList {
Link firstlink;
	LinkedList()
	{
		firstlink = null;
	}

	public boolean isEmpty()
	{
		return (firstlink==null);
	}
	
	public void insert(int id)
	{
		Link newlink = new Link(id);
		newlink.next = firstlink;
		firstlink = newlink;
	}
	
	public boolean delete(int id)
	{
		Link delete = new Link(id);
		
		if(firstlink == delete)
		{
			firstlink = firstlink.next;
			return true;
		}
		Link link = firstlink.next;
		Link prev = firstlink;
		while(link!=null){
			if(link.equals(delete)){
				prev.next = link.next;
				return true;
			}
			prev = link;
			link = link.next;
		}
		return false;
	}
	
	
	public void printlist(){
		Link link = firstlink;
		while(link!=null){
			System.out.println(link.id);
			link = link.next;
		}
	}
	
	public Link createLinkedList(int[] arr) {
		this.firstlink = new Link(arr[0]);
		Link n = firstlink;
		for(int i = 1; i < arr.length; i++) {
			n.next = new Link(arr[i]);
			n = n.next;
		}
		return this.firstlink;
	}

	

	public static void main(String[] args) {
		LinkedList L = new LinkedList();

		
	}
	
	
	
}