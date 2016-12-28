package hackerrank.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BreadthFirstSearchShortestReach {
	
	static String ShortestReach(List<Number> list,Number root){
		int[] values = new int[list.size()];
		Arrays.fill(values, -1);
		Set<Number> set = new HashSet<Number>();
		set.add(root);
		ShortestReachHelper(root,1,values,set);
		StringBuffer s = new StringBuffer("");
		for(int i = 0; i < values.length; i++) {
			if(i!=root.num-1)
				s.append(values[i]+" ");
		}
		System.out.println();
		//System.out.println(s.toString());
		return s.toString();
	}
	
	static void ShortestReachHelper(Number root,int multiple,int[] values,Set<Number> set){
		
		Queue<Number> queue = new LinkedList<Number>();
		for(Number num : root.links) {
			if(num.num == 5)
				System.out.println( root.num+" "+num.num+" ");
			if(!set.contains(num) || values[num.num-1] == -1 || values[num.num-1] > multiple*6) {
				queue.add(num);
				set.add(num);
				
				//System.out.print( root.num+" "+num.num+" ");
				//if(values[num.num-1] == -1 || values[num.num-1] > multiple*6)
				values[num.num-1] = multiple*6;
			}
		}
		while(!queue.isEmpty()) {
			ShortestReachHelper(queue.poll(),multiple+1,values,set);
		}
	}
	
	public static void main(String[] args) {
		List<String> output = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		for( int i = 0; i < loop; i++) {
			List<Number> list = new ArrayList<Number>();
			int numbers = sc.nextInt();
			int count = sc.nextInt();
			for(int j = 0; j < numbers; j++){
				list.add(new Number(j+1));
			}
			
			for (int k = 0; k < count; k++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				list.get(num1-1).links.add(list.get(num2-1));
				list.get(num2-1).links.add(list.get(num1-1));
			}
			int number = sc.nextInt();
			/*for(Number n: list) {
				System.out.print(n.num+": ");
				for(Number l:n.links) {
					System.out.print(l.num+" ");
				}
				System.out.println();
			}*/
			
			//System.out.println(list.get(number-1).num);
			output.add(BreadthFirstSearchShortestReach.ShortestReach(list,list.get(number-1)));
			
		}
		
		for(String s: output) {
			System.out.println(s);
		}
		
	}
}

class Number{
	int num;
	List<Number> links;
	Number(int num){
		this.num = num;
		links = new ArrayList<Number>();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Number other = (Number) obj;
		if (num != other.num)
			return false;
		return true;
	}
}

//6 6 6 6 12 6 12 6 12 12 6 6 6 6 6 12 12 6 6 6 6 12 6 12 6 12 6 12 12 12 12 6 12 12 6 12 12 6 12 6 12 6 12 12 6 6 12 6 6 6 6 12 12 12 12 6 6 6 12 6 6 12 12 12 12 12 12 6 6  
//6 6 6 6 12 6 12 6 12 12 6 6 6 6 6 12 12 6 6 6 6 12 6 12 6 12 6 12 12 12 12 6 12 12 6 12 12 6 12 6 12 6 12 12 6 6 12 6 6 6 6 12 12 12 12 6 6 6 12 6 6 12 12 12 12 12 12 6 6

