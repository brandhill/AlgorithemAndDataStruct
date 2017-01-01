package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

// Time - O(n*m) -- n - size of string, m - size of string array
// Space - O(m)
public class SubtringWithConcatentationOfWords {
	static public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<Integer>();
        if(s==null || s.trim().length()==0 || words.length==0)
        	return output;
        Map<String,Integer> map = new HashMap<String,Integer>();
        Map<String,Integer> tempMap = new HashMap<String,Integer>();
        int actualSize = words.length;
        // Store the words and count in map
        for(int i = 0; i < words.length; i++) {
        	String n = words[i];
        	if(map.containsKey(n)) {
        		map.put(n, map.get(n)+1);
        	}
        	else {
        		map.put(n, 1);
        	}
         }
        //slow pointer
        int j = 0;
        // fast pointer
        int i = 0;
        // runningSize will store number of words we found in the running loop between i & j
        int runningSize = 0;
        while(i <= s.length()-words[0].length()) {
        	String s1 = s.substring(i,i+words[0].length());
        	// if s1 is present in the map
        	if(map.containsKey(s1)) {
        		// check if s1 is already added into tempMap
        		if(tempMap.containsKey(s1)) {
        				tempMap.put(s1, tempMap.get(s1)+1);
        				// check if count s1 in 'tempMap' is more than count of s1 is 'map'
        				// if true increment slow pointer 'j' till the condition becomes false
        				while(tempMap.get(s1)>map.get(s1)) {
        					String s2 = s.substring(j,j+words[0].length());
        					tempMap.put(s2, tempMap.get(s2)-1);
        					// decrement runningSize as we are decrementing count int tempMap
        					runningSize--;
        					//System.out.println(i+" "+j+" "+runningSize);
        					// if runningSize is 0 then we clear tempMap and start searching again from j++
        					if(runningSize==0) {
        						j++;
        						i = j;
        						tempMap.clear();
        						break;
        					}
        					j += words[0].length();
        				}
        				if(runningSize==0) 
                			continue;
        			}
        		// else add add s1 into tempMap
        		else {
        			tempMap.put(s1, 1);
        		}
        		i += words[0].length();
        		runningSize++;
        	}
        	// if s1 is not present in map then we clear tempMap and start searching again from j++ 
        	else {
    			runningSize = 0;
    			tempMap.clear();
    			j++;
    			i=j;
    		}
        	
        	// if runningSize == actualSize then we found the substring.
        	if(runningSize==actualSize) {
        		output.add(j);
        		// we clear tempMap and start searching again from j++
        		runningSize = 0;
    			tempMap.clear();
    			j++;
    			i=j;
        	}
        }
       //System.out.println(output.toString());
        return output;
    }
	
	public static void main(String[] args) {
		//String s = "barfoothefoobarman";
		//String[] words = {"foo", "bar"};
		//String s = "aaaaaaaa";
		//String[] words = {"aa","aa","aa"};
		//String s = "ababaab";
		//String[] words = {"ab","ba","ba"};
		String s = "abaababbaba";
		String[] words = {"ab","ba","ab","ba"};
		SubtringWithConcatentationOfWords.findSubstring(s, words);
	}
}
