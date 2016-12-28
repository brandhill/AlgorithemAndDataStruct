package ArraysAndStrings1;

import java.util.HashSet;
import java.util.Set;

public class CheckforZeroinMatrix7 {
	
	static int[][] checkForZeros(int[][] input){
		
		//int[][] output = new int[input.length][input[0].length];
		Set<Integer> index = new HashSet<Integer>();
		
		for ( int i = 0; i < input.length; i++) {
			for ( int j = 0; j < input[0].length; j ++) {
				if(!index.contains(j)) {
					if(input[i][j] == 0) {
						index.add(j);
						for ( int k=0; k < input[0].length; k++) {
							input[i][k] = 0;
							//input[k][j] = 0;
						}
						for ( int k=0; k < input.length; k++) {
							input[k][j] = 0;
						}
						break;
					}
				}
			}
		}
		
		for ( int i = 0; i < input.length; i++) {
			for ( int j = 0; j < input[0].length; j ++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
		//System.out.println(output);
		
		return input;
	} 
	
	public static void main(String[] args) {
		int[][] input = {{1,0,1,2,3,4},{2,2,2,4,2,1},{3,3,3,0,5,6}};
		CheckforZeroinMatrix7.checkForZeros(input);
	}
}
