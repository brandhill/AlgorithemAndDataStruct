package CareerCup;

import BinaryTree.Node;

// https://www.careercup.com/question?id=5713295928459264

public class CheckIfGivenNumberExitsInPath {
	
	static boolean checkIfPathExist1(Node node, int number) {
		if(node==null)
			return false;
		int temp = number;
		int divideBy = 1;
		while(temp>9) {
			divideBy *= 10;
			temp = temp/10;
		}
		return checkIfPathExist1(node, number, number, divideBy, divideBy);
	}
	
	static boolean checkIfPathExist1(Node node, int number, int actualNumber, int divideBy, int actualdivideBy) {
		if(divideBy==0)
			return true;
		if(node==null)
			return false;
		
		if(number/divideBy == node.id) {
			number = number%divideBy;
			divideBy = divideBy/10;
		} else {
			number = actualNumber;
			divideBy = actualdivideBy;
			if(number/divideBy == node.id) {
				number = number%divideBy;
				divideBy = divideBy/10;
			}
		}
		
		return checkIfPathExist1(node.left, number, actualNumber, divideBy, actualdivideBy) || 
				checkIfPathExist1(node.right, number, actualNumber, divideBy, actualdivideBy);
	}
	
	static boolean checkIfPathExist(Node node, int number) {
		if(node==null)
			return false;
		String s = String.valueOf(number);
		System.out.println(s);
		return checkIfPathExistHelper(node, s, 0);
	}
	
	static private boolean checkIfPathExistHelper(Node node, String s, int index) {
		if(index==s.length())
			return true;
		if(node==null)
			return false;
		
		int n = Integer.valueOf(s.charAt(index)-'0');
		System.out.println(n);
		if(n==node.id) {
			index += 1;
		} else {
			index = 0;
			n = Integer.valueOf(s.charAt(index));
			if(n==node.id)
				index += 1;
		}
		return checkIfPathExistHelper(node.left, s, index) 
				|| checkIfPathExistHelper(node.right, s, index);
	}
	
	
	
	
	public static void main(String[] args) {
		Node n1 = new Node(7);
		Node n2 = new Node(3);
		Node n3 = new Node(15);
		n1.left = n2;
		n1.right = n3;
		Node n4 = new Node(1);
		Node n5 = new Node(5);
		n2.left = n4;
		n2.right = n5;
		Node n6 = new Node(2);
		n4.right = n6;
		Node n7 = new Node(4);
		Node n8 = new Node(6);
		n5.left = n7;
		n5.right = n8;
		Node n9 = new Node(11);
		Node n10 = new Node(9);
		Node n11 = new Node(13);
		Node n12 = new Node(18);
		n3.left = n9;
		n3.right = n12;
		n9.left = n10;
		n9.right = n11;
		System.out.println(checkIfPathExist(n1,356));
		System.out.println(checkIfPathExist1(n1,356));
	}
}
