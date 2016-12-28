package ArraysProblems;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/longest-consecutive-sequence/
// *****

public class LongestConsecutiveSubsequence {
	public int longestConsecutive(int[] nums) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		int result = 1;
		
		for(int s: nums) {
			if(map.containsKey(s))
				continue;
			
			int left = map.containsKey(s-1)?map.get(s-1):0;
			int right = map.containsKey(s+1)?map.get(s+1):0;
			int count = left+right+1;
			map.put(s, count);
			result = Math.max(count, result);
			map.put(s-left, count);
			map.put(s+right, count);
			
		}
		return result;
    }

    public static void main(String args[]) {
        LongestConsecutiveSubsequence lcs = new LongestConsecutiveSubsequence();
        int[] input = {100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(input));
    }
}
