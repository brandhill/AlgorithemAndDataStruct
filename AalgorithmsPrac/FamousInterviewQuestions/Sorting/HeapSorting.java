package Sorting;

import java.util.ArrayList;
import java.util.List;

public class HeapSorting {
	
	List<Integer> list = new ArrayList<Integer>();
	HeapSorting(){
		
	}
	void printHeap(){
		System.out.println(list.toString());
	}
	
	void HeapSort(int[] array) {
		for ( int i = 0; i < array.length; i++) {
			list.add(array[i]);
			shiftUp(list.size()-1);
		}
	}
	
	void Insert(int i){
		list.add(i);
		shiftUp(list.size() - 1);
	}
	
	/*private void shiftUp(){
		if(list.size() <= 1){
			return;
		}
		int k = list.size() - 1;
		while( k>0 ) {
			int p = (k-1)/2;
			if( p < 0 || list.get(p) > list.get(k)) {
				break;
			}
			else {
				swap(p,k);
				k = p;
			}
		}
	}*/
	
	private void shiftUp(int k){
		if(k <= 0){
			return;
		}
		while( k>0 ) {
			int p = (k-1)/2;
			if( p < 0 || list.get(p) > list.get(k)) {
				break;
			}
			else {
				swap(p,k);
				k = p;
			}
		}
	}
	
	int Delete() {
		int del = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		shiftDown(0);
		return del;
	}
	
	int Delete(int val){
		int index = list.indexOf(val);
		list.set(index, list.get(list.size()-1));
		list.remove(list.size()-1);
		shiftUp(index);
		shiftDown(index);
		return val;
		
	}
	
	/*private void shiftDown(){
		int p = 0;
		while((2*p +1) < list.size()) {
			// left and right indexs of Parent 'p'
			int leftIndex = 2*p +1;
			int rightIndex = (2*p +2);
			// left and right values of parent 'p'
			int left = list.get(leftIndex);
			// if rightIndex is greater than list size, assign min value to right
			int right = rightIndex < list.size()?list.get(rightIndex):Integer.MIN_VALUE;
			
			int maxIndex = left > right?leftIndex:rightIndex;
			
			if(list.get(maxIndex) > list.get(p)) {
				swap(maxIndex,p);
				p = maxIndex;
			}
			else {
				break;
			}
		}
	}*/
	
	private void shiftDown(int p){
		while((2*p +1) < list.size()) {
			// left and right indexs of Parent 'p'
			int leftIndex = 2*p +1;
			int rightIndex = (2*p +2);
			// left and right values of parent 'p'
			int left = list.get(leftIndex);
			// if rightIndex is greater than list size, assign min value to right
			int right = rightIndex < list.size()?list.get(rightIndex):Integer.MIN_VALUE;
			
			int maxIndex = left > right?leftIndex:rightIndex;
			
			if(list.get(maxIndex) > list.get(p)) {
				swap(maxIndex,p);
				p = maxIndex;
			}
			else {
				break;
			}
		}
	}
	
	 void swap(int p,int k) {
		int temp = list.get(p);
		list.set(p, list.get(k));
		list.set(k, temp);
	}
	
	 public static void main(String[] args) {
		 HeapSorting heap = new HeapSorting();
		 int[] array = {5,3,2,1,6,10,11,12};
		 
		 heap.HeapSort(array);
		 heap.printHeap();
		 heap.Insert(22);
		 heap.printHeap();
		 heap.Delete();
		 heap.printHeap();
		 heap.Delete(10);
		 heap.printHeap();
	}
	
}

/*
[12, 11, 10, 5, 3, 2, 6, 1]
[22, 12, 10, 11, 3, 2, 6, 1, 5]
[12, 11, 10, 5, 3, 2, 6, 1]
[11, 5, 10, 1, 3, 2, 6]
 */
