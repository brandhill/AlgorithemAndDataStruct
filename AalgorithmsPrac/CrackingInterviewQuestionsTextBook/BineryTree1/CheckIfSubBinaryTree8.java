package BineryTree1;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfSubBinaryTree8 {

	
	static boolean checkIfSubBinaryTree(Node root, Node check) {
		
		if(root==null)
			return false;
		if(check==null)
			return true;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			
			if(n.equals(check)) {
				boolean ans = checkIfSubBinaryTreeHelper(n,check);
				
				if(ans)
					return ans;
			}
			
			if(n.left != null)
				queue.add(n.left);
			if(n.right !=null)
				queue.add(n.right);
		}
		
		return false;
	}
	
	private static boolean checkIfSubBinaryTreeHelper(Node root,Node check) {
		
		
		if(root == null && check == null)
			return true;
		if (root ==null || check == null)
			return false;
		if(!root.equals(check))
			return false;
		
		return checkIfSubBinaryTreeHelper(root.left,check.left) && checkIfSubBinaryTreeHelper(root.right,root.right);
		
	}
}
