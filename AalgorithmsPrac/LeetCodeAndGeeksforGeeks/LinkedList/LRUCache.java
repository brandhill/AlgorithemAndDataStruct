package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private Link2 frontEnd;
	private Link2 backEnd;
	private int size;
	private int currentSize;
	Map<Integer,Link2> lookUp = new HashMap<Integer,Link2>();
	
	public LRUCache(int size) {
		this.frontEnd = null;
		this.backEnd = null;
		this.size = size;
	}
	
	void put(int n) {
		if(size==1) {
			frontEnd = null;
			addPage(n);
		}
		else {
			if(lookUp.containsKey(n)) {
				System.out.println("order refresh "+n);
				refreshPageOrder(n);
			}
			else {
				if(currentSize==size) {
					removeLeastRecentlyUsedPage();
				}
				else {
					currentSize++;
				}
				addPage(n);
			}
		}
	}
	
	int getRecentlyUsedPage() {
		return this.frontEnd.id;
	}
	
	private void addPage(int n){
		Link2 page = new Link2(n);
		lookUp.put(n, page);
		if(frontEnd==null) {
			frontEnd = page;
			backEnd = page;
		}
		else {
			page.next = frontEnd;
			frontEnd.prev = page;
			frontEnd = page;
		}
	}
	
	private void removeLeastRecentlyUsedPage() {
		lookUp.remove(backEnd.id);
		Link2 temp = backEnd.prev;
		temp.next = null;
		backEnd = temp;
	}
	
	private void refreshPageOrder(int n) {
		Link2 pageToRefresh = lookUp.get(n);
		pageToRefresh.prev.next = pageToRefresh.next;
		if(pageToRefresh.next!=null)
			pageToRefresh.next.prev = pageToRefresh.prev;
		else
			backEnd = backEnd.prev;
		pageToRefresh.prev = null;
		pageToRefresh.next = frontEnd;
		frontEnd.prev =  pageToRefresh;
		frontEnd = pageToRefresh;
	}

	void printOrder() {
		Link2 node = frontEnd;
		while(node!=null) {
			System.out.print(node.id+" ");
			node = node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1);
		cache.put(2);
		cache.printOrder();
		cache.put(3);
		cache.printOrder();
		cache.put(4);
		cache.put(5);
		cache.printOrder();
		cache.put(4);
		cache.printOrder();
		cache.put(6);
		cache.printOrder();
		cache.put(2);
		cache.printOrder();
		cache.put(5);
		cache.printOrder();
	}
}

class Link2 {
	int id;
	Link2 next;
	Link2 prev;
	Link2(int id) {
		this.id = id;
	}
}