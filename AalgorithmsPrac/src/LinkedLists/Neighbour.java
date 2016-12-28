package LinkedLists;

public class Neighbour {
String Name;
String HouseNumber;
Neighbour next;
Neighbour previous;
	Neighbour(String Name,String HouseNumber)	
	{
		this.Name = Name;
		this.HouseNumber = HouseNumber;
	}
	void display()
	{
		System.out.println("Address of "+Name+" is "+HouseNumber);
	}
}
