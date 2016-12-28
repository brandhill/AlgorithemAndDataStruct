package LinkedLists;

import java.util.Stack;


public class Palindrome7 {
	boolean checkPalindrome(DoubleEndedList doubleList){
		Neighbour N1 = doubleList.firstlink;
		Neighbour N2 = doubleList.lastlink;
		int count = 0;
		while(true){
			System.out.println(++count);
			if(N1.HouseNumber.equalsIgnoreCase(N2.HouseNumber)){
				N1 = N1.next;
				N2 = N2.previous;
			}
			else
				return false;
			if(N1.next==null || N2.previous==null){
				return true;
			}
		}
	}
	
	boolean checkPalindrome(LinkedList List){
		LinkedList revList = List.reverse();
		Link frwd = List.firstlink;
		Link rev = revList.firstlink;
		while(frwd!=null){
			if(!frwd.equals(rev))
				return false;
			frwd = frwd.next;
			rev = rev.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Palindrome7 q7 = new Palindrome7();
	/*DoubleEndedList doubleList = new DoubleEndedList();
	doubleList.insertfirst("", "1");
	doubleList.insertfirst("", "2");
	doubleList.insertfirst("", "3");
	doubleList.insertfirst("", "2");
	doubleList.insertfirst("", "1");
	doubleList.display();
	Palindrome7 q7 = new Palindrome7();
	System.out.println(q7.checkPalindrome(doubleList));*/
		LinkedList linkedList = new LinkedList();
		linkedList.insertlink("",5);
		linkedList.insertlink("",10);
		linkedList.insertlink("",20);
		linkedList.insertlink("",30);
		linkedList.insertlink("",10);
		linkedList.insertlink("",10);
		linkedList.insertlink("",5);	
		System.out.println(q7.checkPalindrome(linkedList));
	}
}
