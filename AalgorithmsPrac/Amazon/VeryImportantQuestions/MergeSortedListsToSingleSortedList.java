package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedListsToSingleSortedList {
	
	static List<Integer> MergeLists(List<List<Integer>> lists) {
		int[] indexTracker = new int[lists.size()];
		List<Integer> output = new ArrayList<Integer>();
		int totalSize = 0;
		for(int i = 0; i < lists.size(); i++) {
			totalSize += lists.get(i).size(); 
		}
		
		while(output.size()<totalSize) {
			int value = Integer.MAX_VALUE;
			int listIndex = -1;
			for(int i = 0; i < lists.size(); i++) {
				List<Integer> list = lists.get(i);
				if(indexTracker[i]==list.size()) {
					continue;
				}
//				System.out.println(list.get(indexTracker[i])+" "+value);
				if(list.get(indexTracker[i])<value) {
//					System.out.println(true);
					value = list.get(indexTracker[i]);
					listIndex = i;
				}
			}
				output.add(value);
				indexTracker[listIndex] += 1; 
//				System.out.println(Arrays.toString(indexTracker));
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(5);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(6);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(3);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(7);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		System.out.println(MergeLists(lists));
	}
}
