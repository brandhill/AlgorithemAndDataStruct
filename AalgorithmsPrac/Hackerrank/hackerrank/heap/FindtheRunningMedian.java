package hackerrank.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindtheRunningMedian {
	
	static void FindRunningMedian(int[] arr){
		
		//Stores 1st of array
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());  
		//Stores 2nd of array
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();
		
		for ( int i = 0; i < arr.length; i++ ) {
			int num = arr[i];
			if(min.isEmpty() || min.peek() <= num) {
				min.add(num);
			}
			else{
				max.add(num);
			}
			
			double diff = min.size() - max.size();
			
			if(diff>1){
				max.add(min.poll());
			}
			else if(diff<-1) {
				min.add(max.poll());
			}
			
			//Calculate median
			double median;
			//Odd numbers
			if(i%2==0){
				median = min.size()>max.size()?min.peek():max.peek();
			}
			//Even numbers
			else {
				median = (min.peek()+max.peek())/ (2.0);
			}
			
			System.out.println(median);
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] arr = new int[count];
		for ( int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		FindtheRunningMedian.FindRunningMedian(arr);
	}
}
