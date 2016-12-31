package ArraysProblems;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/missing-ranges/ , 
// https://github.com/mission-peace/interview/blob/master/src/com/interview/array/MissingRanges.java

// Time - O(n)

public class MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
    	List<String> list = new ArrayList<String>();
    	if(nums[0]>lower) {
    		if(Math.subtractExact(nums[0], lower)>1)
    			list.add(lower+"->"+(nums[0]-1));
    		else
    			list.add(lower+"");
    	}
    	for(int i = 0; i < nums.length-1; i++) {
    		int a = nums[i+1];
    		int b = nums[i];
    		if(a-b>1) {
    			if(a-1==b+1) {
    				list.add(a-1+"");
    			}
    			else {
    				list.add((b+1)+"->"+(a-1));
    			}
    		}
    	}
    	if(nums[nums.length-1]<upper) {
    		if(Math.subtractExact(upper, nums[nums.length-1])>1)
    			list.add((nums[nums.length-1]+1)+"->"+upper);
    		else
    			list.add(upper+"");
    	}
    	System.out.println(list.toString());
		return list;
    }
    
    public static void main(String[] args) {
		int[] arr = {1, 3, 10, 50, 75,99};
		MissingRanges.findMissingRanges(arr, 0, 99);
	}
}
