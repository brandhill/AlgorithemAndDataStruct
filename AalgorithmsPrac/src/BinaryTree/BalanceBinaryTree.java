package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BalanceBinaryTree {
/**
	 * 
	 */
Node root;
Queue<Node> queue = new LinkedList<Node>();
public BalanceBinaryTree() {
root = null;	
}

boolean isEmpty(){
	if(root==null)
		return true;
	return false;
}

void insert(int id){
	Node point = new Node(id);
	
	if(isEmpty()){
		root = point;
		queue.add(point);
		return;
	}
	else{
		Node current = queue.peek();
		if(current.left==null)
		{
			current.left = point;
		}
		else if(current.right==null){
			current.right = point;
			queue.poll();
		}
		queue.add(point);	
	}
}

void levelOrderTraversal(){
	Queue<Node> q = new LinkedList<Node>();
	q.add(root);
	Node point = null;
	while(!q.isEmpty()){
		point = q.poll();
		System.out.print(point.id+" ");
		
		if(point.left!=null)
		q.add(point.left);
		if(point.right!=null)
		q.add(point.right);
	}
}
void inOrderTraversal(){
	inOrderTraversal(root);
}
List<Integer> inorder = new ArrayList<Integer>();
 public void inOrderTraversal(Node node){
	if(node!=null){
	inOrderTraversal(node.left);
	//inorder.add(node.id);
	System.out.print(node.id+" ");
	inOrderTraversal(node.right);
	}
}
private Integer i = null;
private boolean isBinaryTree = true;
void isBinaryTree(){
	isBinaryTree(root);
	if(isBinaryTree)
		System.out.println("Binary tree is Binary Search Tree");
	else
		System.out.println("Binary tree is not Binary Search Tree");
}
private void isBinaryTree(Node node){
	if(node!=null && isBinaryTree){
	isBinaryTree(node.left);
	/*Code to check if previous value is less than next value in InOrderTraversal */
	if(i!=null && i>node.id){
		isBinaryTree = false;
	}
		i = new Integer(node.id);	
	
	/*End of check code */
	
	isBinaryTree(node.right);
	}
} 

//check if tree is binary search tree using min and max values of tree
boolean isBinaryTree1(){
	return isBinaryTree1(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
}

boolean isBinaryTree1(Node node,int min,int max){
	if(node!=null){
		System.out.println(node.id+" "+min+" "+max+" ");
		if(node.id<=min || node.id > max){
			return false;
		}
		if(!isBinaryTree1(node.left,min,node.id)|| !isBinaryTree1(node.right,node.id,max))
			return false;
	}
	return true;
}
 
void preOrderTraversal(){
	preOrderTraversal(root);
}

void preOrderTraversal(Node node){
	if(node!=null){
	System.out.print(node.id+" ");
	preOrderTraversal(node.left);
	preOrderTraversal(node.right);
	}
}

Node GetSuccessor(int id){
	Node current = findNode(id);
	Node successor = null;
	if(current.right!=null){
		successor = current.right;
		while(successor.left!=null){
			successor = successor.left;
		}
	}
	else{
	Node ancester=root;
	while(ancester.id!= id){
		if(id<ancester.id){
			successor = ancester;
			ancester = ancester.left;
			}
		else
			ancester = ancester.right;
		}
	}
	return successor;
}

//find node for binary search tree
Node findNode(int id){
	Node N = root;
	while (true) {
		if (N.id == id) {
			return N;
		} else if (id < N.id) {
			N = N.left;
		} else if (id > N.id) {
			N = N.right;
		}
		if (N == null) {
			return null;
		}
	}
}

//hasPathSum() for binare search tree
boolean haspathSum = false; 
boolean hasPathSum(int sum){
	hasPathSum(0,root,sum);
	return haspathSum;
}

private void hasPathSum(int sumvalue,Node node,int sum){
	if(node!=null && !haspathSum){
		sumvalue = sumvalue+node.id;
		hasPathSum(sumvalue,node.left,sum);
		hasPathSum(sumvalue,node.right,sum);
		if(node.left==null && node.right==null){
			System.out.println(sumvalue);
			if(sumvalue==sum)
			{
				haspathSum = true;
			}
		}
	}
}

void printPaths(){
	printPaths("",root);
}

private void printPaths(String path,Node node){
	if(node!=null){
	path = path+"-"+node.id;
	printPaths(path,node.left);
	printPaths(path,node.right);
	if(node.left==null && node.right==null)
		System.out.println(path);	
	}
}

//mirror the binary tree
void mirror(){
	mirror(root);
}

private void mirror(Node node){
	if(node!=null){
		mirror(node.left);
		mirror(node.right);	
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		
	}
	
}
// Checks if two binary trees are same
boolean checkBinaryTree = true;
boolean isSameTrees(BalanceBinaryTree B1,BalanceBinaryTree B2){
	isSameTrees(B1.root,B2.root);
	return checkBinaryTree;
}

void isSameTrees(Node node1,Node node2){
	if(node1!=null && node2!=null && checkBinaryTree){
	if(!node1.equals(node2))
		checkBinaryTree = false;
	isSameTrees(node1.left,node2.left);
	isSameTrees(node1.right,node2.right);
	}
	else if((node1!=null && node2==null) || (node1==null && node2!=null)){
		checkBinaryTree = false;
	}
}

boolean isSameTrees1(BalanceBinaryTree B1,BalanceBinaryTree B2){
	if (B1.root != null && B2.root != null) {
		return isSameTrees1(B1.root,B2.root);
	}
	return false;
}

boolean isSameTrees1(Node node1,Node node2){
	boolean flag = false;
	System.out.println(node1.id+" "+node2.id);
	if(node1.equals(node2)) {
		flag = true;
		if (node1.left != null && node2.left != null){
			flag = isSameTrees1(node1.left,node2.left);
		} 
		if (node1.right != null && node2.right != null && flag){
			flag = isSameTrees1(node1.right,node2.right);
		}
	}
	return flag;
}
/*Node delete(int id){
	
	delete(null,root,id);
	return root;
	
}

void delete(Node parent,Node node,int id){
	if(node==null)
		return;
	
	if(node.id==id){
		lastNode.left = node.left;
		lastNode.right = node.right;
		
		if(parent.left.id == node.id){
			
		}
		else{
			
		}
	}
	
	delete(node,node.left,id);
	delete(node,node.right,id);
}
*/

//Check if tree is balanced or not
private boolean isBalance = true;
boolean isTreeBalances(){
	 height(root);
	 return isBalance;
}
int height(Node node){

	if(node==null)
		return -1;
	System.out.println(node.id);
	int left = height(node.left)+1;
	int right = height(node.right)+1;
		if(Math.abs(left-right)>1)
			isBalance = false;	 
	return Math.max(left, right);
}

public static void main(String[] args) {
	BalanceBinaryTree Btree = new BalanceBinaryTree();
	Btree.insert(50);
	Btree.insert(30);
	Btree.insert(70);
	Btree.insert(10);
	Btree.insert(40);
	Btree.insert(80);
	Btree.insert(90);
	Btree.levelOrderTraversal();
	System.out.println();
	System.out.println("Level");
	Btree.mirror();
	Btree.levelOrderTraversal();
	System.out.println();
	BalanceBinaryTree Btree1 = new BalanceBinaryTree();
	//Btree1.insert(50);
	Btree1.insert(70);
	//Btree1.insert(70);
	Btree1.insert(80);
	Btree1.insert(90);
	//Btree1.insert(60);
	//Btree1.insert(90);
	//Btree1.inOrderTraversal();
	System.out.println("In Order");
	Btree.inOrderTraversal();
	System.out.println();
	System.out.println("In Order1");
	Btree1.inOrderTraversal();
	System.out.println();
	System.out.println("IsBinaryTree: ");
	System.out.println(Btree.inorder.toString());
	//alanceBinaryTree B1 = Btree;
	//System.out.println(Btree.GetSuccessor(20).id);
	//System.out.println(Btree.hasPathSum(90));
	//Btree.printPaths();
	//Btree.mirror();
	//System.out.println("In Order");
	//Btree.inOrderTraversal();
	//System.out.println();
	System.out.println(Btree.isSameTrees(Btree1, Btree));
	System.out.println("---");
    boolean x = Btree.isBinaryTree1();
    System.out.println("----");
	System.out.println(x);
	System.out.println("----");
	System.out.println(Btree.isTreeBalances());
	}

}
