package DynamicProgramming;

import java.util.ArrayList;

import GraphsDataStructures.mainclass;

public class FindAllSubsets4 {

	static ArrayList<ArrayList<Integer>> FindSubsets(ArrayList<Integer> set, int index) {
		
		ArrayList<ArrayList<Integer>> allsubsets;
		
		if(set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else {
			allsubsets = FindSubsets(set,index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			
			for (ArrayList<Integer> subset: allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
		
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		ArrayList<ArrayList<Integer>> subsets = FindAllSubsets4.FindSubsets(set, 0);
		
		for ( ArrayList<Integer> subset : subsets ) {
			System.out.println(subset.toString());
		}
	}
}
