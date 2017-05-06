package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

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
				if(list.get(indexTracker[i])<value) {
					value = list.get(indexTracker[i]);
					listIndex = i;
				}
			}
				output.add(value);
				indexTracker[listIndex] += 1; 
		}
		
		return output;
	}
	
	
	
	// for stream of inputs
	public static List<Integer> mergeLists(List<Queue<Integer>> streams) {
		Queue<StremValue> minHeap = getHeap(streams);
		List<Integer> output = new ArrayList<Integer>();
		while(!minHeap.isEmpty()) {
			StremValue min = minHeap.poll();
			output.add(min.value);
			if(!min.stream.isEmpty()) {
				min.value = min.stream.poll();
				minHeap.add(min);
			}
		}
		return output;
	}
	
	private static Queue<StremValue> getHeap(List<Queue<Integer>> streams) {
		List<StremValue> combinedStream = new ArrayList<StremValue>();
		for(int i=0; i< streams.size(); i++) {
			Queue<Integer> queue = streams.get(i);
			while(!queue.isEmpty()) {
				int n = queue.poll();
				combinedStream.add(new StremValue(n, streams.get(i)));
			}
		}
		Queue<StremValue> minHeap = new PriorityQueue<StremValue>(combinedStream);
		return minHeap;
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
		Queue<Integer> stream1 = new LinkedList<Integer>(list1);
		Queue<Integer> stream2 = new LinkedList<Integer>(list2);
		Queue<Integer> stream3 = new LinkedList<Integer>(list3);
		Queue<Integer> stream4 = new LinkedList<Integer>(list4);
		List<Queue<Integer>> streams = new ArrayList<Queue<Integer>>();
		streams.add(stream1);
		streams.add(stream2);
		streams.add(stream3);
		streams.add(stream4);
		System.out.println(mergeLists(streams));
	}
}



class StremValue implements Comparable<StremValue>{
	int value;
	Queue<Integer> stream;
	
	StremValue(int value, Queue<Integer> stream) {
		this.value = value;
		this.stream = stream;
	}

	@Override
	public int compareTo(StremValue o) {
		if(this.value>o.value)
			return 1;
		else if(this.value<o.value)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "StremValue [value=" + value + "]";
	}
	
	
}