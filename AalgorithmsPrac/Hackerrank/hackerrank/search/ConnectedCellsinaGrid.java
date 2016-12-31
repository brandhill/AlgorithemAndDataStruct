package hackerrank.search;

import java.util.Scanner;

public class ConnectedCellsinaGrid {
	
	
	static int findLargestIsLand(int[][] array){
		boolean[][] check = new boolean[array.length][array[0].length];
		int count1 = 0;
		for ( int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if(array[i][j]==1 && !check[i][j]) {
					check[i][j] = true;
					count1 = Math.max(count1, findConnectedcells(array,check,i,j,1)); 
				}
			}
		}
		return count1;
	}
	
	static int findConnectedcells(int[][] array,boolean[][] check,int i,int j,int count) {
		int rowStart = Math.max(0, i-1);
		int rowEnd = Math.min(array.length-1, i+1);
		int colStart = Math.max(0, j-1);
		int colEnd = Math.min(array[0].length-1, j+1);
		for ( int r = rowStart; r <= rowEnd; r++) {
			for ( int c = colStart; c <= colEnd; c++) { 
				if(array[r][c]==1 && !check[r][c]) {
					check[r][c] = true;
					count  = findConnectedcells(array,check,r,c,count+1);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] array = new int[row][col];
		for ( int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		int count = ConnectedCellsinaGrid.findLargestIsLand(array);
		System.out.println(count);
	}
}
