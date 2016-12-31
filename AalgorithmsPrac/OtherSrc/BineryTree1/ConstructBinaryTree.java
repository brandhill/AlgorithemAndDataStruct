package BineryTree1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class ConstructBinaryTree {

	static Node PreInorder(List<Node> in,List<Node> pre,int inorderStart,int inorderEnd,int preorderStart,int preorderEnd) {
		if (inorderStart > inorderEnd || preorderStart>preorderEnd){
			return null;
		}
		Node node = pre.get(preorderStart);
		int index = in.indexOf(node);
		node.left = PreInorder(in,pre,inorderStart,index-1,preorderStart+1,preorderStart+(index-inorderStart));
		node.right = PreInorder(in,pre,index+1,inorderEnd,preorderStart+(index-inorderStart)+1,preorderEnd);
		return node;
	}
	
	static Node PostInorder(List<Node> in,List<Node> post, int inorderStart,int inorderEnd,int postorderStart,int postorderEnd) {
		if (inorderStart > inorderEnd || postorderStart>postorderStart){
			return null;
		}
		Node node = post.get(postorderEnd);
		int index = in.indexOf(node);
		node.left = PostInorder(in,post,inorderStart,index-1,postorderStart,postorderStart+(index-inorderStart)-1);
		node.right = PostInorder(in,post,index+1,inorderEnd,postorderStart+(index-inorderStart),postorderEnd-1);
		return node;
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
		//inorder.add(new Node(3));
		//inorder.add(new Node(5));
		inorder.add(new Node(10));
		//inorder.add(new Node(20));
		inorder.add(new Node(30));
		inorder.add(new Node(40));
		inorder.add(new Node(50));
		inorder.add(new Node(60));
		inorder.add(new Node(70));
		inorder.add(new Node(90));
		List<Node> postorder = new ArrayList<Node>();
		//postorder.add(new Node(3));
		//postorder.add(new Node(5));
		//postorder.add(new Node(20));
		postorder.add(new Node(10));
		postorder.add(new Node(40));
		postorder.add(new Node(30));
		postorder.add(new Node(60));
		postorder.add(new Node(90));
		postorder.add(new Node(70));
		postorder.add(new Node(50));
		
		//Node node = ConstructBinaryTree.PreInorder(inorder, preorder, 0, inorder.size()-1,0, preorder.size()-1);
		Node node = ConstructBinaryTree.PostInorder(inorder, postorder, 0, inorder.size()-1,0, postorder.size()-1);
		TreeBalanceCheck1 tree = new TreeBalanceCheck1();
		System.out.println(tree.isBalance(node));
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.println(n.id);
			if(n.left!=null) {
				queue.add(n.left);
			}
			if(n.right!=null) {
				queue.add(n.right);
			}
			
		}
		
		System.out.println("------");
		//Question 4
		List<LinkedList<Node>> list = BinaryTreeToLinkedList4.ConvertToLinkedLists(node);
		
		//Question 7
		//Node n = FirstCommonAncestor7.FirstCommonAncestor(node, new Node(20), new Node(40));
		//System.out.println(n.id);
		
		//Question 8
		List<Node> preorder1 = new ArrayList<Node>();
		
		preorder1.add(new Node(4));
		preorder1.add(new Node(2));
		preorder1.add(new Node(50));
		preorder1.add(new Node(30));
		preorder1.add(new Node(10));
		preorder1.add(new Node(5));
		preorder1.add(new Node(40));
		preorder1.add(new Node(70));
		preorder1.add(new Node(60));
		preorder1.add(new Node(90));
		preorder1.add(new Node(1));
		List<Node> inorder1 = new ArrayList<Node>();
		inorder1.add(new Node(5));
		inorder1.add(new Node(10));
		inorder1.add(new Node(30));
		inorder1.add(new Node(40));
		inorder1.add(new Node(50));
		inorder1.add(new Node(60));
		inorder1.add(new Node(70));
		inorder1.add(new Node(90));
		inorder1.add(new Node(2));
		inorder1.add(new Node(4));
		inorder1.add(new Node(1));
		Node node1 = ConstructBinaryTree.PreInorder(inorder1, preorder1, 0, inorder1.size()-1,0, preorder1.size()-1);
		boolean ans = CheckIfSubBinaryTree8.checkIfSubBinaryTree(node1, node);
		//System.out.println(ans);
		
		//Question 9
		//HasPathSum9.HasPathSum(node,40);
		
	}
}
