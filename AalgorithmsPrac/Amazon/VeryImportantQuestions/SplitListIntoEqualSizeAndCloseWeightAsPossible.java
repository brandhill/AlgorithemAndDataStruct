package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Question: Given an unsorted, even-numbered array of integers, divide the array into two lists of the
//equal sizes such that their total is as close as possible
//Example:
//input {1000,500,200,1,5,10,50,70,70,100} output: List 1 : 500, 200, 100, 70, 70, List 2 : 1000, 50,
//10, 5, 1,
//input {50,10,200,150,900,250,40,50,950,5,90,80,60,600} List 1: 900, 600, 90, 60, 50, 10, 5, List 2:
//950, 250, 200, 150, 80, 50, 40,

public class SplitListIntoEqualSizeAndCloseWeightAsPossible {
	
	static List<List<Integer>> splitEqually(List<Integer> list) {
		Collections.sort(list,Collections.reverseOrder());
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		int list1Total = 0;
		int list2Total = 0;
		for(int i=0; i< list.size(); i++) {
			if(list1Total<list2Total && list1.size()<list.size()/2) {
				list1Total += list.get(i);
				list1.add(list.get(i));
			} else {
				list2Total += list.get(i);
				list2.add(list.get(i));
			}
		}
		int diff = 0;
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list1Total+" "+list2Total);
		if(list1Total>list2Total) {
			diff = list1Total - list2Total;
			reArrageLists(list1,list2,diff);
		} else if(list1Total<list2Total){
			diff = list2Total - list1Total;
			reArrageLists(list2,list1,diff);
		}
		lists.add(list1);
		lists.add(list2);
		return lists;
	}
	
	private static void reArrageLists(List<Integer> list1, List<Integer> list2,int number) {
		int diff = number/2;
		System.out.println(diff);
		int num1 = -1,num2=-1;
		for(int i=0; i<list1.size(); i++) {
			for(int j=list2.size()-1; j>=0; j--) {
				if(list1.get(i)<list2.get(j))
					break;
				int diff1 = Math.abs(Math.addExact(list1.get(i)-list2.get(j), -1*(number/2)));
				if(diff1<diff) {
					diff = diff1;
					num1 = i;
					num2 = j;
					System.out.println(num1+" "+num2);
				}
			}
		}
		if(num1!=-1) {
			int temp = list1.get(num1);
			list1.set(num1, list2.get(num2));
			list2.set(num2, temp);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,4,5,5};
//		int[] arr = {50,10,200,150,900,250,40,50,950,5,90,80,60,600};
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i< arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(splitEqually(list));
	}
	
}
