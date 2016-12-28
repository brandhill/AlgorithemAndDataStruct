package BineryTree1;

public class IsBinarySearchTree5 {
	
	boolean isBinaryTree(Node node){
		return isBinaryTree(node,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}
	
	boolean isBinaryTree(Node node,int max, int min) {
		
		if(node==null)
			return true;
		
		if ( !(min <= node.id && max > node.id) ) {
			return false; 
		}
		
		if ( !isBinaryTree(node.left,node.id,min) || !isBinaryTree(node.right,max,node.id) ) {
			return false;
		}
		
		/*boolean left = isBinaryTree(node.left,node.id,min);
		
		if (!left)
			return false;
		
		boolean right = isBinaryTree(node.right,max,node.id);
		
		if (!right)
			return false;*/
		
		return true;
		
	}
}
