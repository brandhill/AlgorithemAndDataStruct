package VeryImportantQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LRUCache {
    
    private Map<Integer,Obj> cache;
    private Queue<Obj> maintainOrder;
    private int capacity;
    private int ageCounter;
    public LRUCache(int capacity) {
         cache = new HashMap<Integer,Obj>(capacity);
         maintainOrder = new PriorityQueue<Obj>(capacity);
         this.capacity = capacity;
         this.ageCounter = 1;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Obj obj = cache.get(key);
            obj.age = ageCounter;
            ageCounter += 1;
            return obj.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Obj obj1 = cache.get(key);
            obj1.value = value;
            obj1.age = ageCounter; 
        }
        else {
            Obj obj = new Obj(key, value, this.ageCounter);    
            if(cache.size()==capacity) {
                Obj remove = maintainOrder.poll();
                cache.remove(remove.key);
            }
            cache.put(key,obj);
            maintainOrder.offer(obj);
        }
        ageCounter += 1;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 
 class Obj implements Comparable<Obj>{
     int key;
     int value;
     int age;
     
     Obj(int key, int value, int age){
         this.key = key;
         this.value = value;
         this.age = age;
     }
     
     void updateAge(int age) {
         this.age = age;
     }
     
     @Override
	public String toString() {
		return "Obj [key=" + key + ", value=" + value + ", age=" + age + "]";
	}

	@Override
     public int compareTo(Obj o) {
        if(this.age>o.age) {
            return 1;
        }
        else if(this.age<o.age) {
            return -1;
        }
        return 0;
     }

     
 }
