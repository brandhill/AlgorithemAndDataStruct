package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BinarytreeToLinkedList {
//LinkedList<Node> i = new LinkedList<Node>();
List<LinkedList<Node>> list =  new ArrayList<LinkedList<Node>>(); 
	
	void BinaryToLinkedList(Node node,int depth){
		LinkedList<Node> i = new LinkedList<Node>();
		if(node==null || depth<1)
			return;
		if(list.isEmpty()){
			i.add(node);
			list.add(i);
		}
		else{
			ListIterator<Node> it = list.get(list.size()-1).listIterator();
			while(it.hasNext()){
				Node n = it.next();
				if(n.left!=null)
				i.add(n.left);
				if(n.right!=null)
				i.add(n.right);
			}
			if(!i.isEmpty())
				list.add(i);
		}
		BinaryToLinkedList(list.get(list.size()-1).peek(),depth-1);
	}
	
	public static void main(String[] args) {
		BalanceBinaryTree Btree1 = new BalanceBinaryTree();
		Btree1.insert(50);
		Btree1.insert(30);
		Btree1.insert(70);
		Btree1.insert(10);
		Btree1.insert(40);
		Btree1.insert(60);
		Btree1.insert(90);
		Btree1.insert(10);
		Btree1.insert(20);
		Btree1.insert(30);
		Btree1.insert(40);
		Btree1.insert(50);
		BinarytreeToLinkedList BL = new BinarytreeToLinkedList();
		BL.BinaryToLinkedList(Btree1.root,4);
		LinkedList<Node> i  = BL.list.get(3);
		ListIterator<Node> it = i.listIterator();
		while(it.hasNext()){
			System.out.println(it.next().id);
		}
	}
}
