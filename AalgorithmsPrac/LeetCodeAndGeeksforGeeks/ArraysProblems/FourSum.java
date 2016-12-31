package ArraysProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	static public List<List<Integer>> fourSum(int[] num,int target){
		//Set<String> output = new HashSet<String>();
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		for(int i = 0; i <= num.length-4; i++) {
			System.out.println(i);
			if(i!=0 && num[i]==num[i-1])
				continue;
			System.out.println(i);
			System.out.println(num[i]+num[i+1]+num[i+2]+num[i+3] +" "+ target);
			if(num[i]+num[i+1]+num[i+2]+num[i+3] > target)
				break;
			if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3] < target)
				continue;
			System.out.println(i);
			for(int j = i+1; j <= num.length-3; j++) {
				if(j!=i+1 && num[j]==num[j-1])
					continue;
				if(num[i]+num[j]+num[j+1]+num[j+2] > target)
					break;
				if(num[i]+num[j]+num[num.length-1]+num[num.length-2] < target)
					continue;
					
					int low = j+1;
					int high = num.length - 1;
					System.out.println(low+" "+high);
					while(low<high) {
						if (low != j + 1 && num[low] == num[low - 1]) {
	                        low++;
	                        continue;
	                    }
	                    if (high != num.length - 1 && num[high] == num[high + 1]) {
	                        high--;
	                        continue;
	                    }
						int sum = num[i]+num[j]+num[low]+num[high];
						System.out.println(sum);
						if(sum==target) {
							List<Integer> list = new ArrayList<Integer>();
							list.add(num[i]);
							list.add(num[j]);
							list.add(num[low]);
							list.add(num[high]);
							output.add(list);
							low++;
							high--;
						} 
						else if(sum<target) {
							low++;
						}
						else {
							high--;
						}
					}
							
				}
			}
		/*for(int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i).toString());
		}*/
		
		return output;
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 4, 5, 9, 11};
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = FourSum.fourSum(nums1, target);
        result.forEach(System.out::print);
        System.out.println("completed");
	}
}
