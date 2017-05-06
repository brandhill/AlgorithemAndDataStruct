package CareerCup;

import java.util.Arrays;

// https://www.careercup.com/question?id=5742031851749376

public class DiamondShapeMatrixFindPathSum {
	
	static int findPathSum(int[][] matrix) {
		int mid = matrix.length/2;
		
		int[][] sumMatrix = CreateMatrixCopy(matrix);
		sumMatrix[0][0] = matrix[0][0];
		for(int i=0; i<sumMatrix.length; i++) {
			
			if(i<mid) {
				addSumHelperForAbove(matrix, sumMatrix,i);
			} else {
				addSumHelperForBelow(matrix, sumMatrix, i);
			}
		}
		System.out.println(Arrays.toString(sumMatrix[5]));
		return sumMatrix[sumMatrix.length-1][0];
	}
	
	private static int[][] CreateMatrixCopy(int[][] matrix) {	
		int[][] sumMatrix = new int[matrix.length][];
		for(int i=0; i<matrix.length; i++) {
			int[] temp = new int[matrix[i].length];
			sumMatrix[i] = temp;
		}
		
		return sumMatrix;
	}

	static void addSumHelperForAbove(int[][] matrix,int[][] sumMatrix, int row) {
		for(int j=0; j<matrix[row].length; j++) {
			int sum = matrix[row+1][j]+sumMatrix[row][j];
			sumMatrix[row+1][j] = sum>sumMatrix[row+1][j]?sum:sumMatrix[row+1][j];
			sum = matrix[row+1][j+1] + sumMatrix[row][j];
			sumMatrix[row+1][j+1] = sum>sumMatrix[row+1][j+1]?sum:sumMatrix[row+1][j+1];
		}
	}
	
	static void addSumHelperForBelow(int[][] matrix,int[][] sumMatrix, int row) {
		for(int j=0; j<matrix[row].length; j++) {
			int sum = 0;
			if(j>0) {
				sum = matrix[row+1][j-1] + sumMatrix[row][j];
				sumMatrix[row+1][j-1] = sum>sumMatrix[row+1][j-1]?sum:sumMatrix[row+1][j-1];
			}
			if(j<matrix[row].length-1) {
				sum = matrix[row+1][j] + sumMatrix[row][j];
				sumMatrix[row+1][j] = sum>sumMatrix[row+1][j]?sum:sumMatrix[row+1][j];
			}
		}
	}
 	
	public static void main(String[] args) {
		int[][]  matrix = {{2},{3,4},{6,5,7},{4,1,8,3},{2,5,4},{6,4},{1}};
		System.out.println(findPathSum(matrix));
		
	}
}
