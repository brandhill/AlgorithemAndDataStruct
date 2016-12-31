package ArraysProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// Time - O(n)
// Space - O(n)
public class MinimumNumberFromSequence {
	static int[] findMinNumber(char[] input) {
		int[] output = new int[input.length+1];
		int n = input.length+1;
		for(int i = input.length-1; i > 0; i--) {
			//System.out.println("i "+i);
			if(input[i]=='I') {
				output[i+1] = n--;
				int j = i+1;
				while(j < input.length && input[j]!='I') {
					//System.out.println("j "+j);
					output[j+1] = n--;
					j++;
				}
			}
		}
		if(input[0]=='I') {
			output[1] = n--;
			output[0] = n--;
		}
		else {
			output[0] = n--;
			output[1] = n--;
		}
		int i = 2;
		while(n>0) {
			output[i] = n--;
			i++;
		}
		
		System.out.println(Arrays.toString(output));
		return output;
	}
	
	public static void main(String[] args) {
		MinimumNumberFromSequence.findMinNumber("DIDID".toCharArray());
		MinimumNumberFromSequence.findMinNumber("D".toCharArray());
		MinimumNumberFromSequence.findMinNumber("I".toCharArray());
		MinimumNumberFromSequence.findMinNumber("DD".toCharArray());
		MinimumNumberFromSequence.findMinNumber("II".toCharArray());
		MinimumNumberFromSequence.findMinNumber("DIDI".toCharArray());
		MinimumNumberFromSequence.findMinNumber("IIDDD".toCharArray());
		MinimumNumberFromSequence.findMinNumber("DDIDDIID".toCharArray());
        //System.out.println(Arrays.toString(output));
	}
}
