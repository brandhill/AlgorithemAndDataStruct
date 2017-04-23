package CareerCup;

import java.util.LinkedList;
import java.util.Queue;

public class DesignStackUsingQueue {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	void add(int n) {
		Queue<Integer> q = q1.isEmpty()?q2:q1;
		q.add(n);
	}
	
	Integer peek() {
		Queue<Integer> Qa = null;
		Queue<Integer> Qb = null;
		if(q1.isEmpty()) {
			Qa = q2;
			Qb = q1;
		} else {
			Qa = q1;
			Qb = q2;
		}
		Integer n = null;
		while(Qa.size()>1) {
			n = Qa.poll();
			Qb.offer(n);
		}
		return n;
	}
	Integer pop() {
		Queue<Integer> Qa = null;
		Queue<Integer> Qb = null;
		if(q1.isEmpty()) {
			Qa = q2;
			Qb = q1;
		} else {
			Qa = q1;
			Qb = q2;
		}
		Integer n = null;
		while(Qa.size()>1) {
			n = Qa.poll();
			Qb.offer(n);
		}
		return Qa.poll();
	}
	
	public static void main(String[] args) {
		DesignStackUsingQueue stack = new DesignStackUsingQueue();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}
}
