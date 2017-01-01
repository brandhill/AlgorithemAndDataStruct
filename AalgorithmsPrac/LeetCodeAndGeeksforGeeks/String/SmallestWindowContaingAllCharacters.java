package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestWindowContaingAllCharacters {
	
	public String minWindow(String s, String t) {
		if(s==null || t==null || s.trim().length()==0 ||t.trim().length()==0)
			return "";
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		Map<Character,Integer> tempMap = new HashMap<Character,Integer>();
		Set<Character> set = new HashSet<Character>();
		for(Character c:t.toCharArray()) {
			set.add(c);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
				tempMap.put(c, tempMap.get(c)+1);
			}
			else {
				map.put(c, 1);
				tempMap.put(c, 1);
			}
		}
		
		//System.out.println(set.toString());
		int count = 0;
		int i = 0;
		int j = 0;
		int minI = -1;
		int minJ = -1;
		int minLen = Integer.MAX_VALUE;
		while(j<s.length() && i < s.length()) {
			char c = s.charAt(j);
			//System.out.println(i+" "+j);
			if(map.containsKey(c)) {
				Integer n = tempMap.get(c);
				//System.out.println(n);
				tempMap.put(c, (n==null?0:n)-1);
				if(tempMap.get(c)==0) {
					tempMap.remove(c);
					set.remove(c);
				}
					
				//System.out.println("first loop "+tempMap.toString());
			}
			while(i<s.length() && (set.isEmpty() || j-i+1>minLen || j == s.length()-1)) {
				//System.out.println(i+" "+j);
				//System.out.println(set.toString());
				if(set.isEmpty()) {
					if(minLen>(j-i+1)) {
						minI = i;
						minJ = j;
						minLen = minJ-minI+1;
						//System.out.println("minLen "+minLen);
					}
				}
				
				char c1 = s.charAt(i);
				if(map.containsKey(c1)) {
					if(tempMap.containsKey(c1)) {
						tempMap.put(c1, tempMap.get(c1)+1);
						if(tempMap.get(c1)==0)
							tempMap.remove(c1);
					}
					else {
						tempMap.put(c1, 1);
						set.add(c1);
					}
				}
				//System.out.println("second loop "+tempMap.toString());
				i++;
			}
			
			j++;
		}
		if(minI==-1)
			return "";
		else
			return s.substring(minI,minJ+1);
    }
	
	public static void main(String[] args) {
					//0123456789101112
		//String str = "ADOBECADEBANC";
        //String subString = "AABC";
					//01234567891011121314151617181920212223242526	
					//Tsuaosyogrl m n s l u u o r j k o r u o s t
        String str = "Tsuaosyogrlmnsluuorjkoruost";
        String subString = "";
        SmallestWindowContaingAllCharacters swcac = new SmallestWindowContaingAllCharacters();
        String result = swcac.minWindow(str, subString);
        System.out.println(result);
	}
}
