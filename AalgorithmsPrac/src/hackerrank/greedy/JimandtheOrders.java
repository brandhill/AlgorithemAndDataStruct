package hackerrank.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class JimandtheOrders {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    Map<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>();
	    for (int i = 1; i <= n; i++) {
	    	int t = input.nextInt()+ input.nextInt();
	    	if(map.containsKey(t)) {
	    		map.get(t).add(i);
	    	}
	    	else {
	    		List<Integer> list = new ArrayList<Integer>();
	    		list.add(i);
	    		map.put(t,list);
	    	}
	    }
	    
	    for(Integer t: map.keySet()) {
	    	for(Integer o: map.get(t)) {
	    		System.out.print(o+" ");
	    	}
	    }
	}
}
