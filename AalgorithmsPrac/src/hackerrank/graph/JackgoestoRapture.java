package hackerrank.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JackgoestoRapture {
	
	static int MinCostRoute(Map<Integer,Node> map, Node start,Node end) {
		Cost c = new Cost(-1);
		MinCostRouteHelper(map,start,start,end,0,c,start.num+" ");
		return c.cost;
	}
	
	static void MinCostRouteHelper(Map<Integer,Node> map,Node parent, Node start,Node end,int cost,Cost c,String path) {
		//System.out.println();
		if(start.equals(end)) {
			//System.out.println(path+" "+cost);
			if( c.cost == -1 || c.cost > cost) {
				//System.out.println(path+" "+cost);
				c.cost = cost;
				return;
			}
		}
		for(link l: start.links) {
			//System.out.print(start.num+" "+l.num);
			Node n = map.get(l.num);
				//System.out.print(start.num+" "+n.num+"/");
			int newCost = (l.len - cost)>0?(l.len - cost):0;
			MinCostRouteHelper(map,start,n,end,cost+newCost,c,path+l.num+" ");
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stations = sc.nextInt();
		int loop = sc.nextInt();
		Map<Integer,Node> map = new HashMap<Integer,Node>();
		for ( int i = 1; i <= stations; i++) {
			map.put(i, new Node(i));
		}
		for ( int i = 0; i < loop; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int c = sc.nextInt();
			map.get(m).add(n, c);
			map.get(n).add(m, c);
		}
		int cost = JackgoestoRapture.MinCostRoute(map, map.get(1), map.get(stations));
		if(cost==-1) {
			System.out.println("NO PATH EXISTS");
		}
		else
			System.out.println(cost);
	}
}

class Cost{
	int cost;
	 Cost(int cost) {
		this.cost = cost;
	}
}