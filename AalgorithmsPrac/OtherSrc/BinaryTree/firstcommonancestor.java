package BinaryTree;

public class firstcommonancestor {
//Method to check if node p is in tree	: O(n)
static int i = 1;
boolean	isNodeinTree(Node root,Node p){
	if(root==null)
		return false;
	if(root.equals(p))
		return true;
	return isNodeinTree(root.left,p) || isNodeinTree(root.right,p);
	}

Node findFirstCommonAncesterHelper(Node root,Node p,Node q){
	//O(n/2), O(n/4), O(n/8) ....
	boolean is_p_on_left = isNodeinTree(root.left,p);
	boolean is_q_on_left = isNodeinTree(root.left,q);
	if(is_p_on_left!=is_q_on_left)
		return root;
	// iterates on child trees depending on boolean value
	Node child = is_p_on_left ? root.left:root.right;
	if(child.equals(q)|| child.equals(q))
		return root;
	return findFirstCommonAncesterHelper(child, p, q);
	
}

Node findFirstCommonAncester(Node root,Node p,Node q){
	//Base case and check if p & q are in tree
	//2 *O(n)
	if(!isNodeinTree(root,p) || !isNodeinTree(root,q)){ 
		return null;
	}
	// Checks if p or q is equal to root node
	if(root.equals(p)||root.equals(q))
		return root;
	return findFirstCommonAncesterHelper(root, p, q);
}
	
	public static void main(String[] args) {
		BalanceBinaryTree Btree1 = new BalanceBinaryTree();
		Btree1.insert(50);
		Btree1.insert(30);
		Btree1.insert(70);
		Btree1.insert(10);
		Btree1.insert(40);
		Btree1.insert(60);
		Btree1.insert(90);
		Btree1.insert(5);
		Btree1.insert(6);
		Btree1.insert(9);
		Btree1.insert(12);
		firstcommonancestor fca = new firstcommonancestor();
		Node n =fca.findFirstCommonAncester(Btree1.root, new Node(50), new Node(60));
		System.out.println(n.id);
	}
}
