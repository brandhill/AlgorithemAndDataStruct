package Trees;

import javax.swing.plaf.synth.SynthSpinnerUI;

import BinaryTree.Node;
// http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/

public class ChangeNodeValueToSumOfAllGreaterNumbersinBST {
	static void changeNodeValues(Node root) {
		
		if(root==null)
			return;
		changeNodeValueHelper(root,0);
	}
	
	static int changeNodeValueHelper(Node node, int sum) {
		if(node==null)
			return sum;
		sum = changeNodeValueHelper(node.right, sum);
		int temp = node.id;
		node.id = sum;
		sum += temp;
		System.out.println(temp+" "+node.id);
		return changeNodeValueHelper(node.left, sum);
	}
	public static void main(String[] args) {
		Node n1 = new Node(7);
		Node n2 = new Node(3);
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
		changeNodeValues(n1);
		System.out.println("----");
//		ConstructBSTWithInAndPreOrders.printInorder(n1);
	}
}
