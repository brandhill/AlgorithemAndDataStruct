package hackerrank.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HackerlandRadioTransmitters {
	static int findMinTransiters(List<Boolean> houses,int start,int end,int k) {
		boolean[] lights = new boolean[end+1];
		//System.out.println(lights[11]);
		return findMinTransitersHelper(houses,start,end,lights,k);
	}
		static int findMinTransitersHelper(List<Boolean> houses,int start,int end,boolean[] Light,int k) {
			//System.out.println(Light[11]);
			if(start == end) {
				return 1;
			}
			else if(start > end) {
				return 0;
			}
			else {
				if(k >= end-start)
					return 1;
				int count = 0;
				//System.out.println(start+" "+end);
				int pointer = Math.min(start+k, end);
				//System.out.println(pointer);
				while ((pointer>start)) {
					if(!(houses.get(pointer) && !Light[pointer]))
						pointer--;
					else
						break;
				}
				//System.out.println("p "+pointer);
				for(int i = start; i <=Math.min(pointer+k, end); i++) {
					if(houses.get(i) && !Light[i]) {
						Light[i] = true;
						if(count==0) {
							//System.out.println(pointer);
							count++;
						}
					}
				}
				//System.out.println(end);
				int pointer1 = Math.max(end-k, start);
				
				while (pointer1<end) {
					if(!(houses.get(pointer1) && !Light[pointer1]))
						pointer1++;
					else
						break;
				}
				
				for(int i = Math.max(pointer1-k, start); i <= end; i++) {
					if(houses.get(i) && !Light[i]) {
						Light[i] = true;
						if(count==1) {
							//System.out.println(pointer1);
							count++;
						}
					}
				}
				start = Math.min(pointer+k+1, end);
				while(!houses.get(start)) {
					start++;
				}
				end = Math.max(pointer1-k-1, start);
				while(!houses.get(end)) {
					end--;
				}
				//System.out.println(start+" "+end);
				if(start==end)
					return count;
				
				return findMinTransitersHelper(houses,start,end,Light,k)+count;
			}
		}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int k = sc.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		int end = 0;
		int start = Integer.MAX_VALUE;
		for ( int i = 0; i < count; i++) {
			int val = sc.nextInt();
			set.add(val);
			if(val > end)
				end = val;
			if(val < start)
				start = val;
		}
		List<Boolean> houses = new ArrayList<Boolean>();
		for (int i = 0; i <= end; i++) {
			if(set.contains(i))
				houses.add(true);
			else
				houses.add(false);
		}
		int val = HackerlandRadioTransmitters.findMinTransiters(houses, start, end, k);
		System.out.println(val);
	}
}
