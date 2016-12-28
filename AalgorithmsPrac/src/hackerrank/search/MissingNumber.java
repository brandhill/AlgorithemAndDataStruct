package hackerrank.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MissingNumber {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1); 
			}
			else {
				map.put(num,1);
			}
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int num = sc.nextInt();
			if(map.containsKey(num)) {
				map.put(num, map.get(num)-1); 
			}
			else {
				map.put(num,1);
			}
		}
		for (Integer i : map.keySet()) {
			int count = map.get(i);
			//System.out.println(i+" "+count);
				if( count != 0 ) {
					System.out.print(i+" ");
				}
			}
	}
		
}
