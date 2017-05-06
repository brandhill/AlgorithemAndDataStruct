package CareerCup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.careercup.com/question?id=5140055074013184

public class FindMaxPathInMatrix {
	
	static int findMaxSum(List<List<Integer>> matrix) {
//		List<List<Integer>> sum = new ArrayList<List<Integer>>();
		int size = matrix.size()-1;
		int[][] sum = new int[matrix.size()][matrix.get(size).size()];
		findMaxSumHelper(matrix, sum, 0, 0, 0);
		int maxSum = Integer.MIN_VALUE;
		for(int i=0; i<matrix.get(size).size(); i++) {
			if(maxSum<sum[size][i]) {
				maxSum=sum[size][i];
			}
		}
		return maxSum;
	}
	
	static void findMaxSumHelper(List<List<Integer>> matrix, int[][] sumMatrix, int row, int column, int sum) {
		
		if(column <0 || column>matrix.get(row).size()-1)
			return;
		if(sum<=sumMatrix[row][column] && !(row==0 && column==0)) {
			return;
		}
		sum += matrix.get(row).get(column);
		if(sum>sumMatrix[row][column]) {
			sumMatrix[row][column] = sum;
		} else
			return;
		if(row==matrix.size()-1) {
			return;
		}
		
		findMaxSumHelper(matrix, sumMatrix, row+1, column-1, sum);
		findMaxSumHelper(matrix, sumMatrix, row+1, column, sum);
		findMaxSumHelper(matrix, sumMatrix, row+1, column+1, sum);
	}
	
	public static void main(String[] args) {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(55);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(94);
		list2.add(48);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(95);
		list3.add(30);
		list3.add(96);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(77);
		list4.add(71);
		list4.add(26);
		list4.add(67);
		matrix.add(list1);
		matrix.add(list2);
		matrix.add(list3);
		matrix.add(list4);
		System.out.println(findMaxSum(matrix));
	}
	
}


