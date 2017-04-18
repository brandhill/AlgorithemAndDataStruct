package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTree {
	BalanceBinaryTree Btree;
	public ConstructBinaryTree(){
		Btree = new BalanceBinaryTree();
	}
	int count =1;
	public Node PreInorders(List<Node> preorder,List<Node> inorder, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd){
		Node n = null;
		if(inorderStart > inorderEnd && preorderStart > preorderEnd){
			return n;
		}
		n = preorder.get(preorderStart);
		int index = inorder.indexOf(n);
//		System.out.println(n.id);
		n.left = PreInorders(preorder,inorder,inorderStart,index-1,preorderStart+1,preorderStart+(index-inorderStart));
		n.right = PreInorders(preorder,inorder,index+1,inorderEnd,preorderStart+(index-inorderStart)+1,preorderEnd);
		return n;
	}
	
	Node PostInorders(List<Node> postorder,List<Node> inorder, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd){
		Node n = null;
		if(inorderStart > inorderEnd && preorderStart > preorderEnd){
			return n;
		}
		n = postorder.get(preorderEnd);
		int index = inorder.indexOf(n);
		System.out.println(n.id);
		n.left = PostInorders(postorder,inorder,inorderStart,index-1,preorderStart,preorderEnd-(inorderEnd-index)-1);
		n.right = PostInorders(postorder,inorder,index+1,inorderEnd,preorderEnd-(inorderEnd-index),preorderEnd-1);
		
		return n;
	}
	
	public static void main(String[] args) {
		ConstructBinaryTree CBT = new ConstructBinaryTree();
		List<Node> preorder = new ArrayList<Node>();
		preorder.add(new Node(50));
		preorder.add(new Node(30));
		preorder.add(new Node(10));
		preorder.add(new Node(40));
		preorder.add(new Node(70));
		preorder.add(new Node(60));
		preorder.add(new Node(90));
		List<Node> inorder = new ArrayList<Node>();
		inorder.add(new Node(10));
		inorder.add(new Node(30));
		inorder.add(new Node(40));
		inorder.add(new Node(50));
		inorder.add(new Node(60));
		inorder.add(new Node(70));
		inorder.add(new Node(90));
		List<Node> postorder = new ArrayList<Node>();
		postorder.add(new Node(10));
		postorder.add(new Node(40));
		postorder.add(new Node(30));
		postorder.add(new Node(60));
		postorder.add(new Node(90));
		postorder.add(new Node(70));
		postorder.add(new Node(50));
		
		//System.out.println(inorder.subList(0, 4).get(3).id);
		Node root = CBT.PostInorders(postorder, inorder, 0 , preorder.size() - 1, 0 ,preorder.size() - 1);
		System.out.println(CBT.Btree.isTreeBalances());
	}
}
