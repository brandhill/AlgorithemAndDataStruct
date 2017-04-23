package CareerCup;

import BinaryTree.Node;
import VeryImportantQuestions.BSTtoArrayAndViceVersa;

// https://www.careercup.com/question?id=5719185954963456

public class CheckIfBST {
	
	static boolean checkIfBST(Node root) {
		if(root == null)
			return true;
		return checkIfBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private static boolean checkIfBSTHelper(Node node, int min, int max) {
		if(node==null)
			return true;
		if(!(node.id>=min && node.id<max)) 
			return false;
		return checkIfBSTHelper(node.left,min,node.id) && checkIfBSTHelper(node.right, node.id, max);
	}
	
	public static void main(String[] args) {
		int[] array = {0,1,2,3,4,5,6,7};
		Node n = BSTtoArrayAndViceVersa.sortedArrayTOBST(array);
		System.out.println(checkIfBST(n));
	}
}
