package BineryTree1;

public class HasPathSum9 {
	
	static void HasPathSum(Node node, int value) {
		if(node == null)
			return;
		HasPathSumHelper(node,value,"",0);
		HasPathSum(node.left,value);
		HasPathSum(node.right,value);
	}
	
	static void HasPathSumHelper(Node node,int value,String s,int sum) {
		if(node == null || sum > value)
			return;
		sum = sum +node.id;
		s = s+node.id+"-";
		if(sum==value)
			System.out.println(s);
		HasPathSumHelper(node.left,value,s,sum);
		HasPathSumHelper(node.right,value,s,sum);
	}
	
}
