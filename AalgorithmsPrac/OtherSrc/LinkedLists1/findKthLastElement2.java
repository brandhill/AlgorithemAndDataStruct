package LinkedLists1;

public class findKthLastElement2 {
	
	static int count = 0;
	static Link finkKthLastElement(Link link,int k) {
		
		if(link == null)
			return null;
		
		Link L = finkKthLastElement(link.next,k);
		count++;
		if(count == k)
			return link;
		
		return L;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(2);
		list.insert(1);
		list.insert(1);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		System.out.println(findKthLastElement2.finkKthLastElement(list.firstlink, 5).id);
	}
}
