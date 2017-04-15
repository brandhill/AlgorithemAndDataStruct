package VeryImportantQuestions;

import java.util.Arrays;

// A man is walking up a set of stairs. He can either take 1 or 2 steps at a time. Given n
// number of steps, find out how many combinations of steps he can take to reach the top of the stairs.

public class CominationsToReachTopStairs {
	
	static int combinationToClimbStairs(int stairs) {
		int[] map = new int[stairs];
		Arrays.fill(map, -1);
		return combinationToClimbStairs(stairs, map);
	}
	
	private static int combinationToClimbStairs(int stairs, int[] map) {
		if(stairs<0)
			return 0;
		else if(stairs==0)
			return 1;
		else if(map[stairs-1]!=-1)
			return map[stairs-1];
		map[stairs-1] = combinationToClimbStairs(stairs-1, map) + combinationToClimbStairs(stairs-2, map) 
					+ combinationToClimbStairs(stairs-3, map);
		return map[stairs-1];
	}
	
	
	public static int combinations(int stairs)
	{
	if(stairs == 0)
	return 0;
	int i = 0;
	int j = 1;
	for(int k = 0; k <= stairs; k++)
	{
	int temp = j;
	j+= i;
	i = temp;
	}
	return i;
	}
	public static void main(String[] args) {
		System.out.println(combinationToClimbStairs(20));
		System.out.println(combinations(20));
	}
}
