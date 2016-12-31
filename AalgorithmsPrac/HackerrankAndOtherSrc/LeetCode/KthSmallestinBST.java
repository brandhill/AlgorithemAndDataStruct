package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class KthSmallestinBST {
	int count = 0;
	//int small = 0;
	public void KthSmallest(TreeNode node, int k){
		if(node==null)
			return;
		KthSmallest(node.left,k);
		//if(count!=k)
			//count = count+1;
		//System.out.println(count+" "+node.val);
		if(++count==k){
			System.out.println(node.val);
			return;
		}
			
		KthSmallest(node.right,k);
	}
	
	
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	TreeNode root;
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
		int[] values = {6,3,8,2,4,7,9,1};
		KthSmallestinBST Kth = new KthSmallestinBST();
		for(int i=0;i<values.length;i++){
			
			Kth.insert(values[i]);
		}
		//Map<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
		//System.out.println(HB3.rob(HB3.root,map));
		Kth.KthSmallest(Kth.root, 4);
		//System.out.println(Kth.small);
	}
}
