package LinkedLists;

public class LinkedList {
Link firstlink;
	public LinkedList()
	{
		firstlink = null;
	}

	public boolean isEmpty()
	{
		return (firstlink==null);
	}
	public void insertlink(String bookname,int millionsold)
	{
		Link newlink = new Link(bookname,millionsold);
		newlink.next = firstlink;
		firstlink = newlink;
	}
	public Link removeLastestLink()
	{
		Link refLink = firstlink;
		if(!isEmpty())
		firstlink = firstlink.next;
		
		return refLink;	
	}
	public int cycleLink(String bookname){
		Link search = firstlink;
		int count = 0;
		while (search != null) {
			count++;
			System.out.println(count);
			if (search.Bookname.equalsIgnoreCase(bookname)) {
				return search.millionsold;
			}
			search = search.next;
		}
		System.out.println("No match found");
		return -1;
	}
	public void removealist(String bookname){
		Link search = firstlink;
		Link prev = null;
		while (search != null) {
			if (search.Bookname.equalsIgnoreCase(bookname)) {
				prev.next = search.next;
			}
			prev = search;
			search = search.next;
		}
			
	}
LinkedList reverse() {
	LinkedList revLL = new LinkedList();
	Link temp = firstlink;
	while(temp!=null)
	{
	Link next = temp.next;
	revLL.insertlink(temp.Bookname, temp.millionsold);
	temp = next;
	}
	return revLL;
	}
	
	//2nd Problem -- find kth to last element in list
void appendList(LinkedList L1){
	Link temp = firstlink;
	while(temp.next!=null){
		temp = temp.next;
	}
	temp.next = L1.firstlink;
}

	public static void main(String[] args) {
		LinkedList L = new LinkedList();
		L.insertlink("Mybook", 100);
		L.insertlink("Mybook1", 200);
		L.insertlink("Mybook2", 200);
		System.out.println(L.cycleLink("Mybook"));
		System.out.println(L.reverse().cycleLink("Mybook"));
		
	}
	
	
	
}