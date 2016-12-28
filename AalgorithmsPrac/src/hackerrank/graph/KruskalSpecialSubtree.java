package hackerrank.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class KruskalSpecialSubtree {
	
	static int SpecialSubtree(List<Node1> list,Map<Integer,N> map) {
		
		int totalwt = 0;
		for ( int i = 0; i < list.size(); i++) {
			Node1 n = list.get(i);
			Queue<N> queue = new LinkedList<N>();
			N root = map.get(n.n1);
			queue.add(root);
			N check = map.get(n.n2);
			boolean eval = true;
			Set<Integer> set = new HashSet<Integer>();
			while(!queue.isEmpty()) {
				N node = queue.poll();
				set.add(node.num);
				for(N n1 : node.list) {
					if(!set.contains(n1.num)) {
						queue.add(n1);
						if( n1.num == check.num) {
							eval = false;
							break;
						}
					}
				}
				//System.out.println(node.num);
				if(!eval) {
					break;
				}
			}
			if(eval) {
				System.out.println(root.num+" "+check.num);
				root.list.add(check);
				check.list.add(root);
				totalwt += n.wt;
			}
		}
		return totalwt;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int loop = sc.nextInt();
		Map<Integer,N> map = new HashMap<Integer,N>();
		for ( int i = 1; i <= count; i++) {
			map.put(i, new N(i));
		}
		List<Node1> list = new ArrayList<Node1>();
		for ( int i = 0; i < loop; i++) {
			list.add(new Node1(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(list);
		for ( int i = 0; i < loop; i++) {
			Node1 n = list.get(i);
			System.out.println(n.n1+" "+n.n2+" "+n.wt);
		}
		int wt = KruskalSpecialSubtree.SpecialSubtree(list,map);
		System.out.println(wt);
	}
}

class N {
	int num;
	List<N> list;
	N(int num){
		this.num = num;
		list = new ArrayList<N>();
	}
	
	
	
}

class Node1 implements Comparable {
	int n1;
	int n2;
	int wt;
	Node1(int n1,int n2,int wt) {
		this.n1 = n1;
		this.n2 = n2;
		this.wt = wt;
	}
	@Override
	public int compareTo(Object o) {
		Node1 n = (Node1) o;
		if(this.wt < n.wt) {
			return -1;
		}
		else if(this.wt > n.wt) {
			return 1;
		}
		else {
			if((this.wt+this.n1+this.n2) < (n.wt+n.n1+n.n2)) {
				return -1;
			}
			else {
				return 1;
			}
		}
	}
}
