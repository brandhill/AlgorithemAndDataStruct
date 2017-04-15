package VeryImportantQuestions;

public class CheckIfTreeIsSubtree {
	
	static boolean checkIfSubTree(Nodetemp root, Nodetemp subRoot) {
		if(subRoot==null) {
			return true;
		}
		
		return checkIfSubTreeHelper(root,subRoot);
	}
	
	static private boolean checkIfSubTreeHelper(Nodetemp node, Nodetemp subNode) {
		if(node==null) {
			return false;
		}
		
		if(node.n == subNode.n)
			if(compareNodes(node,subNode))
				return true;
		return checkIfSubTreeHelper(node.left,subNode) || checkIfSubTreeHelper(node.right,subNode);

	}
	
	
	static private boolean compareNodes(Nodetemp node, Nodetemp subNode) {
		if(node==null && subNode==null) {
			return true;
		}
		if(node==null || subNode==null) {
			return false;
		}
		if(node.n!=subNode.n)
			return false;
		
		return compareNodes(node.left,subNode.left) && compareNodes(node.right,subNode.right);
	}
	
	public static void main(String[] args) {
		Nodetemp r1 = new Nodetemp(1);
		Nodetemp r2 = new Nodetemp(2);
		Nodetemp r3 = new Nodetemp(3);
		Nodetemp r4 = new Nodetemp(4);
		Nodetemp r5 = new Nodetemp(5);
		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		r2.right = r5;
		Nodetemp s1 = new Nodetemp(2);
		Nodetemp s2 = new Nodetemp(4);
		Nodetemp s3 = new Nodetemp(5);
		s1.left = s2;
//		s1.right = s3;
		Nodetemp s4 = new Nodetemp(-1);
		System.out.println(checkIfSubTree(r1, s3));
		Nodetemp rr1 = null;
		System.out.println(checkIfSubTree(rr1, s4));
	}
}


class Nodetemp {
	int n;
	Nodetemp left;
	Nodetemp right;
	
	public Nodetemp(int n) {
		this.n = n;
	}
}