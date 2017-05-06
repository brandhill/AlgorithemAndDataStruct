package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeToMemoryAndRetriveBack {
	
	static List<Node1> ConvertTreeToMemory(Node3 node) {
		Queue<Node3> queue = new LinkedList<Node3>();
		List<Node1> list = new ArrayList<Node1>();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node3 n = queue.poll();
			Node1 n1 = new Node1(n.value);
			if(n.left!=null) {
				queue.add(n.left);
				n1.left = true;
			}
			if(n.right!=null) {
				queue.add(n.right);
				n1.right = true;
			}
			list.add(n1);
		}
		for(Node1 n: list)
			System.out.print(n.value+" ");
		return list;
	}
	
	static Node3 ConvertFromMemoryToTree(List<Node1> list) {
		Node3 n = null;
		Node3 head = null;
		int i = 1;
		int q = 0;
		Queue<Node3> queueNode = new LinkedList<Node3>();
		queueNode.add(new Node3(list.get(q).value));
		System.out.println();
		while(q<list.size()) {
//			System.out.println("Queue "+list.get(q));
//			System.out.println("QueueNode "+queueNode);
//			System.out.println(i);
			Node1 n1 = list.get(q);
			n = queueNode.poll();
			System.out.print(n.value+" : ");
			if(n1.left && i < list.size()) {
				Node1 left1 = list.get(i);
				Node3 left = new Node3(left1.value);
				queueNode.add(left);
				n.left = left;
				System.out.print("left: "+left.value+" ");
				i++;
			}
//			System.out.println("After left"+i);
			
			if(n1.right && i < list.size()) {
				Node1 right1 = list.get(i);
				Node3 right = new Node3(right1.value);
				queueNode.add(right);
				n.right = right;
				System.out.print("right: "+right.value+" ");

				i++;
			}
			
			System.out.println();
//			System.out.println("After right"+i);
			
			if(head == null) {
				head = n;
			}
			q++;
		}
		
		return head;
	}
	
	static Node3 ConvertFromMemoryToTree1(List<Integer> list) {
		
		Node3 node = null;
		if(list.size()==0 || list.get(0)==null)
			return node;
		node = new Node3(list.get(0));
		Queue<Node3> queue = new LinkedList<Node3>();
		queue.offer(node);
		int i = 1;
		while(!queue.isEmpty() && i<list.size()) {
			Node3 n = queue.poll();
			Integer left = list.get(i);
			if(left!=null) {
				n.left = new Node3(left);
				queue.offer(n.left);
			} 
			if(i+1<list.size()) {
				Integer right = list.get(i+1);
				if(right!=null) {
					n.right = new Node3(right);
					queue.offer(n.right);
				}
			}
			i += 2;
		}
		
		return node;
	}
	
	static List<Integer> ConvertTreeToMemory1(Node3 node) {
		List<Integer> list = new ArrayList<Integer>();
		if(node==null)
			return list;
		Queue<Node3> queue = new LinkedList<Node3>();
		queue.offer(node);
		list.add(node.value);
		while(!queue.isEmpty()) {
			Node3 n = queue.poll();
			Integer left = null;
			if(n.left!=null) {
				left = n.left.value;
				queue.offer(n.left);
			}
			list.add(left);
			Integer right = null;
			if(n.right!=null) {
				right = n.right.value;
				queue.offer(n.right);
			}
			list.add(right);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,5,6,1,4,6,3,4,-1};
		Node3 n = new Node3(3);
		Node3 n1 = new Node3(5);
		Node3 n2 = new Node3(6);
		Node3 n3 = new Node3(1);
		Node3 n4 = new Node3(4);
		Node3 n5 = new Node3(6);
		Node3 n6= new Node3(3);
		Node3 n7 = new Node3(4);
		Node3 n8 = new Node3(-1);
		n.left = n1;
		n.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n7;
		n5.left = n8; 
		Node3 N = ConvertFromMemoryToTree(ConvertTreeToMemory(n));
		
		ConvertTreeToMemory(N);
	}
}
// 3 5 6 1 4 6 3 4 -1 

class Node3 {
	int value;
	Node3 left;
	Node3 right;
	Node3(int val) {
		this.value = val;
	}
	@Override
	public String toString() {
		return value+" " ;
	}
	
	
}

class Node1 {
	int value;
	boolean left;
	boolean right;
	Node1(int val) {
		this.value = val;
	}
	
	@Override
	public String toString() {
		return value+" " ;
	}
	
}

//			 3
//		  5	    6
//      1  4      6
//    3   4		-1
//
//