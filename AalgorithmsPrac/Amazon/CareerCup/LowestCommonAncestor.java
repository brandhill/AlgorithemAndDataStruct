package CareerCup;

import BinaryTree.Node;

public class LowestCommonAncestor {
	
	Node lowestCommonAncestor(Node root, Node node1, Node node2) {
		if(root==null)
			return null;
		CommonAncestor commonAncestor = new CommonAncestor();
		return lowestCommonAncestor(root,node1, node2, commonAncestor);
	}
	
	Node lowestCommonAncestor(Node node, Node node1, Node node2, CommonAncestor commonAncestor) {
		if(node == null)
			return null;
		if(commonAncestor.commonAncestor != null)
			return null;
		Node left = lowestCommonAncestor(node.left, node1, node2, commonAncestor);
		Node right = lowestCommonAncestor(node.right, node1, node2, commonAncestor);
		if((left!=null && right!=null) || ((left!=null || right!=null) && (node==node1 || node==node2))) {
			commonAncestor.commonAncestor = node;
			return node;
		}
		if(node==node1 || node==node2) {
			return node;
		}
		
		return left!=null?left:(right!=null?right:null);
	}
}

class CommonAncestor {
	Node commonAncestor;
	CommonAncestor() {
		commonAncestor = null;
	}
}
