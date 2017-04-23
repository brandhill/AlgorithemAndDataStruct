package CareerCup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

// https://www.careercup.com/question?id=5068409286950912

public class MovesItemsEfficiently {
	
	static void getSortedEfficientLy(List<Integer> m1, List<Integer> m2, List<Integer> m3, int size) {
		TotalOperations operations = new TotalOperations();
		operations.count = 3;
		Sort(m2,m3,size - m1.size(), operations);
		Sort(m1,m2,size - m3.size(), operations);
		Sort(m2,m3,size - m1.size(), operations);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(operations.count);
	}
	
	static void Sort(List<Integer> bucket1, List<Integer> bucket2, int bucket3AvaliableCapacity,TotalOperations operations ) {
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i: bucket1) {
			maxHeap.add(i);
		}
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i: bucket2) {
			minHeap.add(i);
		}
		operations.count += 2;
//		System.out.println("max");
//		System.out.println(maxHeap);
//		System.out.println("min");
//		System.out.println(minHeap);
		Sort(maxHeap, minHeap, bucket3AvaliableCapacity, operations);
		bucket1.clear();
		bucket2.clear();
		while(!maxHeap.isEmpty()) {
			bucket1.add(maxHeap.poll()); 
		}
		while(!minHeap.isEmpty()) {
			bucket2.add(minHeap.poll()); 
		}
	}
	
	static void Sort(Queue<Integer> maxHeap, Queue<Integer> minHeap, int bucket3AvaliableCapacity, TotalOperations operations) {
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		if(maxHeap.peek()<=minHeap.peek()) {
			return;
		}
		while( maxHeap.peek()>minHeap.peek() && count<bucket3AvaliableCapacity) {
			count++;
			list.add(maxHeap.poll());
			operations.count += 1;
		}
		if(count>0) {
			operations.count += 2;
		}
		while(count>0 ) {
			maxHeap.offer(minHeap.poll());
			count--;
		}
		for(Integer i: list) {
			minHeap.offer(i);
		}
		Sort(maxHeap, minHeap, bucket3AvaliableCapacity,operations);
	}
	
	public static void main(String[] args) {
		List<Integer> m1 = new ArrayList<Integer>();
		List<Integer> m2 = new ArrayList<Integer>();
		List<Integer> m3 = new ArrayList<Integer>();
		Random rand = new Random();
		Set<Integer> set = new HashSet<Integer>();
		while(m1.size()<=90) {
			int n = Math.abs(rand.nextInt(1000));
			if(!set.contains(n)) {
				m1.add(n);
			}
		}
		while(m2.size()<=90) {
			int n = Math.abs(rand.nextInt(1000));
			if(!set.contains(n)) {
				m2.add(n);
			}
		}
		while(m3.size()<=90) {
			int n = Math.abs(rand.nextInt(1000));
			if(!set.contains(n)) {
				m3.add(n);
			}
		}

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println("----");
		getSortedEfficientLy(m1, m2, m3, 100);
	}
}

class TotalOperations {
	int count;
}