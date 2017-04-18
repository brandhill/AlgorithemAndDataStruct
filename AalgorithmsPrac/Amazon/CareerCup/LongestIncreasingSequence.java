package CareerCup;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.Node;

// https://www.careercup.com/question?id=6285363834257408

public class LongestIncreasingSequence {
	
	static List<Integer> getMaxLength(Node root) {
		Result result = new Result();
		List<Integer> list = new ArrayList<Integer>();
		getMaxLengthHelper(root,null, 0, result, list);
		return result.list.subList(1,result.list.size());
	}
	
	static void getMaxLengthHelper(Node node,Node parent,int count, Result result, List<Integer> list) {
		if(node==null)
			return;
		
		if(parent!=null && node.id>parent.id) {
			count += 1;
		}
		else {
			count = 0;
			list = new ArrayList<Integer>();
		}
		list.add(node.id);
		if(result.maxLen<count) {
			System.out.println(node.id);
			result.maxLen = count;
			result.list.clear();
			result.list.addAll(list);
		}
		getMaxLengthHelper(node.left,node,count, result, list);
		getMaxLengthHelper(node.right,node,count, result, list);
		list.remove(list.size()-1);
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
		System.out.println(getMaxLength(n));
	}
}

class Result {
	int maxLen;
	List<Integer> list;
	
	Result() {
		list = new ArrayList<Integer>();
	}
}