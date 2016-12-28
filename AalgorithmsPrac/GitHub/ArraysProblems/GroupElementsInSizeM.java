package ArraysProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupElementsInSizeM {
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean group(int input[],int m){
    	
    	// Use if group size is exactly m
    	/*if(input.length%m!=0) {
    		return false;
    	}*/
    	
    	Map<Integer,Pair> lookUp = new HashMap<Integer,Pair>();
    	List<Pair> values = new ArrayList<Pair>();
    	for(int i = 0; i < input.length; i++) {
    		if(!lookUp.containsKey(input[i])) {
    			Pair pair = new Pair(input[i]);
    			pair.count++;
    			values.add(pair);
    			lookUp.put(input[i],pair);
    		}
    		else {
    			lookUp.get(input[i]).count++;
    		}
    	}
    	
    	Collections.sort(values, new Comparator() {

			public int compare(Object o1, Object o2) {
				Pair p1 = (Pair) o1;
				Pair p2 = (Pair) o2;
				if(p1.count<p2.count) {
					return 1;
				}
				else if(p1.count>p2.count) {
					return -1;
				}
				return 0;
			}
    		
    	});
    	// Use if group size is exactly of size m
    	//if((values.get(0).count*m)>input.length)
    		//return false;
    	
    	Arrays.fill(input, -1);
    	int index = 0;
    	for(int i = 0; i < input.length; i++) {
    		if(input[i]==-1 && index < values.size()) {
    			Pair p = values.get(index);
    			int num = p.number;
    			int count = p.count;
    			//System.out.println(num+" "+count);
    			for(int j = i; j < input.length && count>0;) {
    				//System.out.println(j+" "+num);
    				input[j] = num;
    				j += m;
    				count--;
    				if(j>=input.length && count >0) {
    					return false;
    				}
    			}
    			index++;
    		}
    		//System.out.print(input[i]+" ");
    	}
    	
    	/*for(int i = 0; i < input.length; i++) {
    		//System.out.println(groups[i]);
    		if(input[i]==-1) {
    			return false;
    		}
    	}*/
    	
		return true; 
    	
    }
    
    public static void main(String args[]){
        //int input[] = {2,1,5,1,3,1,3,3,4}; 
        int input[] = {2,1,1,3,1,4,4,4,5}; // M = 2
        //int input[] = {1,2,3,8,8,8,7,1};
        GroupElementsInSizeM gps = new GroupElementsInSizeM();
        boolean r = gps.group(input, 3);
        System.out.println(r);
        for(int i=0; i < input.length; i++){
            System.out.print(input[i]+" ");
        }
    }
}

class Pair {
	int number;
	int count;
	Pair(int number) {
		this.number = number;
	}
}


/* 
 * for(int i = 0; i < input.length; i++) {
    		//System.out.println(groups[i]);
    		if(input[i]==-1) {
    			return false;
    		}
    	}
    	
    	
    	//System.out.println(values);
    	int[] groups = new int[values.get(0).count];
    	
    	for(int i = 0; i < values.size(); i++) {
    		Pair p = values.get(i);
    		//System.out.println(p.number+" "+p.count);
    		int n = 0;
    		//int m = 0
    		for(int j = 1; j <= p.count;) {
    			//input[]
    			if(groups[n]<m) {
    				groups[n] += 1;
    			//	System.out.println(n+" "+groups[n]);
    				//input[]
    				j++;
    			}
    			n++;
    		}
    	}
    	
    	for(int i = 0; i < groups.length; i++) {
    		//System.out.println(groups[i]);
    		if(groups[i]!=m) {
    			return false;
    		}
    	}*/
