package CareerCup;

// https://www.careercup.com/question?id=5121919756009472

public class RotateMatrix {
	
	static void rotatematrix(int[][] matrix) {
		
		rotatematrixHelper(matrix,0,matrix.length-1,1);
	}
	
	static void rotatematrixHelper(int[][] matrix,int Start, int End, int n) {
		int len = End-Start+1;
		if(len<2)
			return;
		System.out.println(Start+" "+End);
		for(int k =0; k<n; k++) {
		int i=Start;
		int j=Start+1;
		int value = matrix[Start][Start];
		while(j<Start+len) {
			value = swap(matrix, value, i, j);
			j++;
		}
		j--;
		i++;
		while(i<Start+len) {
			value = swap(matrix, value, i, j);
			i++;
		}
		i--;
		j--;
		while(j>=Start) {
			value = swap(matrix, value, i, j);
			j--;
		}
		j++;
		i--;
		while(i>=Start) {
			value = swap(matrix, value, i, j);
			i--;
		}
		}
		rotatematrixHelper(matrix,Start+1,End-1,1);
	}
 	
	private static int swap(int[][] matrix, int value,int i, int j) {
		int temp = matrix[i][j];
		matrix[i][j] = value;
		return temp;
	}
	
	
	static void rotateBy90Degrees(int[][] matrix) {
		helper(matrix, 0, matrix.length-1);
	}
	
	static void helper (int[][] matrix, int start, int end) {
		if(start>=end)
			return;
		int i = start;
		while(i<end) {
			int temp = matrix[start][i];
			temp = swap(matrix,temp,start+i, end);
			temp = swap(matrix,temp,end, end-i);
			temp = swap(matrix,temp,end-i, start);
			temp = swap(matrix,temp,start, i);
			i++;
		}
		helper(matrix, start+1, end-1);
	}
	
	static void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{10,20,30,40,10},{40,50,60,11,-1},{70,80,90,12,-3},{-1,-2,-3,-4,-5},{12,13,14,15,16}};
		printMatrix(matrix);
//		rotatematrix(matrix);
		rotateBy90Degrees(matrix);
		System.out.println("-----");
		printMatrix(matrix);

	}
}
