package VeryImportantQuestions;

public class CheckIfTreeIsMirrorTree {
	
	boolean checkIfMirror(Node3 root) {
		if(root==null)
			return true;
		return checkIfMirrorHelper(root.left,root.right);
	}
	
	boolean checkIfMirrorHelper(Node3 node1, Node3 node2) {
		if(node1==null && node2==null)
			return true;
		if(node1==null || node2==null)
			return false;
		if(node1.value!= node2.value)
			return false;
		
		return checkIfMirrorHelper(node1.left,node2.right) && checkIfMirrorHelper(node1.right,node2.left);
	}
	
	public static void main(String[] args) {
		
	}
}
