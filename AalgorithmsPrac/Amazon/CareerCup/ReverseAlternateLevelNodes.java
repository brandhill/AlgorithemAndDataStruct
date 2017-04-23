package CareerCup;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import BinaryTree.Node;
import VeryImportantQuestions.BSTtoArrayAndViceVersa;

// https://www.careercup.com/question?id=5068704572243968


public class ReverseAlternateLevelNodes {
		
	static void reverse(Node root) {
		if(root==null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		queue.add(root);
		stack.push(root.left);
		stack.push(root.right);
		boolean check = false;
		while(!queue.isEmpty()) {
			Stack<Node> tempstack = new Stack<Node>();
			Queue<Node> tempQueue = new LinkedList<Node>();
			while(!queue.isEmpty()) {
				Node n = queue.poll();
				if(!stack.isEmpty()) {
					Node left = stack.pop();
					System.out.println(left);
					n.left = left;
					if(left!=null) {
						tempQueue.add(left);
						tempstack.push(check?left.left:left.right);
						tempstack.push(check?left.right:left.left);
					} 
				} 
				if(!stack.isEmpty()) {
					Node right = stack.pop();
					System.out.println(right);
					n.right = right;
					if(right!=null) {
						tempQueue.add(right);
						tempstack.push(check?right.left:right.right);
						tempstack.push(check?right.right:right.left);
					}
				} 
				
				System.out.println("  "+n+"  ");
				System.out.println(n.left+"  "+n.right);
			}
			System.out.println("---");
			check = check?false:true;
			queue = tempQueue;
			stack = tempstack;
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {-1,0,1,2,3,4,5,6,7};
		Node n = BSTtoArrayAndViceVersa.sortedArrayTOBST(array);
		reverse(n);
	}
}
