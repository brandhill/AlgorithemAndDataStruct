package CareerCup;
// https://www.careercup.com/question?id=6272666988183552

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrackKofBillionRecords {
	
	Queue<Record> topKRecords;
	private final int k;
	Map<Integer, Record> map;
	
	TrackKofBillionRecords(int k ) {
		topKRecords = new PriorityQueue<Record>();
		map = new HashMap<Integer,Record>();
		this.k = k;
	}
	
	void addRecord(int id) {
		map.put(id, new Record(id,1));
		updateTopKElements(map.get(id));
	}
	
	void updateRecord(int id) {
		if(map.containsKey(id)) {
			Record r1 = map.get(id);
			r1.count += 1;
			updateTopKElements(r1);
		} 
	}
	
	void updateTopKElements(Record r) {
		if(topKRecords.size()==k) {
			Record peek = topKRecords.peek();
			System.out.println(peek.id);
			if(peek.count<r.count) {
				topKRecords.poll();
				topKRecords.offer(r);
			} else {
				Record r1 = topKRecords.poll();
				topKRecords.offer(r1);
			}
			System.out.println(topKRecords.peek().id +" "+topKRecords.peek().count);
		} else {
			topKRecords.offer(r);
		}
	}
	
	public static void main(String[] args) {
		TrackKofBillionRecords track = new TrackKofBillionRecords(3);
		track.addRecord(1);
		track.addRecord(2);
		track.addRecord(3);
		track.addRecord(4);
		track.addRecord(5);
		track.addRecord(6);
		track.updateRecord(4);
		track.updateRecord(4);
		track.updateRecord(5);
		track.updateRecord(6);
		track.updateRecord(1);
		track.updateRecord(1);
		track.updateRecord(6);
		track.updateRecord(6);
//		System.out.println(track.topKRecords.size());
		System.out.println("----");
		while(!track.topKRecords.isEmpty()) {
			System.out.println(track.topKRecords.poll().count);
		}
	}
}


class Record implements Comparable<Record>{
	int id;
	int count;

	public Record(int id, int count) {
		this.id = id;
		this.count = count;
	}



	@Override
	public int compareTo(Record r) {
		if(this.count<r.count)
			return -1;
		else if(this.count>r.count)
			return 1;
		return 0;
	}
}