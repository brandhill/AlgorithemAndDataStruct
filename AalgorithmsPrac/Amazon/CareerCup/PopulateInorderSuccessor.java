package CareerCup;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BinaryTree.ConstructBinaryTree;
import BinaryTree.Node;

// https://www.careercup.com/question?id=5169618186403840

public class PopulateInorderSuccessor {
	
	static void populateInorderSuccessor(Node root) {
		if(root==null)
			return;
		List<Node> list = new ArrayList<Node>();
		Integer prev = null;
		populateInorderSuccessor(root,prev);
		for(Node n: list)
			System.out.print(n.id+" ");
	}
	
	static Integer populateInorderSuccessor(Node node, Integer prev) {
		if(node==null)
			return prev;
		prev = populateInorderSuccessor(node.left,prev);
		int temp = node.id;
		if(prev!=null)
			node.id = prev;
		prev = temp;
		return populateInorderSuccessor(node.right,prev);
	}
	
	
	static void printInorder(Node root) {
		if(root==null)
			return;
		printInorder(root.left);
		System.out.print(root.id+" ");
		printInorder(root.right);
	}
	public static void main(String[] args) {
		ConstructBinaryTree CBT = new ConstructBinaryTree();
		List<Node> preorder = new ArrayList<Node>();
		preorder.add(new Node(50));
		preorder.add(new Node(30));
		preorder.add(new Node(10));
		preorder.add(new Node(40));
		preorder.add(new Node(70));
		preorder.add(new Node(60));
		preorder.add(new Node(90));
		List<Node> inorder = new ArrayList<Node>();
		inorder.add(new Node(10));
		inorder.add(new Node(30));
		inorder.add(new Node(40));
		inorder.add(new Node(50));
		inorder.add(new Node(60));
		inorder.add(new Node(70));
		inorder.add(new Node(90));
		Node root = CBT.PreInorders(preorder, inorder, 0 , preorder.size() - 1, 0 ,preorder.size() - 1);
		printInorder(root);
		populateInorderSuccessor(root);
		System.out.println();
		printInorder(root);
	}
}

class HoldNode {
	Node prev;
}
