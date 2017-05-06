package VeryImportantQuestions;

import java.util.HashMap;
import java.util.Map;

public class LinkedListWithRandomPointers {
	
	static NodeWithRandomPointer makeDeepCopyWithMap(NodeWithRandomPointer root) {
		NodeWithRandomPointer root1 = null;
		
		Map<NodeWithRandomPointer, NodeWithRandomPointer> map = new HashMap<NodeWithRandomPointer, NodeWithRandomPointer>();
		
		NodeWithRandomPointer node = root;
		NodeWithRandomPointer node1 = null;
		while(node!=null) {
			NodeWithRandomPointer n = new NodeWithRandomPointer(node.val);
			if(node1==null) {
				node1 = n;
				root1 = node1;
			}
			else {
				node1.next = n;
				node1 = node1.next;
			}
			map.put(node, node1);
			n = n.next;
		}
		
		node = root;
		node1 = root1;
		
		while(node!=null) {
			node1.random = map.get(node.random);
			node = node.next;
			node1 = node1.next;
		}
		
		return root1;
	}
	
	
	static NodeWithRandomPointer makeDeepCopy(NodeWithRandomPointer root) {
		
		NodeWithRandomPointer newRoot = null;
		NodeWithRandomPointer node = root;
		NodeWithRandomPointer node1 = null;

		while(node!=null) {
			if(newRoot==null) {
				newRoot = new NodeWithRandomPointer(node.val);
				node1 = newRoot;
			} else {
				node1.next = new NodeWithRandomPointer(node.val);
				node1 = node1.next;
			}
			NodeWithRandomPointer next = node.next;
			node1.random = node;
			node.next = node1;
			node = next;
		}
		
		node = root;
		node1 = newRoot;
		
		while(node1!=null) {	
			NodeWithRandomPointer temp = node1.random;
			System.out.println(temp.val);
			node1.random = temp.random;
			if(node1.next!=null)
				temp.next = node1.next.random;
			else
				temp.next = null;
			
			node1 = node1.next;
		}
		
		return newRoot;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		NodeWithRandomPointer n1 = new NodeWithRandomPointer(1);
		NodeWithRandomPointer n2 = new NodeWithRandomPointer(2);
		NodeWithRandomPointer n3 = new NodeWithRandomPointer(3);
		NodeWithRandomPointer n4 = new NodeWithRandomPointer(4);
		NodeWithRandomPointer n5 = new NodeWithRandomPointer(5);
		n1.next = n2;
		n1.random = n3;
		n2.next = n3;
		n2.random = n4;
		n3.next = n4;
		n3.random = n5;
		n4.next = n5;
		n4.random = n1;
		n5.random = n2;
		NodeWithRandomPointer newRoot = makeDeepCopy(n1);
		while(newRoot.next!=null) {
			System.out.println(newRoot.val+" "+newRoot.next.val+" "+newRoot.random.val);
			newRoot = newRoot.next;
		}
		System.out.println(newRoot.val+" null "+newRoot.random.val);
		System.out.println("--------");
//		newRoot = makeDeepCopyWithMap(n1);
//		while(newRoot!=null) {
//			System.out.println(newRoot.val+" "+newRoot.next.val+" "+newRoot.random.val);
//			newRoot = newRoot.next;
//		}
	}
}


class NodeWithRandomPointer {
	int val;
	NodeWithRandomPointer next;
	NodeWithRandomPointer random;
	public NodeWithRandomPointer(int val) {
		this.val = val;
		next = null;
		random = null;
	}
}