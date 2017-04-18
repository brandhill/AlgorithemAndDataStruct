package CareerCup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.Node;

// https://www.careercup.com/question?id=5762018378252288

public class ConvertLevelOrderNodesToLinkedList {
	
	static List<Head> ConvertoLinkedList(Node root) {
		if(root==null)
			return null;
		List<Head> list = new ArrayList<Head>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			queue = createLinkedList(queue,list);
		}
		return list;
	}
	
	static Queue<Node> createLinkedList(Queue<Node> queue, List<Head> list) {
		Queue<Node> temp = new LinkedList<Node>();
		Head head = null;
		Head node = null;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			Head h = new Head(n.id);
			if(head==null) {
				head = h;
				node = h;
			} else {
				node.next = h;
				node = node.next;
			}
			
			if(n.left!=null) {
				temp.add(n.left);
			}
			if(n.right!=null) {
				temp.add(n.right);
			}
		}
		list.add(head);
		return temp;
	}
	
	public static void main(String[] args) {
		Node n = new Node(2);
		Node n1 = new Node(3);
		Node n2 = new Node(4);
		Node n3 = new Node(5);
		Node n4 = new Node(1);
		Node n5 = new Node(2);
		Node n6 = new Node(3);
		Node n7 = new Node(1);
		Node n8 = new Node(6);
		Node n9 = new Node(7);
		Node n10 = new Node(8);
		n.left = n1;
		n.right = n2;
		n1.left = n3;
		n3.left = n4;
		n4.right = n5;
		n5.left = n6;
		n2.left = n7;
		n7.left = n8;
		n8.right = n9;
		n9.left = n10;
		List<Head> list = ConvertoLinkedList(n);
		
		for(Head h: list) {
			while(h!=null) {
				System.out.print(h.val+"->");
				h = h.next;
			}
			System.out.println();
		}
	}
}

class Head {
	int val;
	Head next;
	Head(int val) {
		this.val = val;
	}
}
