package VeryImportantQuestions;

import java.util.HashMap;
import java.util.Map;

public class LinkedListWithRandomPointers {
	
	NodeWithRandomPointer makeDeepCopyWithMap(NodeWithRandomPointer root) {
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