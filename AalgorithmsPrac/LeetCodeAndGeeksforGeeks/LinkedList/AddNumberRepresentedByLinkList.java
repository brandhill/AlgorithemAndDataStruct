package LinkedList;

import java.util.Stack;

// http://www.geeksforgeeks.org/sum-of-two-linked-lists/

// Time - O(m+n) , m & n are sizes of 2 input linked lists
// Space - O(m+n)
public class AddNumberRepresentedByLinkList {
	
	 static LinkedList addLinkedListNumbers(LinkedList list1, LinkedList list2) {
		LinkedList result = new LinkedList();
		Stack<Link> stack1 = new Stack<Link>();
		Stack<Link> stack2 = new Stack<Link>();
		Link node1 = list1.firstlink;
		Link node2 = list2.firstlink;
		while(node1!=null) {
			stack1.add(node1);
			node1 = node1.next;
		}
		while(node2!=null) {
			stack2.add(node2);
			node2 = node2.next;
		}
		if(stack1.size()>stack2.size()) {
			return addNumbers(stack1,stack2);
		}
		else {
			return addNumbers(stack2,stack1);
		}
	}
	
	 static LinkedList addNumbers(Stack<Link> stack1, Stack<Link> stack2) {
		 LinkedList result = new LinkedList();
		 int carry = 0;
		 while(!stack1.isEmpty() && !stack2.isEmpty()) {
			 Link node1 = stack1.pop();
			 Link node2 = stack2.pop();
			 int num = node1.id + node2.id + carry;
			 if(num>9) {
				 carry = num/10;
				 num = num%10;
			 }
			 else {
				 carry = 0;
			 }
			 result.insert(num);
			 if (stack1.isEmpty() && stack2.isEmpty()) {
				 result.insert(carry);
			 }
		 }
		 if(!stack1.isEmpty()) {
			 Link node1 = stack1.pop();
			 int num = node1.id + carry;
			 if(num>9) {
				 carry = num/10;
				 num = num%10;
				 result.insert(num);
				 if(stack1.isEmpty())
					 result.insert(carry);
			 }
			 else {
				 result.insert(num);
				 carry = 0;
			 }
		 }
		 
		 return result;
	 }
	 
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		list1.insert(3);
		list1.insert(6);
		list1.insert(5);
		list2.insert(2);
		list2.insert(4);
		list2.insert(8);
//		list1.insert(9);
//		list1.insert(9);
//		list1.insert(9);
//		list2.insert(8);
//		list2.insert(1);
		LinkedList result = AddNumberRepresentedByLinkList.addLinkedListNumbers(list1, list2);
		Link node = result.firstlink;
		while(node!=null) {
			System.out.println(node.id);
			node = node.next;
		}
		
	}
}

