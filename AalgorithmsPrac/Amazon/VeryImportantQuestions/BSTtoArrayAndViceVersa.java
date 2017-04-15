package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.Node;


public class BSTtoArrayAndViceVersa {
	
	static Node sortedArrayTOBST(int[] array) {
		
		if(array.length==0)
			return null;
		
		return findMaxSumOfSubArrayHelper(array,0,array.length-1);
	}
	
	private static Node findMaxSumOfSubArrayHelper(int[] array, int low, int high) {
		if(low>high)
			return null;
		int mid = (low+high)/2;
		Node root = new Node(array[mid]);
		root.left = findMaxSumOfSubArrayHelper(array,low,mid-1);
		root.right = findMaxSumOfSubArrayHelper(array, mid+1, high);
		
		return root;
	}
	
	static List<Integer> BSTtoSortedArray(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		BSTtoSortedArrayHelper(root,list);
		return list;
	}
	
	private static void BSTtoSortedArrayHelper(Node node, List<Integer> list) {
		
		if (node==null)
			return;
		BSTtoSortedArrayHelper(node.left,list);
		list.add(node.id);
		BSTtoSortedArrayHelper(node.right,list);
	}
	
	public static void main(String[] args) {
		int[] array = {0,1,2,3,4,5,6,7};
		Node n = sortedArrayTOBST(array);
		System.out.println(BSTtoSortedArray(n));
	}
}
