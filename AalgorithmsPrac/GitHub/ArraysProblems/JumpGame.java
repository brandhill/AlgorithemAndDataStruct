package ArraysProblems;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/jump-game-ii/


public class JumpGame {
	 public boolean canJump(int[] nums) {
		int jump = 0;
		int i;
		for(i = 0; i < nums.length && i <=jump; i++) {
			jump = Math.max(jump, nums[i]+i);
		}
		return i==nums.length;
	 }
	 public int Jump(int[] nums) {
	        int current = 0;
	        int max = 0;
	        int count = 0;
	        for (int i = 0; i < nums.length - 1; i++) {
	            max = Math.max(max, i + nums[i]);
	            if (current == i) {
	                count++;
	                System.out.println(i+" "+count);
	                current = max;
	                System.out.println(current);
	            }
	        }
	        return count;
	    }
	 
	 public boolean canJump1(int[] nums) {
		 if(nums.length==1) {
		     return true;
		 }
		 int minIndex = -1;
		 int pointer = nums.length-2;
		 int count = 0;
		 for(int i = nums.length-1; i>0;) {
			 if(nums[pointer]+pointer>=i) {
				 minIndex = pointer;
			 }
			 else if(minIndex!=-1){
				 i = minIndex;
				 minIndex = -1;
				 pointer++;
				 count++;
			 }
			 pointer--;
			 if(pointer<0) {
			     if(minIndex==0) {
			    	 if(i!=0)
			    		 count++;
			    	 System.out.println(count);
				    return true;
			     }
			     else {
			         return false;
			     }
			 }
		 }
		 
		return false;
	 }
	 
	 public static void main(String args[]) {
	        JumpGame jumpGame = new JumpGame();
	        int[] nums = {3, 2, 2, 1, 0, 1};
	        System.out.println(jumpGame.canJump(nums));
	        System.out.println(jumpGame.Jump(nums));
	        int[] nums1 = {3, 0, 2, 0, 0, 1};
	        System.out.println(jumpGame.canJump(nums1));
	        System.out.println(jumpGame.Jump(nums1));
	    }
}
