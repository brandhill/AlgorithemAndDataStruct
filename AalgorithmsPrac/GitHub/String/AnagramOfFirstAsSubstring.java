package String;

import java.util.HashMap;
import java.util.Map;

// https://www.careercup.com/question?id=5389078581215232

// Time - O(n)
// Space - O(k) - k is size of smaller
public class AnagramOfFirstAsSubstring {
	public boolean isSubString(char str1[], char str2[]) {
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(Character c:str1) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		int i = 0;
		while(i+str1.length<=str2.length) {
			boolean check = false;
			for(int j = i; j <i+str1.length;j++) {
				char c = str2[j];
				// Check if 'c' is present in str1
				if(map.containsKey(c)) {
					// Check if count of 'c' in str2 is already met
					if(map.get(c)==0) {
						// Increment i till count of 'c' in substring in met i.e. 0 in map 
						while(str2[i]!=c) {
							// Increment values other characters in the map while incrementing i
							map.put(str2[i], map.get(str2[i])+1);
							i++;
						}
						i++;
					}
					else {
						// count of 'c' is decremented by 1
						map.put(c, map.get(c)-1);
					}
				}
				else {
					// if char 'c' is not found in the map then we start the substring from j+1
					check = true;
					// move pointer i to j-1 and increment the values other characters in the map while incrementing i
					while(i<j) {
						char c1 = str2[i];
						map.put(c1, map.get(c1)+1);
						i++;
					}
					// set i = j+1
					i = j+1;
					break;
				}
			}
			// Check if all the values in the map are '0', if 'true' substring is found
			if(!check && checkIfEmpty(map))
				return true;
		}
		
		return false; 
	}
	
	boolean checkIfEmpty(Map<Character,Integer> map) {
		for(Character c: map.keySet()) {
			if(map.get(c)!=0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		AnagramOfFirstAsSubstring ana = new AnagramOfFirstAsSubstring();
		char str1[] = "aaabccde".toCharArray();
        char str2[] = "tbcdaacaaecbd".toCharArray();
        //char str1[] = "abcdefg".toCharArray();
        //char str2[] = "abcfedgsfdaf".toCharArray();
		//char str1[] = "a".toCharArray();
        //char str2[] = "cdsgsdgsa".toCharArray();
		//char str1[] = "abc".toCharArray();
        //char str2[] = "ccccccabbbbbbb".toCharArray();
		//char str1[] = "abc".toCharArray();
        //char str2[] = "edf".toCharArray();
        System.out.println(ana.isSubString(str1, str2));
    }
}
