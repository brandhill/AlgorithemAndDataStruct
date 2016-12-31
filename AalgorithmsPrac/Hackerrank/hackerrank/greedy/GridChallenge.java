package hackerrank.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GridChallenge {
	
	static String ifIncreadOrder(char[][] grid) {
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = grid[0].length-1; j >= 1; j--) {
				for(int k = 0; k < j; k++) {
					if(grid[i][k] > grid[i][k+1]) {
							swap(grid,i,k,k+1);
						}
					}
				}
				if(i > 0) {
					for(int m = 0; m < grid[0].length;m++) {
						if(grid[i][m] < grid[i-1][m]) {
							return "NO";
						}
					}
				}
			}
		
		/*for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
					System.out.print(grid[i][j]);
				}
			System.out.println();
		}*/
		
		
		return "YES";
	}
	
	static void swap(char[][] grid,int i,int k1,int k2){
		char temp = grid[i][k1];
		grid[i][k1] = grid[i][k2];
		grid[i][k2] = temp; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		List<String> output = new ArrayList<String>();
		for (int j = 0; j < loop; j++) {
			int N = sc.nextInt();
			char[][] grid = new char[N][N];
			for(int i = 0; i < N; i++) {
				String s = sc.next();
				grid[i] = s.toCharArray();
			}
			output.add(GridChallenge.ifIncreadOrder(grid));
		}
		
		for ( int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
		
	}
}
