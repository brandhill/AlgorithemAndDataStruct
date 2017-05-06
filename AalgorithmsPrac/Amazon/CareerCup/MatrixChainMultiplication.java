package CareerCup;

public class MatrixChainMultiplication
{
    static int matrixChain(int[] array) {
    	int[][] max = new int[array.length][array.length];
    	
    	matrixChainerHelper(array,1,array.length-1,max);
//    	int n = array.length;
//    	for(int a=0; a<n; a++) {
//        	for (int b=0; b<n; b++) {
//        		System.out.print(max[a][b]+" ");
//        	}
//        	System.out.println();
//        }
    	return max[1][array.length-1];
    }
    
    static int matrixChainerHelper(int[] array, int i, int j, int[][] max) {
    	if(i==j)
    		return 0;
    	if(max[i][j]!=0) 
    		return max[i][j];
    	for(int k=i; k<j; k++) {
        	int count = matrixChainerHelper(array,i,k,max) + matrixChainerHelper(array,k+1,j,max) 
        					+ (array[i-1]*array[k]*array[j]);
        	
        	if(max[i][j]==0 || count<max[i][j])
        		max[i][j] = count;
    	}
    	
    	return max[i][j];
    }
    
    // Driver program to test above function
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println("Minimum number of multiplications is "+
        		matrixChain(arr));
    }
}
