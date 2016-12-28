package ArraysProblems;

import java.util.LinkedList;
import java.util.Queue;

// http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

public class MinimumDistanceBetweenTwoNumbers {
	
	// Time - O(n)
	// Space - O(1)
	public int minDistance(int input[], int x, int y) {
		int minDis = Integer.MAX_VALUE;
		
		return minDis;
	}
	
	// Time - O(n)
	// Space - O(n)
	public int minDistance1(int input[], int x, int y) {
		int minDis = Integer.MAX_VALUE;
		Queue<Integer> xQueue = new LinkedList<Integer>();
		Queue<Integer> yQueue = new LinkedList<Integer>();
		
		for(int i = 0; i < input.length; i++) {
			if(input[i]==x) {
				xQueue.add(i);
			}
			else if(input[i]==y) {
				yQueue.add(i);
			}
		}
		
		while(!xQueue.isEmpty() && !yQueue.isEmpty()) {
			int num1 = xQueue.peek();
			int num2 = yQueue.peek();
			int diff = 0;
			if(num1>num2) {
				yQueue.poll();
			}
			else {
				xQueue.poll();
			}
			if(Math.abs(Math.subtractExact(num1, num2)) < minDis) {
				minDis = Math.abs(Math.subtractExact(num1, num2));
			}
		}
		
		return minDis;
	}
	
	public static void main(String args[]){
        MinimumDistanceBetweenTwoNumbers mdb = new MinimumDistanceBetweenTwoNumbers();
        //int input[] = {6,4,1,5,6,9,10,4,6,6}; // 5,6
        //int input[] = {3, 4, 5}; // 3,5
        //int input[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}; // 6,3
        int input[] = {2, 5, 3, 5, 4, 4, 2, 3}; // 3,2
        System.out.println(mdb.minDistance(input, 2, 3));
    }
}
