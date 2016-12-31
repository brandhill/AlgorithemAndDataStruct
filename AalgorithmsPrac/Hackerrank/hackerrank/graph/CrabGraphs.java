package hackerrank.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
// Incomplete
public class CrabGraphs {
	
	static int GetCradCounts(List<Vertex> list,int k,int n) {
		
		int[] track = new int[n+1];
		Map<Integer,Crab> map1 = new HashMap<Integer,Crab>();
		for(int i = 0; i < list.size(); i++) {
				int num = list.get(i).vertex;
				int temp = track[num];
				if(track[num]!=0) {
					Crab check1 = map1.get(track[num]);
					if(check1.size>=1) {
						check1.size--;
						check1.feets.remove(new Integer(num));
						//System.out.println(num+" removed from "+check1.head+" and created as head");
					}
				}
				Crab c = new Crab(num);
				track[num] = num;
				map1.put(c.head, c);
				//System.out.println(c.head+" started");
			for(Integer ver : list.get(i).links) {
				if(track[ver]==ver) {
					//System.out.println(ver+" is head of crab so skipped" );
				}
				else if(track[ver]!=0) {
					Crab check = map1.get(track[ver]);
					if(check.size>1) {
						//System.out.println(ver+" removed from "+check.head+" and added to "+c.head );
						check.size--;
						check.feets.remove(ver);
						track[ver] = c.head;
						c.add(ver);
						c.size++;
					}
				}
				else {
					//System.out.println(ver+" added to "+c.head);
					track[ver] = c.head;
					c.add(ver);
					c.size++;
				}
			}
			if(c.size < 1) {
				//System.out.println(c.size+" feet is "+k+" so updated to zero");
				track[c.head] = temp;
			}
		}
		
		int count = 0;
		/*for(Integer i : map1.keySet()) {
			Crab c = map1.get(i);
			System.out.println(i+" "+c.size);
			if(c.size>=1)
				count += (c.size>k?k:c.size)+1;
		}*/
		int[] kcount = new int[n+1];
		
		System.out.println();
		for(int i =1; i < n+1; i++) {
			//if(track[i] == 0)
			//System.out.print("("+i+","+track[i]+") ");
			kcount[track[i]] = kcount[track[i]] +1; 
			if(track[i]!=0 && kcount[track[i]]<k+1) {
				count++;
				kcount[track[i]] = kcount[track[i]] +1; 
			}
		}
		for(int i =1; i < n+1; i++) {
			System.out.println(i+" "+kcount[i]);
		}
		//System.out.println();
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < loop; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int m = sc.nextInt();
			Map<Integer,Vertex> map = new HashMap<Integer,Vertex>();
			List<Vertex> list = new ArrayList<Vertex>();
			for(int j = 1; j <= n; j++) {
				Vertex v = new Vertex(j);
				map.put(j, v);
				//list.add(v);
			}
			for(int j = 0; j < m; j++) {
				Vertex a = map.get(sc.nextInt());
				Vertex b = map.get(sc.nextInt());
				a.add(b.vertex);
				if(a.links.size()>=1 && !list.contains(a)) {
					//System.out.println("added "+a.vertex+" "+list.contains(a));
					list.add(a);
				} 
				b.add(a.vertex);
				if(b.links.size()>=1 && !list.contains(b)) {
					//System.out.println("added "+b.vertex+" "+set.contains(b));
					list.add(b);
				} 
			}
			//List<Vertex> list = (List<Vertex>) map.values();
			//System.out.println(list.size());
			Collections.sort(list);
			//System.out.println(list.size());
			for(int p = 0; p < list.size(); p++) {
				Vertex v = list.get(p);
				System.out.print(v.vertex+": ");
				for(Integer q: v.links) {
					
					System.out.print(q+" ");
				}
				System.out.println();
			}
			output.add(CrabGraphs.GetCradCounts(list, k, n));
		}
		
		for(int i = 0; i < output.size();i++) {
			System.out.println(output.get(i));
		}
	}
}

class Crab {
	int head;
	List<Integer> feets;
	int size;
	
	Crab(int head) {
		this.head = head;
		feets = new ArrayList<Integer>();
	}
	
	void add(Integer i) {
		feets.add(i);
	}
}

class Vertex implements Comparable {
	int vertex;
	List<Integer> links;
	Vertex(int i){
		this.vertex = i;
		links = new ArrayList<Integer>();
	}
	
	void add(Integer i) {
		links.add(i);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vertex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (vertex != other.vertex)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		Vertex v = (Vertex) o;
		if(this.links.size() < v.links.size()) 
			return 1;
		else if(this.links.size() > v.links.size())
			return -1;
		else 
			return 0;
	}
}


/* 
1
8 2 8  
1 4  
2 4  
3 4  
5 4  
5 8  
5 7  
5 6
*/
