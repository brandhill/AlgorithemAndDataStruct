package VeryImportantQuestions;

import java.util.HashMap;
import java.util.Map;

public class DistinctNodesInTreePath {
	
	static int FindMaxDistinctNodesInPath(Node3 root) {
		if(root==null)
			return 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		return getMax(root,map);
	}
	
	static int getMax(Node3 root, Map<Integer,Integer> map) {
		if(root==null)
			return map.size();
		
		int l = 0;
		int r = 0;
		if(map.containsKey(root.value)) {
			map.put(root.value, map.get(root.value)+1);
		}
		else {
			map.put(root.value, 1);
		}
		
		l = getMax(root.left,map);
//		if(root.left!=null) {
//			map.put(root.left.value,map.get(root.left.value)-1);
//			if(map.get(root.left.value)==0) {
//				map.remove(root.left.value);
//			}
//		
//		}
		r = getMax(root.right,map);
		map.put(root.value,map.get(root.value)-1);
		if(map.get(root.value)==0) {
			map.remove(root.value);
		}
		return Math.max(l, r);
	}
	
	public static void main(String[] args) {
		Node3 n = new Node3(3);
		Node3 n1 = new Node3(5);
		Node3 n2 = new Node3(6);
		Node3 n3 = new Node3(1);
		Node3 n4 = new Node3(4);
		Node3 n5 = new Node3(6);
		Node3 n6= new Node3(3);
		Node3 n7 = new Node3(4);
		Node3 n8 = new Node3(-1);
		Node3 n9 = new Node3(2);
		n.left = n1;
		n.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n7;
		n5.left = n8;
//		n6.right = n9;
		System.out.println(FindMaxDistinctNodesInPath(n));
	}
}


//			3
//		5	    6
//	  1  4     6
//	3   4		-1
//   2
//