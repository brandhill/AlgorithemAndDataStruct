package StackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;

// Find median
// Time - O(n*log n)
// Space - O(n)
public class MedianFinder {
	PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
	PriorityQueue<Integer> min = new PriorityQueue<Integer>();
	
	void addNum(int num) {
		if(max.isEmpty()) {
			max.add(num);
		}
		else if(max.size()-min.size()>=1) {
			if(num>max.peek()) {
				min.add(num);
			}
			else {
				min.add(max.poll());
				max.add(num);
			}
		}
		else {
			if(num>min.peek()) {
				max.add(min.poll());
				min.add(num);
			}
			else {
				max.add(num);
			}
		}
	}
	
	double findMedian() {
		double ans;
		if(max.size()==min.size()) {
			ans = ((double)max.peek()+(double)min.peek())/2;
		}
		else {
			ans = (double) max.peek();
		}
		return ans;
	}
	
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
        mf.addNum(4);
        System.out.println(mf.findMedian());
        mf.addNum(8);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(11);
        System.out.println(mf.findMedian());
        mf.addNum(13);
        System.out.println(mf.findMedian());
        mf.addNum(14);
        System.out.println(mf.findMedian());
        mf.addNum(-1);
        System.out.println(mf.findMedian());
	}
}
