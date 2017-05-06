package Trees;

import BinaryTree.Node;

// http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/

public class ArbitaryTreeToChildSumTree {
	
	static void changeValue(Node root) {
		if(root==null)
			return;
		changeValueHelper(root);
	}
	
	static int changeValueHelper(Node node) {
		if(node==null)
			return 0;
		int left = changeValueHelper(node.left);
		int right = changeValueHelper(node.right);
		int sum = left+right;
		if(sum==0) {
//			System.out.println(node.id+" "+node.id);
			return node.id;
		}
//		int temp = node.id;
		if(sum<node.id) {
			int diff = node.id - sum;
			Node n = node;
			while(true) {
				if(n.left==null && n.right==null)
					break;
				else if(n.left!=null) {
					n = n.left;
				} else {
					n = n.right;
				}
				System.out.println(n.id+" "+(n.id+diff));
				n.id += diff;
			}
		}
		node.id = sum;
//		System.out.println(temp+" "+node.id);
		return node.id;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(80);
		Node n2 = new Node(30);
		Node n3 = new Node(15);
		n1.left = n2;
		n1.right = n3;
		Node n4 = new Node(1);
		Node n5 = new Node(5);
		n2.left = n4;
		n2.right = n5;
		Node n6 = new Node(2);
		n4.right = n6;
		Node n7 = new Node(4);
		Node n8 = new Node(6);
		n5.left = n7;
		n5.right = n8;
		Node n9 = new Node(11);
		Node n10 = new Node(9);
		Node n11 = new Node(13);
		Node n12 = new Node(18);
		n3.left = n9;
		n3.right = n12;
		n9.left = n10;
		n9.right = n11;
		changeValue(n1);
		ConstructBSTWithInAndPreOrders.printInorder(n1);
	}
}
