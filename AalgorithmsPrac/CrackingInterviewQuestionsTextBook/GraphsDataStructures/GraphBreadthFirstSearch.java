package GraphsDataStructures;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphBreadthFirstSearch {
	
	static void BreadthFirstSearch1(Graph Graph){
		int start =  (int) (Math. random() * (Graph.users.length -1));
		System.out.println(start);
		BreadthFirstSearch(Graph,start,new HashSet<Integer>());
	}
	
	static void BreadthFirstSearch(Graph Graph,int start, Set<Integer> set){
		Vertex[] users = Graph.users;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		set.add(start);
		while(!queue.isEmpty()) {
			Vertex user = users[queue.poll()];
			System.out.println(user.name);
			Neighbor friend = user.friends;
			while(friend!=null) {
				int index = Graph.indexForName(friend.name);
				if(!set.contains(index)) {
					//Vertex v = new Vertex(friend.name);
					queue.add(index);
					set.add(index);
				}
				friend = friend.next;
			}
		}
		
		for( int i = 0; i < users.length; i++) {
			if(!set.contains(i)) {
				BreadthFirstSearch(Graph,i,set);
			}
		}
	}
}


/* 
 * Vertex[] users = Graph.users;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		queue.add(0);
		set.add(0);
		while(!queue.isEmpty()) {
			Vertex user = users[queue.poll()];
			System.out.println(user.name);
			Neighbor friend = user.friends;
			while(friend!=null) {
				int index = Graph.indexForName(friend.name);
				if(!set.contains(index)) {
					//Vertex v = new Vertex(friend.name);
					queue.add(index);
					set.add(index);
				}
				friend = friend.next;
			}
		}
		*/