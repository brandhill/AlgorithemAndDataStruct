package ArraysandStrings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CheckforZeroinMatrix7 {
	
	public void setToZero(List<List<Integer>> L){
		
		for(List<Integer> m:L){
			if(m.contains(0)){
				for(Integer i:m){
					m.set(m.indexOf(i), 0);
				}
			}
		}
		System.out.println(L.toString());
	}
	
	
	public static void main(String[] args) {
		List<List<Integer>> L = new ArrayList<List<Integer>>();
		List<Integer> L1 = new ArrayList<Integer>();
		List<Integer> L2 = new ArrayList<Integer>();
		L.add(L1);
		L.add(L2);
		L.get(0).add(1);
		L.get(0).add(1);
		L.get(0).add(3);
		L.get(1).add(1);
		L.get(1).add(0);
		L.get(1).add(1);
	//int[][] matrix = {{1,2,3,4},{3,4,5,2},{0,6,5,4},{1,2,3,0}};
	CheckforZeroinMatrix7 q7 = new CheckforZeroinMatrix7();
	q7.setToZero(L);
	}
}
