package BineryTree1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// This method is called from Contruct Binary Tree class

public class BinaryTreeToLinkedList4 {
	
	static List<LinkedList<Node>> ConvertToLinkedLists(Node node) {
		List<LinkedList<Node>> list = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> temp = new LinkedList<Node>();
		temp.add(node);
		System.out.println(node.id);
		list.add(temp);
		int index = 0;
		while(!temp.isEmpty()) {
			LinkedList<Node> L1 = list.get(index);
			temp = new LinkedList<Node>();
			for(Node n: L1) {
				if( n.left != null)
					temp.add(n.left);
				if( n.right != null)
					temp.add(n.right);
			}
			list.add(temp);
			index++;
			// This code is to print output
			System.out.println("--");
			for (Node n: temp){
				System.out.println(n.id);
			}
			// End of print output code
		}
		return list;
	}
	
}
