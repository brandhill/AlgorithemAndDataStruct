package hackerrank.search;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// Time Complexity - (n*log n)
// Space - n
public class GridlandMetro {
	
	static void fillTrack1(Map<Integer,Set<point>> map,int r, int c1, int c2) {
		
		if(!map.containsKey(r)) {
			Set<point> set = new TreeSet<point>(new sortByMin());
			set.add(new point(c1,c2));
			map.put(r, set);
		}
		else {
			map.get(r).add(new point(c1,c2));
		}
	}
	
	static long getTrackCount(Map<Integer,Set<point>> map){
		long count = 0;
		for (Integer i: map.keySet()) {
			Set<point> set = map.get(i);
			int j = 0;
			int min = 0;
			for (point p: set) {
				if(j == 0) {
					count += p.max - p.min + 1;
					//System.out.println(count);
					min = p.max;
					j++;
				}
				else {
					if(p.min>min) {
						count += p.max - p.min + 1;
						min = p.max;
					}
					else {
						if(p.max>min) {
							count += p.max - min;
							min = p.max;
						}
					}
				}
			}
		}
		//System.out.println(count);
		return count;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long rows = sc.nextInt();
		long cols = sc.nextInt();
		int k = sc.nextInt();
		Map<Integer,Set<point>> map = new HashMap<Integer,Set<point>>();
		for ( int i = 0; i < k; i++) {
			int r = sc.nextInt()-1;
			int c1 = sc.nextInt()-1;
			int c2 = sc.nextInt()-1;
			GridlandMetro.fillTrack1(map, r, c1, c2);
		}
		long count = GridlandMetro.getTrackCount(map);
		System.out.println((rows*cols)-count);
	}
}

class sortByMin implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		point a = (point) o1;
		point b = (point) o2;
		if(a.min>b.min)
			return 1;
		else
			return -1;
	}
	
}

class point {
	int min;
	int max;
	point(int min, int max) {
		this.max = max;
		this.min = min;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + max;
		result = prime * result + min;
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
		point other = (point) obj;
		if (max != other.max)
			return false;
		if (min != other.min)
			return false;
		return true;
	}
	
	
}