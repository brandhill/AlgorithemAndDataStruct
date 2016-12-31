package GraphsDataStructures;

import java.util.HashSet;
import java.util.Set;

public class GraphDepthFirstSearch {

	static void DFS(Graph Graph) {
		int start =  (int) (Math. random() * (Graph.users.length -1));
		System.out.println(start);
		Set<String> set = new HashSet<String>();
		
		DFSHelper(Graph,start,set);
		
		for ( int i = 0; i < Graph.users.length; i++ ) {
			if(!set.contains(Graph.users[i])) {
				DFSHelper(Graph,i,set);
			}
		}
	}
	
	static void DFSHelper(Graph Graph,int start,Set<String> set) {
		
		Vertex user = Graph.users[start];
		if(!set.contains(user.name))
			System.out.println(user.name);
		
		set.add(user.name);
		
		Neighbor nei = user.friends;
		while(nei!=null) {
			if(!set.contains(nei.name)) {
				int index = Graph.indexForName(nei.name);
				DFSHelper(Graph,index,set);
			}
			nei = nei.next;
		}
	}
}
