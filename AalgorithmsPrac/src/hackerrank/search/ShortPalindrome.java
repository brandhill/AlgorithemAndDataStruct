package hackerrank.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ShortPalindrome {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] chars = s.toCharArray();
		List<Similar> list = new ArrayList<Similar>();
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < chars.length-1; i++) {
			Similar sim = new Similar(i,chars[i]);
			if(!set.contains(chars[i])) {
				int c = 0;
				for(int j = i+1; j < chars.length; j++) {
					if(chars[i] == chars[j]) {
						sim.similar.add(j);
						if(c==0) {
							c++;
							set.add(chars[i]);
							list.add(sim);
						}
					}
				}
			}
			else {
				int index = list.indexOf(sim);
				Similar sim1 = list.get(index);
				for(Integer m: sim1.similar) {
					if(m>i) {
						sim.similar.add(m);
					}
				}
				list.add(sim);
			}
		}
		Collections.sort(list);
		
		
		
		
	}
}

class Similar implements Comparable {
	int index;
	char c;
	List<Integer> similar;
	
	Similar(int index,char c){
		this.index = index;
		this.c = c;
		similar = new ArrayList<Integer>();
	}

	@Override
	public int compareTo(Object o) {
		Similar s = (Similar) o;
		if(this.index>s.index)
			return 1;
		else
			return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
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
		Similar other = (Similar) obj;
		if (c != other.c)
			return false;
		return true;
	}
	
	
}