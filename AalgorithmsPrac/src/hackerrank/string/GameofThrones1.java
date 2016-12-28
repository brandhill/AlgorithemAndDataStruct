package hackerrank.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class GameofThrones1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int odd = s.length()%2==0?0:1;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
			for ( int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(!map.containsKey(c)) {
					map.put(c, 1);
				}
				else {
					map.put(c, map.get(c)+1);
				}
			}
			
			Iterator<Integer> it =  map.values().iterator();
			
			while(it.hasNext()) {
				int i = it.next();
				if(i%2!=0){
					odd--;
				}
				if(odd<0){
					break;
				}
			}
			
			if(odd<0){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}
	}
}
