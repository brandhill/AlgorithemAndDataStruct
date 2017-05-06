package Trees;

import java.util.HashSet;
import java.util.Set;

import BinaryTree.Node;

// http://www.geeksforgeeks.org/print-left-view-binary-tree/

public class PrintLeftViewOfTree {
	
	static void printLeftView(Node root) {
		if(root==null)
			return;
		System.out.println(root.id);
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		printLeftViewHelper(root.left,1,set);
		printLeftViewHelper(root.right,1,set);
	}
	
	static void printLeftViewHelper(Node node, int level, Set<Integer> set) {
		if(node==null)
			return;
		if(!set.contains(level)) {
			set.add(level);
			System.out.println(node.id);
		}
		printLeftViewHelper(node.left,level+1,set);
		printLeftViewHelper(node.right,level+1,set);
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.left = n2;
		n1.right = n3;
		Node n4 = new Node(4);
		n2.left = n4;
		Node n5 = new Node(5);
		n3.left = n5;
		Node n6 = new Node(6);
		n5.right = n6;
		printLeftView(n1);
	}
	
}
