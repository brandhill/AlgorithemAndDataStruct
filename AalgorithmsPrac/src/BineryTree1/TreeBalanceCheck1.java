package BineryTree1;

public class TreeBalanceCheck1 {
	
	//private boolean check = true;
	boolean isBalance(Node node) {
		int i = isBalance1(node);
		if(i!=-1)
			return true;
		else
			return false;
	}
	
	private int isBalance1(Node node) {
		if(node==null)
			return 0;
		/*if(check==false)
			return -1;*/
		int left = isBalance1(node.left);
		if(left==-1)
			return -1;
		int right = isBalance1(node.right);
		if(right==-1)
			return -1;
		
		if(Math.abs(left-right)>1)
			return -1;
		else
			return Math.max(left, right)+1;
	}
}
