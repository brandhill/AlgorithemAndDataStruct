package LinkedLists;

import org.omg.Messaging.SyncScopeHelper;

public class DoubleEndedList {

	Neighbour firstlink;
	Neighbour lastlink;
	DoubleEndedList()
	{
		firstlink = null;
	}
	
	public void insertfirst(String Name,String HouseNumber)
	{
		Neighbour ref = new Neighbour(Name,HouseNumber);
		ref.next = firstlink;
		if (firstlink==null)
		{
			lastlink = ref;
		}
		else 
			firstlink.previous = ref;
		firstlink = ref;
	}
	public void insertLast(String Name,String HouseNumber)
	{
		Neighbour ref = new Neighbour(Name,HouseNumber);
		if (firstlink==null)
		{
			firstlink = ref;
		}
		else
		{
		ref.previous = lastlink;
		lastlink.next = ref;
		}
		lastlink = ref;
	}
	public String cycleLink(String bookname){
		Neighbour search = firstlink;
		int count = 0;
		while (search != null) {
			count++;
			System.out.println(count);
			if (search.Name.equalsIgnoreCase(bookname)) {
				return search.HouseNumber;
			}
			search = search.next;
		}
		System.out.println("No match found");
		return null;
	}
	public void display()
	{
		Neighbour theList = firstlink;
		while(theList!=null)
		{
			System.out.println("The Currentlink "+theList);
			theList.display();
			System.out.println("The Nextlink "+theList.next);
			System.out.println("The Prevlink "+theList.previous);
			theList = theList.next;
			System.out.println();
		}
	}
	public Neighbour removelastlink() throws NullPointerException
	{
		Neighbour current = lastlink;
		if(lastlink==null)
		{
			throw new NullPointerException("Link is empty");
		}
		else if(lastlink.previous == null )
		{
			lastlink = null;
		}
		else
		{
			Neighbour prev = lastlink.previous;
			prev.next = null;
			lastlink = prev;
			
		}
		return current;
	}
	public boolean insertkey(String Name,String Housenumber,String key)
	{
		Neighbour N = new Neighbour(Name,Housenumber);
		Neighbour start = firstlink;
		Neighbour end = lastlink;
		int count =0;
		while( end.next != start)
		{
			count++;
			System.out.println(count);
			if(Integer.parseInt(start.HouseNumber)  == Integer.parseInt(key))
			{
				Neighbour nextnei = start.next;
				N.next = start.next;
				N.previous = start;
				start.next = N;
				nextnei.previous =N;  
				System.out.println("Inserted successfully");
				return true;
			}
			else if(Integer.parseInt(end.HouseNumber)  == Integer.parseInt(key))
			{
				Neighbour nextnei = start.next;
				N.next = end.next;
				N.previous = end;
				end.next = N;
				nextnei.previous =N;
				System.out.println("Inserted successfully");
				return true;
			}
			else
			{
				start = start.next;
				end = end.previous;
			}
			
		}
		System.out.println("Did not find the key...");
		return false;
	}
	public static void main(String[] args) {
		try{
		DoubleEndedList D = new DoubleEndedList();
		D.insertfirst("Harsha", "1");
		D.insertfirst("Chaitanya", "2");
		D.insertfirst("macha", "3");
		D.insertfirst("AAAA", "5");
		D.insertfirst("AAAA", "6");
		D.insertfirst("AAAA", "4");
		D.insertfirst("AAAA", "7");
		D.insertfirst("AAAA", "10");
		D.insertkey("BBBB","9", "2");
		D.display();
		D.insertkey("CCCC","11", "5");
		D.display();
		}
		catch(NullPointerException a)
		{
			System.out.println(a.getMessage());
		}
	}
}
