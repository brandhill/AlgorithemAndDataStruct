package hackerrank.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PosinousPlant {
	
	static int  dayForNonPosinousPlants(List<Integer> list){
		int previous = 0;
		int current;
		int count = -1;
		if(list.size()<=1 )
			return 0 ;
		while(true){
			List<Integer> lookUp = new ArrayList<Integer>();
			current = list.size();
			if(current == previous){
				return count;
			}
				
			lookUp.add(list.get(0));
			for(int i = 1; i < list.size(); i++) {
				int v1 = list.get(i);
				int v2 = list.get(i-1);
				if(v1<=v2)
					lookUp.add(v1);
			}
			count++;
			previous = current;
			list = lookUp;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
       List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i < n; i++){
			list.add(in.nextInt());
        }
		System.out.println(PosinousPlant.dayForNonPosinousPlants(list));
	}
}
