package hackerrank.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		int k = sc.nextInt();
		int luck = 0;
		List<Integer> list = new ArrayList<Integer>();
		for( int i = 0; i < loop; i++) {
			int l = sc.nextInt();
			int imp = sc.nextInt();
			if(imp == 1) {
				list.add(l);
			}
			else {
				luck += l; 
			}
		}
		Collections.sort(list, Collections.reverseOrder());
		for ( int i = 0; i < list.size(); i++) {
			if(k>0) {
				luck += list.get(i);
				k--;
			}
			else {
				luck -= list.get(i);
			}
		}
		
		System.out.println(luck);
	}
}
