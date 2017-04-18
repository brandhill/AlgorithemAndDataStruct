package CareerCup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.careercup.com/question?id=5199356015673344

public class PrintOverLappingSchedule {
	
	static List<List<Integer>> overLappingIndexs(int[][] workSchedule) {
		List<work> list = new ArrayList<work>();
		for(int i=0; i<workSchedule.length; i++) {
			list.add(new work(workSchedule[i][0],workSchedule[i][1],i));
		}
		Collections.sort(list);
		int min = list.get(0).start;
		int max = list.get(0).end;
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(list.get(0).index);
		for(int i=1; i< list.size(); i++) {
			work w = list.get(i);
			if(w.start<=max) {
				temp.add(w.index);
				max = Math.max(max, w.end);
			} else {
				output.add(temp);
				temp = new ArrayList<Integer>();
				temp.add(w.index);
				min = w.start;
				max = w.end;
			}
			if(i==list.size()-1)
				output.add(temp);
		}
		return output;
	}
	
	public static void main(String[] args) {
		int[][] workSchedule = {{1,2},{5,6},{1,5},{7,9},{1,6},{8,11}};
		System.out.println(overLappingIndexs(workSchedule));
	}
}

class work implements Comparable<work> {
	int start;
	int end;
	int index;
	public work(int start, int end, int index) {
		this.start = start;
		this.end = end;
		this.index = index;
	}
	
	@Override
	public int compareTo(work o1) {
		if(this.start>o1.start)
			return 1;
		else if(this.start<o1.start)
			return -1;
		else {
			if(this.end>o1.end)
				return 1;
			else if(this.end<o1.end)
				return -1;
		}
		return 0;
	}
}