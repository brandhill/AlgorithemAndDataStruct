package hackerrank.tree;


public class SelfBalancingTree {

	Node root;
	
	SelfBalancingTree(){
		root = null;
	}
	
	void inorder(Node root) {
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.id+" ");
		inorder(root.right);
	}
	
	void preorder(Node root) {
		if(root==null)
			return;
		System.out.print(root.id+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	void InsertNode(int val) throws InterruptedException {
		Node node = new Node(val);
		if(root==null) {
			root = node;
			return;
		}
		Node paren = null;
		Node root1 = root;
		while(root1!=null) {
			paren = root1;
			if(node.id > root1.id) {
				root1 = root1.right;
				if(root1==null) {
					paren.right = node;
				}
			}
			else if(node.id <= root1.id) {
				root1 = root1.left;
				if(root1==null) {
					paren.left = node;
				}
			}
		}
		Balance(root,null);
		
	}
	
	private int Balance(Node root,Node parent) throws InterruptedException {
		
		if(root==null)
			return 0;
		//System.out.println();
		//int i = parent==null?-1:parent.id;
		//System.out.println(root.id+" "+i);
		
		int left = Math.abs(Balance(root.left,root));
		int right  = Math.abs(Balance(root.right,root));
		//Thread.sleep(1000);
		int diff = left - right;
		System.out.println(root.id+" "+diff);
		if (diff >1 || diff <-1) {
			Node n = null;
			if(diff>1) {
				// left case
				//System.out.println("leftcase "+root.id+" "+parent.id);
				n = leftcase(root,parent);
				
			}
			else if (diff < -1) {
				//right case
				//System.out.println("rightcase "+root.id);
				n = rightcase(root,parent);
				
			}
			//Thread.sleep(1000);
			/*if(parent==null) {
				SelfBalancingTree.root = n;
			}*/
			//Thread.sleep(5000);
			left = Math.abs(Balance(root.left,root));
			right  = Math.abs(Balance(root.right,root));
		}
		
		
		return Math.max(left, right)+1;
	}
	
	private Node leftcase(Node node,Node parent) {
		//left right case
		if(node.left.left == null) {
			//System.out.println("leftrightcase");
			Node n = node.left.right;
			n.left = node.left;
			node.left.right = null;
			node.left = n;
			return leftleftcase(node,parent);
			
		}
		//left left case
		else{
			
			return leftleftcase(node,parent);
		}
	}
	
	private Node rightcase(Node node,Node parent) {
		//right left case
		if(node.right.right == null) {
			//System.out.println("rightleftcase");
			Node n = node.right.left;
			n.right = node.right;
			node.right.left = null;
			node.right = n;
			return rightrightcase(node,parent);
		}
		//right right case
		else{
			//System.out.println(node.id+" "+parent.id);
			return rightrightcase(node,parent);
		}
	}
	
	private Node leftleftcase(Node root,Node parent){
		//System.out.println("leftleftcase");
		if(parent==null) {
			root.left.right = root;
			root = root.left;
			root.right.left = null;
			this.root = root;
		}
		else {
		if(parent.left.id == root.id) {
			parent.left = root.left;
			parent.left.right = root;
			root.left = null;
		}
		else {
			parent.right = root.left;
			parent.right.right = root;
			root.left = null;
		}
		
		}
		
		return root;
	}
	
	private Node rightrightcase(Node root,Node parent){
		//System.out.println("righrightcase");
		if(parent == null) {
			root.right.left = root;
			root = root.right;
			root.left.right = null;
			this.root = root;
		}
		else {
			if(parent.right.id == root.id) {
				parent.right = root.right;
				parent.right.left = root;
				root.right = null;
			}
			else {
				parent.left = root.right;
				parent.left.left = root;
				root.right = null;
			}
		}
		
		return root;
	}
	
	public static void main(String[] args) throws InterruptedException {
		//14 25 21 10 23 7 26 12 30 16
		Node n = new Node(14);
		SelfBalancingTree tree = new SelfBalancingTree();
		tree.root = n;
		tree.InsertNode(25);
		tree.InsertNode(21);
		tree.InsertNode(10);
		tree.InsertNode(23);
		tree.InsertNode(7);
		tree.InsertNode(26);
		tree.InsertNode(12);
		tree.InsertNode(30);
		tree.InsertNode(13);
		tree.InsertNode(40);
		tree.InsertNode(50);
		tree.InsertNode(60);
		System.out.println("-----");
		tree.InsertNode(70);
		tree.InsertNode(80);
		tree.InsertNode(90);
		//System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.preorder(tree.root);
		//System.out.println(n);
	}
	
	
}
