package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class HasPathSum {
	//List<List<Node>> list = new ArrayList<List<Node>>();
	void getAllPath(Node node,int sum){
		if(node==null)
			return;
		getPathSum(0,"",node,sum);
		getAllPath(node.left,sum);
		getAllPath(node.right,sum);
	}
	int getPathSum(int i,String path,Node node,int sum){
		if(node==null)
			return 0;
		i =  i+node.id;
		path = path+node.id+",";
		if(i==sum){
			System.out.println(path);
		}
		getPathSum(i,path,node.left,sum);
		getPathSum(i,path,node.right,sum);
		return -1;
	}
	
	public static void main(String[] args) {
		BalanceBinaryTree B = new BalanceBinaryTree();
		B.insert(6);
		B.insert(4);
		B.insert(-2);
		B.insert(-2);
		B.insert(5);
		B.insert(6);
		B.insert(5);
		B.insert(2);
		B.insert(8);
		B.insert(1);
		B.insert(-5);
		HasPathSum s = new HasPathSum();
		s.getAllPath(B.root, 10);
	}
}
