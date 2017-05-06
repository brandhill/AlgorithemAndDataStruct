package VeryImportantQuestions;

import java.util.Queue;
import java.util.LinkedList;

public class CheckIfTreeIsMirrorTree {
	
	static boolean checkIfMirror(Node3 root) {
		if(root==null)
			return true;
		return checkIfMirrorHelper(root.left,root.right);
	}
	
	static boolean checkIfMirrorHelper(Node3 node1, Node3 node2) {
		if(node1==null && node2==null)
			return true;
		if(node1==null || node2==null)
			return false;
		if(node1.value!= node2.value)
			return false;
		
		return checkIfMirrorHelper(node1.left,node2.right) && checkIfMirrorHelper(node1.right,node2.left);
	}
	
	// Without Recursion
	
	static boolean checkIfMirror1(Node3 node) {
		
		if(node==null || (node.left==null && node.right==null))
			return true;
		
		if(node.left==null || node.right==null || node.left.value!=node.right.value)
			return false;
		
		Queue<Node3> leftQueue = new LinkedList<Node3>(); 
		Queue<Node3> rightQueue = new LinkedList<Node3>();
		
		leftQueue.offer(node.left);
		rightQueue.offer(node.right);
		while(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			
			if(leftQueue.size()!=rightQueue.size())
				return false;
			Queue<Node3> tempLeftQueue = new LinkedList<Node3>(); 
			Queue<Node3> tempRightQueue = new LinkedList<Node3>();
			while(!leftQueue.isEmpty()) {
				Node3 leftNode = leftQueue.poll();
				Node3 rightNode = rightQueue.poll();
				Node3 leftNodeLeft = leftNode.left;
				Node3 rightNoderight = rightNode.right;
				if(!checkIfEqual(leftNodeLeft, rightNoderight, tempLeftQueue, tempRightQueue))
					return false;
				Node3 leftNoderight = leftNode.left;
				Node3 rightNodeleft = rightNode.right;
				if(!checkIfEqual(leftNoderight, rightNodeleft, tempLeftQueue, tempRightQueue))
					return false;
			}
			leftQueue = tempLeftQueue;
			rightQueue = tempRightQueue;
		}
		if(!leftQueue.isEmpty() || !rightQueue.isEmpty())
			return false;
		
		return true;
	}
	
	static boolean checkIfEqual(Node3 node1, Node3 node2,Queue<Node3> queue1,Queue<Node3> queue2 ) {
		if(node1==null && node2==null)
			return true;
		if(node1==null || node2==null)
			return false;
		if(node1.value!=node2.value)
			return false;
		queue1.offer(node1);
		queue2.offer(node2);
		return true;
	}
	public static void main(String[] args) {
		Node3 n1 = new Node3(1);
		Node3 n2 = new Node3(2);
		Node3 n3 = new Node3(2);
		Node3 n4 = new Node3(3);
		Node3 n5 = new Node3(4);
		Node3 n6 = new Node3(4);
		Node3 n7 = new Node3(3);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		System.out.println(checkIfMirror1(n1));
		System.out.println(checkIfMirror(n1));

	}
}
