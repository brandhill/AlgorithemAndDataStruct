package CareerCup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BinaryTree.Node;

// https://www.careercup.com/question?id=5630160432791552

public class ChangeNodeValuetoSumOfAllChildNodes {
	
	// Time - O(n^2), SPace - O(n^2)
	static void changeNodeValues(Node root) {
		if(root==null)
			return;
		changeNodeValuesHelper(root, new ArrayList<Integer>());
	}
	
	static List<Integer> changeNodeValuesHelper(Node node, List<Integer> list) {
		if(node==null) {
			return list;
		}
		list.addAll(changeNodeValuesHelper(node.left,new ArrayList<Integer>()));
		list.addAll(changeNodeValuesHelper(node.right,new ArrayList<Integer>()));
		int sum = 0;
		for(Integer i:list) {
			if(i<node.id)
				sum += i;
		}
		list.add(node.id);
		System.out.print(node.id);
		node.id = sum;
		System.out.println(" "+sum);
		return list;
	}
	
	// Time - O(n log n), Space - O(n)
	static void changeNodValuesUsingMap(Node root) {
		Map<Integer,Sumtracker> map = new HashMap<Integer,Sumtracker>();
		changeNodValuesUsingMapHelper(root,map); 
	}
	
	private static void changeNodValuesUsingMapHelper(Node node, Map<Integer, Sumtracker> map) {
//		System.out.println(node);
		if(node==null)
			return;
//		System.out.println(node.id);
		for(Integer value: map.keySet()) {
			if(value>node.id) {
				Sumtracker n = map.get(value);
				while(n!=null) {
					n.sum += node.id;
					n = n.next;
				}
			}
		}
		Sumtracker tracker = new Sumtracker();
		tracker.sum = 0;
		if(map.containsKey(node.id)) {
			Sumtracker s = map.get(node.id);
			tracker.next = s;
		}
		map.put(node.id, tracker);
//		System.out.println(map);
		changeNodValuesUsingMapHelper(node.left, map);
		changeNodValuesUsingMapHelper(node.right, map);
		Sumtracker t = map.get(node.id);
		int temp = node.id;
		node.id = t.sum;
		System.out.println(temp+" "+node.id);
		t = t.next;
		if(t==null)
			map.remove(temp);
		else
			map.put(temp, t);
	}

	public static void main(String[] args) {
		int i = (int) Math.sqrt(Integer.MAX_VALUE);
				System.out.println(i);
			
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
		changeNodeValues(n);
		System.out.println("----");
//		changeNodValuesUsingMap(n);
		
	}
}

class Sumtracker {
	int sum;
	Sumtracker next;
	Sumtracker(){
		next = null;
	}
}


//---
//3 0
//2 0
//1 0
//5 6
//3 3
//8 0
//7 0
//6 0
//1 0
//4 1
//2 2