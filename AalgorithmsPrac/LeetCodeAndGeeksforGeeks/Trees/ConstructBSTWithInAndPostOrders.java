package Trees;

import BinaryTree.Node;

public class ConstructBSTWithInAndPostOrders {
	
	static Node constructBST(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {
		
			if(inStart>inEnd || postStart>postEnd)
				return null;
			int value = postOrder[postEnd];
			Node node = new Node(value);
			int index = findIndex(inOrder, inStart, inEnd, value);
			node.left = constructBST(inOrder,postOrder, inStart, index-1,postStart+(index-inStart), postEnd-1);
			node.right = constructBST(inOrder,postOrder, index+1, inEnd, postStart, postStart+(index-inStart)-1);
			return node;
	}
	
	static int findIndex(int[] array, int start, int end, int value) {
		
		while(start<=end) {
			int mid = (start+end)/2;
			if(array[mid]==value) {
				return mid;
			} else if(array[mid]>value) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		return -1;
	}
	
	static void printInorder(Node root) {
		if(root==null)
			return;
		printInorder(root.left);
		System.out.print(root.id+" 	");
		printInorder(root.right);
	}
	public static void main(String[] args) {
		int[] inOrder = {1,2,3,5,6,7,8};
		int[] postOrder = {8,6,7,3,1,2,5};
		Node root = constructBST(inOrder, postOrder,0,inOrder.length-1,0,postOrder.length-1);
		printInorder(root);
	}
	
}
