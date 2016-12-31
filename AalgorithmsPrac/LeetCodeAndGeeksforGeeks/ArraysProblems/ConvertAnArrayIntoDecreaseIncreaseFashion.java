package ArraysProblems;

import java.util.Arrays;

public class ConvertAnArrayIntoDecreaseIncreaseFashion {
	
	// Time - O(n * log n)
	static public int[] convert(int[] input){
		
		int k = 0;
		int m = 0;
		Arrays.sort(input);
		System.out.println(Arrays.toString(input));
		int[] output = new int[input.length];
		if(input.length%2==0) {
			k = input.length/2;
		}
		else {
			k = input.length/2 +1;
			output[input.length-1] = input[k-1];
		}
		
		for(int i = 0;i < input.length-1; i=i+2) {
			output[i] = input[m];
			output[i+1] = input[k];
			m++;
			k++;
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
	
static public int[] convert1(int[] input){
		
		Arrays.sort(input);
		//System.out.println(Arrays.toString(input));
		for(int i = 1;i < input.length-1; i=i+2) {
			int temp = input[i];
			input[i] = input[i+1];
			input[i+1] = temp;
		}
		//System.out.println(Arrays.toString(input));
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = {0,6,9,13,10,-1,8,2,4,14,-5};
		ConvertAnArrayIntoDecreaseIncreaseFashion.convert1(input);
		System.out.println(Arrays.toString(input));
	}
}
