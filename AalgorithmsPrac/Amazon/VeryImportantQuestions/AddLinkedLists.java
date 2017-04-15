package VeryImportantQuestions;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class AddLinkedLists {
	
	NodeA addLinkedListsUsingStack(NodeA node1,NodeA node2) {
		
		Stack<NodeA> stack1 = new Stack<NodeA>();
		Stack<NodeA> stack2 = new Stack<NodeA>();
		Set<String> set = new HashSet<String>();
		while(node1!=null) {
			stack1.add(node1);
			node1 = node1.next;
		}
		while(node2!=null) {
			stack2.add(node2);
			node2 = node2.next;
		}
		if(stack1.size()>=stack2.size()) {
			return addLinkedListsUsingStackHelper(stack1,stack2);
		}
		else
			return addLinkedListsUsingStackHelper(stack2,stack1);
	}
	
	private NodeA addLinkedListsUsingStackHelper(Stack<NodeA> stack1, Stack<NodeA> stack2) {
		NodeA node = null;
		int carry = 0;
		while(!stack1.isEmpty()) {
			int n1 = stack1.pop().value;
			int n2 = stack2.isEmpty()?0:stack2.pop().value;
			int num = n1+n2+carry;
			if(num>9) {
				carry = num/10;
				num = num%10;
			}
			else {
				carry = 0;
			}
			
			NodeA n = new NodeA(num);
			if(node==null) {
				node = n;
			}
			else {
				n.next = node;
				node = n;
			}
		}		
		
		return node;
	}
	
//	NodeA addLinkedListsRecursive(NodeA node1, NodeA node2) {
//		return addLinkedListsRecursiveHelper(node1,node2,0);
//	}
//	
//	NodeA addLinkedListsRecursiveHelper(NodeA node1, NodeA node2,int carry) {
//		if(node1.next==null && node2.next ==null) {
//			return null;
//		}
//		
//		addLinkedListsRecursiveHelper(node1.next==null?node1:node1.next,node2.next==null?node2:node2.next,carry);
//		
//		
//	}
	
}

class NodeA {
	int value;
	NodeA next;
	NodeA(int val) {
		this.value = val;
	}
}