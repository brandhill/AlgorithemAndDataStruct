package CareerCup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.Node;

// https://www.careercup.com/question?id=5710673423106048

public class TopViewOfBinaryTree {
	
	// time - O(n), space - O(n)
	static void printTopView(Node root) {
		if(root==null)
			return;
		Queue<Temp> queue = new LinkedList<Temp>();
		queue.add(new Temp(root,0));
		int min = 0;
		int max = 0;
		List<Temp> list = new ArrayList<Temp>();
		while(!queue.isEmpty()) {
			Temp t = queue.poll();
//			System.out.println(t.node.id);
			if(t.node==root || t.val>max || t.val <min) {
				list.add(t);
				if(t.val>max)
					max = t.val;
				else
					min = t.val;
			}
			if(t.node.left!=null)
				queue.add(new Temp(t.node.left,t.val-1));
			if(t.node.right!=null)
				queue.add(new Temp(t.node.right,t.val+1));
		}
		Collections.sort(list);
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		Node n = new Node(3);
		Node n1 = new Node(5);
		Node n2 = new Node(6);
		Node n3 = new Node(1);
		Node n4 = new Node(4);
		Node n5 = new Node(6);
		Node n6= new Node(3);
		Node n7 = new Node(4);
		Node n8 = new Node(-1);
		Node n9 = new Node(-2);
		n.left = n1;
		n.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n3.left = n6;
		n4.right = n7;
		n7.right = n8;
		n8.right = n9;
		printTopView(n);
	}

}

class Temp implements Comparable<Temp>{
	public Temp(Node node, int val) {
		this.node = node;
		this.val = val;
	}
	Node node;
	int val;
	
	
	@Override
	public String toString() {
		return this.node.id + "";
	}


	@Override
	public int compareTo(Temp o) {
		if(this.val>o.val)
			return 1;
		else
			return -1;
	}
}