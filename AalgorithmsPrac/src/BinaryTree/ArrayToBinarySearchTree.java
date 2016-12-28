package BinaryTree;

public class ArrayToBinarySearchTree {

Node ArrayToBinary(int[] array,int min,int max){
	Node n = null;
	if(min>max){
		return n;
	}
	int index =  (max+min)/2;
	n = new Node(array[index]);
	System.out.println(n.id);
	n.left = ArrayToBinary(array,min,index-1);
	n.right = ArrayToBinary(array,index+1,max);
	return n;
}

	public static void main(String[] args) {
	
		int[] array = {1,2,3,4,5,6,7,8};
		ArrayToBinarySearchTree AtoB = new ArrayToBinarySearchTree();
		System.out.println(array.length);
		Node n = AtoB.ArrayToBinary(array, 0, array.length-1);
		BalanceBinaryTree Btree = new BalanceBinaryTree();
		Btree.inOrderTraversal(n);
	}
}
