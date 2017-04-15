package VeryImportantQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import BinaryTree.Node;

public class PrintTreeInZigZagFashion {
	
	static void printZigZag(Node node) {
		if(node==null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		System.out.print(node.id+" ");
		while(!stack.isEmpty()) {
			stack = leftPrint(stack);
			if(stack.isEmpty())
				return;
			stack = rightPrint(stack);
		}
	}
	
	private static Stack<Node> leftPrint(Stack<Node> stack) {
		Stack<Node> temp = new Stack<Node>();
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			if(n.left!=null) {
				System.out.print(n.left.id+" ");
				temp.push(n.left);
			}
			if(n.right!=null) {
				System.out.print(n.right.id+" ");
				temp.push(n.right);
			}
		}
		return temp;
	}
	
	private static Stack<Node> rightPrint(Stack<Node> stack) {
		Stack<Node> temp = new Stack<Node>();
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			if(n.right!=null) {
				System.out.print(n.right.id+" ");
				temp.push(n.right);
			}
			if(n.left!=null) {
				System.out.print(n.left.id+" ");
				temp.push(n.left);
				}			
		}
		return temp;

	}
	
	public static void main(String[] args) {
		Node n1 = new Node(8);
		Node n2 = new Node(3);
		Node n3 = new Node(10);
		Node n4 = new Node(1);
		Node n5 = new Node(6);
		Node n6 = new Node(14);
		Node n7 = new Node(4);
		Node n8 = new Node(7);
		Node n9 = new Node(13);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n5.left = n7;
		n5.right = n8;
		n6.left = n9;
		printZigZag(n1);
	}
}
