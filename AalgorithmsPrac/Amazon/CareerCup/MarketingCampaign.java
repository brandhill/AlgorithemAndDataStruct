package CareerCup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.careercup.com/question?id=5641849970622464

public class MarketingCampaign {
	
	
	static void divideCustomers(Map<Integer,Integer> customerDetails) {
		
		// maxHeap
		Queue<Integer> bottom25 = new PriorityQueue<Integer>(Collections.reverseOrder());
		// minHeap
		Queue<Integer> top25 = new PriorityQueue<Integer>();
		int size = customerDetails.size()/4;
		List<Integer> others = new ArrayList<Integer>();
		for(int id: customerDetails.keySet()) {
			System.out.println(id);
			int purchases = customerDetails.get(id);
			if(bottom25.size()<size) {
				bottom25.offer(id);
			} else {
				int id1 = bottom25.peek();
				int purchase1 = customerDetails.get(id1);
				if(purchases<purchase1) {
					bottom25.poll();
					bottom25.offer(id);
					id = id1;
					purchases = purchase1;
				}
				if(top25.size()<size) {
					top25.offer(id);
				} else {
					int id2 = top25.peek();
					if(purchases>customerDetails.get(id2)) {
						top25.poll();
						top25.offer(id);
						id = id2;
					}
					others.add(id);
				}
				
			}
			
		}
		
		System.out.println("Top 25" + top25);
		System.out.println("Bottom 25" + bottom25);
		System.out.println("Middle" + others);
	}
	
	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
//		for(int i=12; i>=1; i--) {
//			map.put(i, i);
//		}
		map.put(1, 10);
		map.put(2, 5);
		map.put(3, 20);
		map.put(4, 12);
		map.put(5, 20);
		map.put(6, 50);
		map.put(7, 20);
		map.put(8, 13);
		map.put(9, 5);
		map.put(10, 25);
		map.put(11, 19);
		map.put(12, 30);
		divideCustomers(map);
	}
}
