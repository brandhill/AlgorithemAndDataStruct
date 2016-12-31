package BineryTree1;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayToBinarySearchTree3 {

	static Node arrayToTree(Node[] array,int start,int end) {
		if(array.length <= 0)
			return null;
		
		if(start>end)
			return null;
		
		int index = (start+end)/2;
		Node n = array[index];
		n.left = arrayToTree(array,start,index-1);
		n.right = arrayToTree(array,index+1,end);
		
		return n;
	}
	
	public static void main(String[] args) {
		Node[] array = {new Node(1),new Node(2),new Node(3),new Node(4),new Node(5),new Node(6)};
		
		Node node = ArrayToBinarySearchTree3.arrayToTree(array, 0, array.length-1);
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
	}
}
