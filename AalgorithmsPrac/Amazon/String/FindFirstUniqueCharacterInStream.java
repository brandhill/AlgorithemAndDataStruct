package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindFirstUniqueCharacterInStream {
	// time  -  O(n)
	// space -  O(n)
	static char findUnique(String s) {
//		char c = 0;
		Map<Character,number> map = new HashMap<Character,number>();
		Set<Character> set = new HashSet<Character>();
//		Map<Character,number> map = new TreeMap<Character,number>();
		number last = null;
		number first = null;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!set.contains(c)) {
				if(map.containsKey(c)) {
					number temp = map.get(c);
					if(temp == first) {
						first = first.prev;
					}
					else {
						if(temp.prev!=null)
							temp.prev.next = temp.next;
						temp.next.prev = temp.prev;
					}
					map.remove(c);
					set.add(c);
				}
				else {
					number n = new number();
					n.c = c;
					if(last==null || first==null) {
						last = n;
						first = n;
						
					}
					else {
						last.prev = n;
						n.next = last;
						last = n;
					}
					map.put(c, n);
				}
			}
		}
		if(first == null)
			return ' ';
		else 
			return first.c;
	}
	
	public static void main(String[] args) {
		char c = findUnique("abcdfqxbacds");
		System.out.println(c);
	}
}

class number{
	char c;
	number next;
	number prev;
}
