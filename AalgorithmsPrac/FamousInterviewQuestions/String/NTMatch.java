package String;

import java.util.Arrays;
// Incomplete
public class NTMatch {
	 public boolean match(char str[]){
	        int kmp[] = buildKMP(str);
	        
	        return false;
	    }
	    
	    private int[] buildKMP(char str[]){

	        int result[] = new int[str.length];
	        int n = 0;
	        int i = 1;
	        result[0] = 0;
	        while(i<str.length) {
	        	if(str[i]==str[n]) {
	        		n++;
	        		result[i]=n;
	        		i++;
	        	}
	        	else {
	        		if(n!=0) {
	        			n = result[n-1];
	        		}
	        		else {
	        			result[i] = 0;
	        			i++;
	        		}
	        	}
	        }
	        
	        return result;
	    }
	    
	    public static void main(String args[]){
	        NTMatch ntMatch = new NTMatch();
	        //System.out.println(ntMatch.match("bababababa".toCharArray()));
	        System.out.println(ntMatch.match("abcdabcdabcdabcc".toCharArray()));
	    }
}
