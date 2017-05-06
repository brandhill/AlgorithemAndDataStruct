package StandardAlgorithems;

public class AVLTree {
	NodeWithHeight root;
	void insert(int val) {
		NodeWithHeight nodeWithHeight = new NodeWithHeight(val);
		if(root==null) {
			root = nodeWithHeight;
			return;
		}
		if(val<=root.id) {
			insertHelper(root, root.left,nodeWithHeight, false);
			root.leftHeight += 1;
		}
		else {
			insertHelper(root, root.right,nodeWithHeight, true);
			root.rightHeight += 1;
		}
		
		if(Math.abs(root.leftHeight-root.rightHeight)>1) {
			balanceTree(null,root);
		}
	}
	private void insertHelper(NodeWithHeight parent, NodeWithHeight nodeWithHeight, NodeWithHeight newNode, boolean isRight) {
		if(nodeWithHeight==null) {
			if(isRight)
				parent.right = newNode;
			else
				parent.left = newNode;
		}
		if(newNode.id<=nodeWithHeight.id) {
			insertHelper(nodeWithHeight, nodeWithHeight.left, newNode, false);
			nodeWithHeight.leftHeight += 1;
		}
		else {
			insertHelper(nodeWithHeight, nodeWithHeight.right,newNode, true);
			nodeWithHeight.rightHeight += 1;
		}
		
		if(Math.abs(nodeWithHeight.leftHeight-nodeWithHeight.rightHeight)>1) {
			balanceTree(parent,nodeWithHeight);
		}
	}
	private void balanceTree(NodeWithHeight parent,NodeWithHeight nodeWithHeight) {
		if(nodeWithHeight.leftHeight>nodeWithHeight.rightHeight) {
			if(nodeWithHeight.left.rightHeight>nodeWithHeight.left.leftHeight) {
				rotateLeft(nodeWithHeight, nodeWithHeight.left);
			} 
				rotateRight(parent, nodeWithHeight);
		} else {
			if(nodeWithHeight.right.leftHeight>nodeWithHeight.right.rightHeight) {
				rotateRight(nodeWithHeight, nodeWithHeight.right);
			} 
				rotateLeft(parent, nodeWithHeight);
		}
		
	}
	private void rotateLeft(NodeWithHeight parent, NodeWithHeight node) {
		NodeWithHeight newRoot = node.right;
		node.right = newRoot.left;
		newRoot.left = node;
		updateHeights(node);
		updateHeights(newRoot);
		if(node==root)
			root = newRoot;
		else {
			parent.left = newRoot;
		}
	}

	private void rotateRight(NodeWithHeight parent, NodeWithHeight node) {
		NodeWithHeight newRoot = node.left;
		node.left = newRoot.right;
		newRoot.right = node;
		updateHeights(node);
		updateHeights(newRoot);
		if(node==root)
			root = newRoot;
		else {
			parent.right = newRoot;
		}
	}

	
	void updateHeights(NodeWithHeight node) {
		node.leftHeight = (node.left!=null?Math.max(node.left.leftHeight, node.left.rightHeight):0) +1;
		node.rightHeight = (node.right!=null?Math.max(node.right.leftHeight, node.right.rightHeight):0) +1;
		node.leftHeight = (node.left!=null?Math.max(node.left.leftHeight, node.left.rightHeight):0) +1;
		node.rightHeight = (node.right!=null?Math.max(node.right.leftHeight, node.right.rightHeight):0) +1;
	}
}

class NodeWithHeight {
	public int id;
	public NodeWithHeight left;
	public NodeWithHeight right;
	public int leftHeight;
	public int rightHeight;
	public NodeWithHeight(int id){
		 this.id = id;
	}
	public void display(){
		 System.out.println("Id: "+id);
	}



	@Override
	public String toString() {
		return ""+id;
	}
	public boolean equals(Object obj){
		NodeWithHeight node = (NodeWithHeight) obj;
		if(this.id == node.id)
			return true;
		return false;
	}
}