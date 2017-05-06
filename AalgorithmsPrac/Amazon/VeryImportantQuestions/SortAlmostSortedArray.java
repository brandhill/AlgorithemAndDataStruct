package VeryImportantQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//Sort an almost sorted Array. An almost sorted Array being an Array in which a number is at the most k positions 
//away from its position in the sorted Array.

// time - n log k , space - k
public class SortAlmostSortedArray {
	
	
	static void sortAlmostSortedArray(int[] array, int k) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		int i = 0;
		int j = 0;
		while(j<array.length) {
			minHeap.add(array[j]);
			if(j-i==k) {
				array[i] = minHeap.poll();
				i++;
			}
			j++;
		}
		
		while(!minHeap.isEmpty()) {
			array[i] = minHeap.poll();
			i++;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {4, 2, 1, 5, 3, 7, 9, 8, 6};
		sortAlmostSortedArray(array,3);
		System.out.println(Arrays.toString(array));
	}
	
}

// k =3
// 4 2 1 5 3 7 9 8 6 
