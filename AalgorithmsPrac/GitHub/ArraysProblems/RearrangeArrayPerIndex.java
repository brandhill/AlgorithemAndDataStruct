package ArraysProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// http://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/


public class RearrangeArrayPerIndex {
	
	//Time - O(n)
	//Space - O(n)
	 public void rearrange(int input[]) {
		 boolean[] check = new boolean[input.length];
		 for(int i = 0; i < input.length; i++) {
			 int index = input[i];
			 int val = i;
			 //System.out.println("i "+i);
			 while(!check[val]) {
				 //System.out.println(val);
				 check[val] = true;
				 int temp = input[index];
				 input[index] = val;
				 val = index;
				 index = temp;
			 }
		 }
		 
		 System.out.println(Arrays.toString(input));
	 }
	 //[1,2,0,5,3,4]
	 public static void main(String args[]) {
	        RearrangeArrayPerIndex rai = new RearrangeArrayPerIndex();
	        int input[] = {1, 3, 0, 2};
	        int input1[] = {2, 0, 1, 4, 5, 3};
	        int input2[] = {0, 1, 2, 3};
	        int input3[] = {3, 2, 1, 0};
	        rai.rearrange(input);
	        rai.rearrange(input1);
	        rai.rearrange(input2);
	        rai.rearrange(input3);
	        //Arrays.stream(input).forEach(i -> System.out.print(i + " "));
	    }
}
