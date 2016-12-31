package BineryTree1;

public class FindNextNode6 {
	
	
	static NParent FindNextNode(NParent node) {
		
		if(node.parent == null || node.right !=null) {
			
			return leftMostNode(node.right);
			
		}
		else {
			NParent parent = node.parent;
			
			while(parent!=null && !parent.left.equals(node)) {
				node = parent;
				parent = parent.parent;
			}
			
			return parent;
		}
		
	}	
	
	
	private static NParent leftMostNode(NParent n) {
		if ( n == null )
			return null;
		while( n.left != null ){
			n = n.left;
		}
		
		return n;
	}
	
}
