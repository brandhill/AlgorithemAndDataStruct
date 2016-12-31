package ArraysProblems;

import java.util.Arrays;

// http://www.geeksforgeeks.org/reorder-a-array-according-to-given-indexes/

// Time - O(n)
// Space - O(1)
public class ReorderArrayByIndex {
	public void reorder(int input[], int indexs[]) {
		int index;
		int val;
		for (int i = 0; i < input.length; i++) {
			 index= indexs[i];
			 val = input[i];
			 System.out.println("i "+i);
			 while(indexs[i]!=i) {
				 System.out.println("index "+index);
				 int tempIndex = indexs[index];
				 int tempVal = input[index];
				 indexs[index] = index;
				 input[index] = val;
				 if(index==i) {
					 break;
				 }
				 index = tempIndex;
				 val = tempVal;
			 }
		}
		
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(indexs));
	}
	
	public static void main(String[] args) {
		ReorderArrayByIndex reorderArrayByIndex = new ReorderArrayByIndex();
		int input[] = {50, 40, 70, 60, 90};
        int index[] = {3,  0,  4,  1,  2};
        reorderArrayByIndex.reorder(input, index);
        int input1[] = {50, 40, 70, 60, 90};
        int index1[] = {3,  1,  4,  0,  2};
        reorderArrayByIndex.reorder(input1, index1);
	}
}
