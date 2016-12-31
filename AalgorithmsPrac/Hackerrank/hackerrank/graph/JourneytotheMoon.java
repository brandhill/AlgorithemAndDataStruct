package hackerrank.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class JourneytotheMoon {
	
	static long countPairs(List<Astronaut> list){
		long sum = 0;
		Set<Integer> nums = new HashSet<Integer>();
		List<Integer> countries = new ArrayList<Integer>();
		countries.add(0);
		for(int i = 0; i < list.size(); i++) {
			if(!nums.contains(i)) {
				//nums.add(i);
				
				int m = countPairsHelper(list, nums, list.get(i), list.get(i))+1;
				if(m==1) {
					countries.set(0,countries.get(0)+1);
				}
				else {
					countries.add(m);
				}
			}
		}
		for(int i = 0; i < countries.size()-1; i++){
			//System.out.println(i);
			for(int j = i+1; j < countries.size(); j++){
				if(i==0 && countries.get(i)==0) {
					break;
				}
				sum += countries.get(i)*countries.get(j);
			}
		}
		long m = countries.get(0);
		if(m!=0) {
			sum += (m*(m-1))/2;
		}
		return sum;
	}
	
	static int countPairsHelper(List<Astronaut> list,Set<Integer> nums,Astronaut parent,Astronaut child){
		int count = 0;
		nums.add(child.num);
		//System.out.println(parent.num+" "+child.num);
		for(Integer ast:child.list) {
			if(!nums.contains(ast)) {
			count++;
			nums.add(ast);
			count += countPairsHelper(list,nums,child,list.get(ast));
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int loop = sc.nextInt();
		List<Astronaut> list = new ArrayList<Astronaut>();
		for ( int i = 0; i < count; i++) {
			list.add(new Astronaut(i)); 
		}
		for ( int i = 0; i < loop; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.get(x).list.add(y);
			list.get(y).list.add(x);
		}
		long sum = JourneytotheMoon.countPairs(list);
		System.out.println(sum);
	}
}

class Astronaut{
	int num;
	List<Integer> list;
	
	Astronaut(int num) {
		this.num = num;
		list = new ArrayList<Integer>();
	}
	
}