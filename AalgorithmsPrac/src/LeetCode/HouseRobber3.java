package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import BinaryTree.Node;

public class HouseRobber3 {
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	TreeNode root;
	 public int rob(TreeNode node,Map<TreeNode,Integer> map) {
	     
		 if(node==null)
			 return 0;
		 if(map.containsKey(node))
			 return map.get(node);
		 
		 int val =0;
		 
		 if(node.left!=null) {
			 val += rob(node.left.left,map) + rob(node.left.right,map); 
		 }
		 
		 if(node.right!=null) {
			 val += rob(node.right.left,map) + rob(node.right.right,map); 
		 }
		 
		 val = Math.max(val+node.val, rob(node.left,map)+rob(node.right,map));
		 map.put(node, val);
		 return val;
				 
	}
	  
	 
	 public void insert(int id){
		 TreeNode point = new TreeNode(id);
			
			if(queue.isEmpty()){
				root = point;
				queue.add(point);
				return;
			}
			else{
				TreeNode current = queue.peek();
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
	 
	 public static void main(String[] args) {
		int[] values = {3,2,3,0,3,0,1};
		HouseRobber3 HB3 = new HouseRobber3();
		for(int i=0;i<values.length;i++){
			
			HB3.insert(values[i]);
		}
		Map<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
		System.out.println(HB3.rob(HB3.root,map));
	}
	  
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}