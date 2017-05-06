package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MinHeapSorting {
	
	List<Integer> list = new ArrayList<Integer>();
	
	MinHeapSorting(int[] array) {
		for ( int i = 0; i < array.length; i++) {
			list.add(array[i]);
			shiftUp();
		}
	}
	
	void offer(int val) {
		list.add(val);
		shiftUp();
	}
	
	private void shiftUp() {
		int index = list.size()-1;
		while(index>0) {
			int parent = (index-1)/2;
			if(list.get(parent)<list.get(index)) {
				return;
			} else {
				swap(index,parent);
				index = parent;
			}
		}
	}
	
	int peek() {
		return list.get(0);
	}
	
	int poll() {
		int val = list.get(0);
		swap(0,list.size()-1);
		list.remove(list.size()-1);
		shiftDown();
		return val; 
	}
	
	private void shiftDown() {
		if(list.size()==0)
			return;
		int index = 0;
		while(((2*index)+2)<list.size()) {
			int left = (2*index) +1;
			int right = (2*index) +2;
			int min;
			if(list.get(left)>list.get(right))
				min = right;
			else
				min = left;
			if(list.get(index)<list.get(min)) {
				break;
			} else {
				swap(index,min);
				index = min;
			}
		}
		
		if((2*index+1)<list.size()-1 && list.get(index)>list.get(2*index+1)) {
			swap(index,2*index+1);
		}
	}
	
	boolean isEmpty() {
		if(list.size()==0)
			return true;
		return false;
	}
	
	private void swap(int index1, int index2) {
		int temp = list.get(index1);
		list.set(index1,list.get(index2));
		list.set(index2,temp);
	}
	
	public static void main(String[] args) {
		int[] array = {2,3,5,6,1,4,2,5,6};
		MinHeapSorting minHeap = new MinHeapSorting(array);
		System.out.println(minHeap.list);
//		System.out.println(minHeap.peek());
		while(!minHeap.isEmpty())
			System.out.println(minHeap.poll());
		
	}
}
