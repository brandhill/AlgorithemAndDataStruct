package BinaryTree;

public class CheckIfSubBinaryTree {
	int count = 1;
	Node checkifrootexists(Node mainroot,Node root){
		System.out.println(count++);
		if(root==null || mainroot==null)
			return null;
		if(mainroot.equals(root))
			return mainroot;
		Node x = checkifrootexists(mainroot.left,root);
		if(x!=null)
			return x;
		Node y = checkifrootexists(mainroot.right,root);
		if(y!=null)
			return y;
		return null;
	}
	
 	boolean checkIfSubBinaryTree(Node mainroot,Node root){
		boolean ans;
 		Node root1 = checkifrootexists(mainroot,root);
		
		if(root1==null)
			return false;
		
		return checkIfSubBinaryTreeHelper(root1,root);
	}
	
	boolean checkIfSubBinaryTreeHelper(Node root1,Node root){
		
		if(root==null)
			return true;
		if(root1==null && root!=null)
			return false;
		if(!root1.equals(root))
			return false;
		
		return checkIfSubBinaryTreeHelper(root1.left,root.left) && checkIfSubBinaryTreeHelper(root1.right,root.right) ;
	}

	
	public static void main(String[] args) {
		BalanceBinaryTree Btree = new BalanceBinaryTree();
		Btree.insert(50);
		Btree.insert(30);
		Btree.insert(70);
		Btree.insert(10);
		Btree.insert(40);
		Btree.insert(60);
		Btree.insert(90);
		Btree.insert(80);
		Btree.insert(25);
		Btree.insert(1);
		BalanceBinaryTree Btree1 = new BalanceBinaryTree();
		//Btree1.insert(50);
		Btree1.insert(30);
		//Btree1.insert(70);
		Btree1.insert(10);
		Btree1.insert(40);
		Btree1.insert(80);
		Btree1.insert(25);
		Btree1.insert(1);
		Btree1.insert(2);
		//Btree1.insert(60);
		//Btree1.insert(90);
		CheckIfSubBinaryTree c = new CheckIfSubBinaryTree();
		//Node s = c.checkifrootexists(Btree.root,new Node(40));
		System.out.println(c.checkIfSubBinaryTree(Btree.root, Btree1.root));
	}
}
