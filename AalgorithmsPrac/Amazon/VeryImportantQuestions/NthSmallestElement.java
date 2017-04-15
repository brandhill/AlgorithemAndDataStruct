package VeryImportantQuestions;

import BinaryTree.Node;

public class NthSmallestElement {
	
	static Node findNthSmallestElement(Node root,int n) {
		if(root==null || n<=0)
			return null;
		result r = new result();
		r.id = 0;
		return findNthSmallestElement(root,n,r);
	}
	
	static private Node findNthSmallestElement(Node node,int n,result r) {
		
		if(node==null)
			return null;

		Node temp = findNthSmallestElement(node.left,n,r);
		if(temp!=null)
			return temp;
		r.id += 1;
		if(r.id==n)
			return node;
		return findNthSmallestElement(node.right,n,r);
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(6);
		Node n2 = new Node(3);
		Node n3 = new Node(8);
		Node n4 = new Node(1);
		Node n5 = new Node(5);
		Node n6 = new Node(4);
		Node n7 = new Node(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n3.right = n7;
		System.out.println(findNthSmallestElement(n1, 3).id);
	}
}

class result {
	int id;
	int value;
}
