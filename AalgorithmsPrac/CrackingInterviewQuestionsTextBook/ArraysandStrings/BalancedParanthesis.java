package ArraysandStrings;

import java.util.ArrayList;
import java.util.List;

public class BalancedParanthesis {
	    public List<String> generateParenthesis(int n) {
	        List<String> result = new ArrayList<String>();
	        helper(n, n, 0, "", result);
	        return result;
	    }
	    
	    private void helper(int left, int right, int value, String tempResult, List<String> result){
	        /*if we run out of both left and right paren*/
	     if(left==0 && right ==0){
	    	 result.add(tempResult);
	    	 return;
	     }
	     if(value>0){
	    	 if(left>0){
	    		 helper(left-1,right,value+1,tempResult+"(",result);
	    	 }
	    	 if(right>0){
	    		 helper(left,right-1,value-1,tempResult+")",result);
	    	 }
	     }
	     else{
	    	 helper(left-1,right,value+1,tempResult+"(",result);
	     }
	    }
	    
	    public static void main(String[] args) {
	    	BalancedParanthesis B = new BalancedParanthesis();
	    	List<String> L = B.generateParenthesis(3);
	    	
	    	System.out.println(L.toString());
		}
}
