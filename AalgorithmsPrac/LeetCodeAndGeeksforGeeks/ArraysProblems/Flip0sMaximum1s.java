package ArraysProblems;

import java.util.ArrayList;
import java.util.List;

public class Flip0sMaximum1s {
    public int flip0sToMaximizeConsecutive1s(int[] input, int flipsAllowed) {
    	
    	int wL = 0;
    	int wR = 0;
    	int bestL = 0;
    	int bestR = 0;
    	int cZero = 0;
    	int bandWidth = 0;
    	//System.out.println("Window "+bestL+" "+bestR);
    	while (wR < input.length) {
    		if(cZero<=flipsAllowed) {
    			if(input[wR]==0) {
    				cZero++;
    				//System.out.println(wR+" has Zero - "+cZero);
    			}
    			wR++;
    		}
    		
    		if(cZero>flipsAllowed) {
    			if(input[wL]==0) {
    				cZero--;
    				//System.out.println(wL+" removed has 0 - "+cZero);
    			}
    			else {
    				//System.out.println(wL+" removed has 1 - "+cZero);
    			}
    			wL++;
    		}
    		
    		if(wR - wL > bandWidth && wR < input.length) {
    			bandWidth = wR - wL;
    			bestL = wL;
    			bestR = wR;
    			//System.out.println("Window "+bestL+" "+bestR);
    		}
    	}
    	
    	for(int i = bestL; i <=bestR; i++) {
    		if(input[i]==0){
    			System.out.print(i+" ");
    		}
    	}
    	System.out.println();
        return (bestR-bestL+1);
    }

    public static void main(String args[]) {
        int input[] = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        Flip0sMaximum1s fm = new Flip0sMaximum1s();
        System.out.print(fm.flip0sToMaximizeConsecutive1s(input, 2));
    }
	
}


