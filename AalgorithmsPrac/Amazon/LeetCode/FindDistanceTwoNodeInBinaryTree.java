package LeetCode;

import java.util.Stack;

import BinaryTree.Node;

// https://discuss.leetcode.com/topic/38290/given-a-binary-search-tree-find-the-distance-between-2-nodes/8

public class FindDistanceTwoNodeInBinaryTree {
	
	static int findDistanceForNodes(Node n1, Node n2, Node root) {
		if(root==null || n1 ==null || n2==null)
			return 0;
		Temp temp = new Temp();
		int n = findPathForNodes(root,n1,n2,temp)-1;
		return (temp.foundNode1&&temp.foundNode2)?n:0;
	}

	private static int findPathForNodes(Node node, Node n1, Node n2,Temp temp) {
		if(node==null || temp.foundLen)
			return 0;
		System.out.println(node.id);
		if(node==n1) {
			temp.foundNode1 = true;
		}
		if(node==n2)
			temp.foundNode2 = true;
		int left = findPathForNodes(node.left,n1,n2,temp);
		int right = findPathForNodes(node.right,n1,n2,temp);
		
		// End case - found both the nodes
		if((left>0 && right>0) || ((left>0 || right>0) && (node==n1 || node==n2))) {
			temp.foundLen = true;
			return left+right+1;
		}
		
		// found one node
		if((left>0 || right>0 || node==n1 || node==n2) && !temp.foundLen)
			return left+right+1;
		
		return Math.max(left, right);
	}
	

	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n4.right = n9;
		System.out.println(findDistanceForNodes(n4,n7,n1));
	}
}

class Temp {
	boolean foundNode1;
	boolean foundNode2;
	boolean foundLen;
}