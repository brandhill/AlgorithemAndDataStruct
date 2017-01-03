package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CombinationSum {
	Map<Integer, Integer> map = new HashMap<>();
    public int combinationSum41(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length ==0 || target < 0 ) return 0;
        if ( target ==0 ) return 1;
        if (map.containsKey(target)) return map.get(target);
        for (int num: nums){
            count += combinationSum4(nums, target-num);
        }
        map.put(target, count);
        return count;
    }
    public int combinationSum4(int[] nums, int target) {
    	return combination(nums,target,0);
    }
public int combination(int[] nums, int target,int output) {
    	int count = 0;
    	if(nums == null || nums.length == 0 || target < 0) return 0;
    	if(target == 0) return 1;
		for(int i = 0; i < nums.length; i++){
			if(output == target){
				return count+1;
			}
			else if(output<target){
				count +=combination(nums,target,output+nums[i]);
			}
			else if(output>target){
				break;
			}
		}
		return  count;
		
    }
    
public static void main(String[] args) {
	CombinationSum CS = new CombinationSum();
	Scanner in = new Scanner(System.in);
	String inputs = in.nextLine();
	int target = in.nextInt();
	inputs = inputs.substring(1, inputs.length()-1);
	String[] nums1 = inputs.split(",");
	int[] nums = new int[nums1.length];
	for(int i = 0; i < nums1.length; i++){
		nums[i] = Integer.valueOf(nums1[i]);
	}
	long startTime1 = System.currentTimeMillis();
	System.out.println(CS.combinationSum4(nums,target));
	long endTime1   = System.currentTimeMillis();
	long totalTime1 = endTime1 - startTime1;
	System.out.println(totalTime1);
	
	long startTime = System.currentTimeMillis();
	System.out.println(CS.combinationSum41(nums,target));
	long endTime   = System.currentTimeMillis();
	long totalTime = endTime - startTime;
	System.out.println(totalTime);
	//System.out.println(CS.map.size());
	
}
    
    
}
