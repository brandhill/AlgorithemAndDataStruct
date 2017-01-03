package GraphsDataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Graph {
	Vertex[] users;
	
	Graph(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
		users = new Vertex[sc.nextInt()];
		
		//read vertices
		for ( int v=0; v < users.length; v++) {
			users[v] = new Vertex(sc.next());
		}
		
		//read edges
		while(sc.hasNext()) {
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			users[v1].addFriend( new Neighbor(users[v2].name));
			users[v2].addFriend( new Neighbor(users[v1].name));
			
		}
	}
		
	int indexForName(String name) {
		for ( int i =0; i < users.length; i++) {
			//System.out.println(users[i].name);
			if(users[i].name.equals(name))
				return i;
		}
		return -1;
	}
	
	void print() {
		for ( int i =0; i < users.length; i++) {
			System.out.print(users[i].name+" --> ");
			Neighbor n = users[i].friends; 
			while(n!=null) {
				System.out.print(n.name+",");
				n = n.next;
			}
			System.out.println();
		}
	}
	
	//List<String> Paths;
	void findShortPath(String name1, String name2) {
		Vertex start = users[indexForName(name1)];
		Vertex end = users[indexForName(name2)];
		Set<String> set = new HashSet<String>();
		findShortPathHelper(start,end,start,"");
		//findShortPathHelper(end,start,"");
		System.out.println("completed");
		//return ans;
	}
	private void findShortPathHelper(Vertex start, Vertex end,Vertex prev,String path) {
		if(start == null)
			return;
		
		path = path + start.name +",";
		if(start.name.equals(end.name)) {
				System.out.println(path);
			return;
		}
		
		Neighbor nei = start.friends;
		while(nei!=null) {
			if(!nei.name.equals(prev.name)) {
				int index = indexForName(nei.name);
				findShortPathHelper(users[index],end,start,path);
				//if(ans!=null)
					//return ans;
			}
			nei = nei.next;
		}
		//return null;
	}
}

class Vertex {
	String name;
	Neighbor friends;

	public Vertex(String name) {
		this.name = name;
	}
	
	void addFriend(Neighbor friend) {
		if(friends==null) {
			friends = friend;
		}
		else {
			friend.next = friends;
			friends = friend;
		}
	}
}

class Neighbor {
	String name;
	Neighbor next;
	public Neighbor(String name) {
		this.name = name;
	}
}
