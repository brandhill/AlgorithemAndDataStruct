package BineryTree1;

public class FirstCommonAncestor7 {
	
	private static boolean checkIfPresent(Node root,Node n) {
		
		if(root == null)
			return false;
		if(root.equals(n))
			return true;
		
		return checkIfPresent(root.left,n) || checkIfPresent(root.right,n);
	}
	
	
	private static Node FirstCommonAncestorHelper(Node root, Node p, Node q) {
		
		if (root == null) {
			return null;
		}
		
		if (root.equals(p) || root.equals(q))
			return root;
		
			boolean is_p_onleft = checkIfPresent(root.left,p);
			boolean is_q_onleft = checkIfPresent(root.left,q);
			
			if (is_p_onleft != is_q_onleft) {
				return root;
			} 
			else if (is_p_onleft) {
				return FirstCommonAncestorHelper(root.left,p,q);
			}
			else {
				return FirstCommonAncestorHelper(root.right,p,q);
			}
		
	}
	
	static Node FirstCommonAncestor(Node root,Node p,Node q){
		
		boolean p_check = checkIfPresent(root,p);
		boolean q_check = checkIfPresent(root,q);
		
		if ( !p_check || !q_check ) {
			return null;
		}
		else 
			return FirstCommonAncestorHelper(root, p, q);
	}
	
	
}
