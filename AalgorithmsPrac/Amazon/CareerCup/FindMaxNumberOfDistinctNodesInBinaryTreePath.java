package CareerCup;

import java.util.HashSet;
import java.util.Set;

import BinaryTree.Node;
import VeryImportantQuestions.BSTtoArrayAndViceVersa;

//https://www.careercup.com/question?id=5631266591342592
public class FindMaxNumberOfDistinctNodesInBinaryTreePath {
	
	
	static int findMaxNodes(Node root) {
		if(root==null)
			return 0;
		Set<Integer> set = new HashSet<Integer>();
		return treeTraversal(root, set, 0);
	}
	
	static int treeTraversal(Node node, Set<Integer> set, int maxSize) {
		if(node==null)
			return maxSize;
		if(!set.contains(node.id)) {
			maxSize++;
			set.add(node.id);
		}
		maxSize = Math.max(treeTraversal(node.left, set, maxSize), treeTraversal(node.right, set, maxSize));
		set.remove(node.id);
		return maxSize;
	}
	
	public static void main(String[] args) {
		Node n = new Node(3);
		Node n1 = new Node(5);
		Node n2 = new Node(6);
		Node n3 = new Node(1);
		Node n4 = new Node(4);
		Node n5 = new Node(6);
		Node n6= new Node(7);
		Node n7 = new Node(4);
		Node n8 = new Node(-1);
		n.left = n1;
		n.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n7;
		n5.left = n8; 
		System.out.println(findMaxNodes(n));
	}
}
