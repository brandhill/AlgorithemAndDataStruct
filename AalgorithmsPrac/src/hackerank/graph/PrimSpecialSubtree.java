package hackerank.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PrimSpecialSubtree {
	
	
	
	static int SpecialSubtree(Map<Integer,Node> map,Node root,int count) {
		int totallen = 0;
		Set<Node> visited = new HashSet<Node>();
		visited.add(root);
		while(visited.size()!=count) {
			int len = -1;
			int val = 0;
			int r = 0;
			for(Node n: visited) {
				for(link check : n.links) {
					if(!visited.contains(map.get(check.num)) && (len == -1 || check.len<len)) {
						len = check.len;
						val = check.num;
						r = n.num;
					}
				}
			}
			System.out.print(len+" ");
			visited.add(map.get(val));
			totallen += len;
		}
		return totallen;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int loop = sc.nextInt();
		Map<Integer,Node> map = new HashMap<Integer,Node>();
		for (int i = 1; i <= count; i++) {
			Node n = new Node(i);
			map.put(i,n);
		}
		for (int i = 0; i < loop; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int len = sc.nextInt();
			map.get(a).add(b, len);
			map.get(b).add(a, len);
		}
		/*for (int i = 1; i <= count; i++) {
			System.out.print(map.get(i).num+": ");
			for (link l: map.get(i).links) {
				System.out.print("("+l.num+","+l.len+") ");
			}
			System.out.println();
		}*/
		int answer = PrimSpecialSubtree.SpecialSubtree(map, map.get(sc.nextInt()), count);
		System.out.println(answer);
	}
}

class link {
	int num;
	int len;
	link(int num,int len) {
		this.num = num;
		this.len = len;
	}
}

class Node {
	int num;
	List<link> links;
	Node(int num) {
		links = new ArrayList<link>();
		this.num = num;
	}
	
	void add(int num,int len) {
		links.add(new link(num,len));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
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
		Node other = (Node) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
}