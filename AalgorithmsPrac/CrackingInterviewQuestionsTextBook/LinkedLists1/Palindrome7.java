package LinkedLists1;

public class Palindrome7 {

	static boolean IsPalindrome(Link link){
		if(link == null)
			return false;
		
		LinkedList temp = new LinkedList(); 
		Link slow = link;
		Link fast = link;
		while(fast!=null) {
			if(fast.next==null){
				slow = slow.next;
				break;
			}
			temp.insert(slow.id);
			slow = slow.next;
			fast = fast.next.next;
		}
		Link lookup = temp.firstlink;
		while(slow!=null) {
			if(!slow.equals(lookup)) {
				return false;
			}
			slow = slow.next;
			lookup = lookup.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		System.out.println(Palindrome7.IsPalindrome(list.firstlink));
	}
}
