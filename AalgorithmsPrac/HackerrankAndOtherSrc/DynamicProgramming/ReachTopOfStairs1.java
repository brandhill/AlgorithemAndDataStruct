package DynamicProgramming;

import java.util.Arrays;

import GraphsDataStructures.mainclass;

public class ReachTopOfStairs1 {

	static int NoOfWays(int n,int[] map) {
		
		if(n<0)
			return 0;
		else if(n==0)
			return 1;
		else if(map[n]>-1)
			return map[n];
		else {
			map[n] = NoOfWays(n-1,map)+NoOfWays(n-2,map)+NoOfWays(n-3,map);
		}
		return map[n];
	}
	
	public static void main(String[] args) {
		int[] map = new int[5];
		Arrays.fill(map, -1);
		//System.out.println(map[0]);
		int i = ReachTopOfStairs1.NoOfWays(4, map);
		System.out.println(i);
	}
}
