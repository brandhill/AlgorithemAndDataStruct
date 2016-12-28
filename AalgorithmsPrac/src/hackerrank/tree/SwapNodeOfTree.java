package hackerrank.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class SwapNodeOfTree {
	
	private static void inOrder(Node root) {
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.id+" ");
		inOrder(root.right);
	}
	
	static void SwapNodes(Node root, List<Integer> list) {
		if(root == null)
			return;
		for(Integer i: list) {
			//System.out.println(i);
			SwapNodeshepler(root,i,1);
			inOrder(root);
			System.out.println();
		}
	}
	
	private static void SwapNodeshepler(Node root,int check, int depth) {
		
		if(root == null) {
			return;
		}
		
		if(check == 1) {
			doSwapping(root);
		}
		else if((depth+1)%check==0) {
			doSwapping(root.left);
			doSwapping(root.right);
		}
		
		SwapNodeshepler(root.left,check,depth+1);
		SwapNodeshepler(root.right,check,depth+1);
	}
	
	private static void doSwapping(Node node) {
		if(node == null)
			return;
		Node left = node.left;
		node.left = node.right;
		node.right = left;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Node root = new Node(1);
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		for ( int i = 0; i < count; i++) {
			Node c = q.poll();
			int l = sc.nextInt();
			int r = sc.nextInt();
			if(l!=-1) {
				c.left = new Node(l);
				q.add(c.left);
			}
			if(r!=-1) {
				c.right = new Node(r);
				q.add(c.right);
			}			
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int loop = sc.nextInt();
		
		for ( int i = 0; i < loop; i++) {
			list.add(sc.nextInt());
		}
		SwapNodeOfTree.SwapNodes(root, list);
		//System.out.println("completed "+set.size());
	}
}

class Node {
	int id;
	Node left;
	Node right;
	Node(int id) {
		this.id = id;
	}
}

//2 9 6 4 1 3 7 5 11 8 10
//2 6 9 4 1 3 7 5 10 8 11
