package hackerrank.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class IceCreamParlor {
	
	static String getIceCreams(List<Integer> iceCreams, int dollars) {
		
		Set<Integer> set = new HashSet<Integer>();
		int index = 1;
		for (Integer i: iceCreams) {
			if(i <= dollars) {
				int required = dollars - i;
				if(!set.contains(required)) {
					set.add(i);
				}
				else {
					int index1 = iceCreams.indexOf(required)+1;
					return index1+" "+index;
				}
			}
			index++;
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loops = sc.nextInt();
		List<String> results = new ArrayList<String>();
		for ( int i = 0; i < loops; i++ ) {
			List<Integer> iceCreams = new ArrayList<Integer>();
			int dollars = sc.nextInt();
			int count = sc.nextInt();
			for (int j = 0; j < count; j++) {
				iceCreams.add(sc.nextInt());
			}
			results.add(IceCreamParlor.getIceCreams(iceCreams, dollars));
		}
		
		for ( int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
	}
}
