package VeryImportantQuestions;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTwoListsAreMerging {
	
	static LinkedList checkIfMerging(LinkedList root1, LinkedList root2) {
		Set<LinkedList> set = new HashSet<LinkedList>();
		if(root1==null || root2==null)
			return null;
		
		while(root1!=null && root2!=null) {
			if(root1==root2)
				return root1;
			if(set.contains(root1))
				return root1;
			if(set.contains(root2))
				return root2;
			set.add(root1);
			set.add(root2);
			root1 = root1.next;
			root2 = root2.next;
		}
		LinkedList root = root1==null?(root2==null?null:root2):root1;
		while(root!=null) {
			if(set.contains(root))
				return root;
			set.add(root);
			root = root.next;
		}
		return null;
	}
	
	public static void main(String[] args) {
		LinkedList n1 = new LinkedList(13);
		LinkedList n2 = new LinkedList(5);
		LinkedList n3 = new LinkedList(3);
		LinkedList n4 = new LinkedList(2);
		LinkedList n5 = new LinkedList(1);
		LinkedList n6 = new LinkedList(-1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		LinkedList a1 = new LinkedList(10);
		LinkedList a2 = new LinkedList(11);
		LinkedList a3 = new LinkedList(12);
		a1.next = a2;
		a2.next = n3;
//		a3.next = n3;
		System.out.println(checkIfMerging(n1,a1));
	}
}

class LinkedList {
	int n;
	LinkedList next;
	
	LinkedList(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return "LinkedList [n=" + n + "]";
	}
	
	
}