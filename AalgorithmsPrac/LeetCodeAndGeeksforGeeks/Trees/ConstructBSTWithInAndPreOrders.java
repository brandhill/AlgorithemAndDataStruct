package Trees;

import BinaryTree.Node;

public class ConstructBSTWithInAndPreOrders {
	
	static Node ContructBST(int[] inOrder, int[] preOrder, int inStart, int inEnd, int preStart, int preEnd) {
		
				if(inStart>inEnd || preStart>preEnd) {
					return null;
				}
				int value = preOrder[preStart];
				int index = findIndex(inOrder,inStart,inEnd,value);
				Node node = new Node(value);
				node.left = ContructBST(inOrder, preOrder, inStart, index-1, preStart+1, preStart+(index-inStart));
				node.right = ContructBST(inOrder, preOrder, index+1, inEnd, preStart+(index-inStart)+1, preEnd);
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
		System.out.println(root.id);
		printInorder(root.right);
	}
	
	public static void main(String[] args) {
		int[] inOrder = {1,2,3,5,6,7,8};
		int[] preOrder = {5,2,1,3,7,6,8};
		Node root = ContructBST(inOrder, preOrder,0,inOrder.length-1,0,preOrder.length-1);
		printInorder(root);
	}
}
