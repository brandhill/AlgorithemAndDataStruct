package CareerCup;

import BinaryTree.Node;
import java.util.Random;
// https://www.careercup.com/question?id=6318655549734912

public class FindSummationAtEachNode {
	
	void printSummation(Node root) {
		if(root==null)
			return;
		
		printSum(root, 0);
	}
	
	static void printInorder(Node root) {
		if(root==null)
			return;
		printInorder(root.left);
		System.out.println(root.id);
		printInorder(root.right);
	}
	int printSum(Node node, int sum) {
		if(node==null)
			return sum;
		sum = printSum(node.right, sum);
//		System.out.println(node.id+" "+sum);
		int temp = node.id;
		node.id = sum;
		return printSum(node.left, sum+temp);
	}
	
//	int traversal(Node node) {
//		if(node == null) {
//			return 0;
//		}
//		return node.id+traversal(node.left)+traversal(node.right);
//	}
//	
//	int printSummation(Node node,int sumSoFar, int total) {
//		if(node==null)
//			return 0;
//		sumSoFar += printSummation(node.left,sumSoFar,total);
//		sumSoFar += node.id;
//		System.out.println(node.id+" "+(total-sumSoFar));
//		if(node.right!=null)
//			sumSoFar = printSummation(node.right,sumSoFar,total);
//		return sumSoFar;
//	}
	public static long randomLong() {
		long x = System.nanoTime();
		  x ^= (x << 21);
		  x ^= (x >>> 35);
		  x ^= (x << 4);
		  return Math.abs(x%11);
		}
	public static void main(String[] args) {
		Node n1 = new Node(7);
		Node n2 = new Node(3);
		Node n3 = new Node(10);
		n1.left = n2;
		n1.right = n3;
		Node n4 = new Node(1);
		n2.left = n4;
		Node n5 = new Node(5);
		n2.right = n5;
		Node n6 = new Node(12);
		n3.right = n6;
		FindSummationAtEachNode F = new FindSummationAtEachNode();
		F.printSummation(n1);
		printInorder(n1);
//		for(int i = 0; i< 5; i++)
//			System.out.println(randomLong());
	}
}
