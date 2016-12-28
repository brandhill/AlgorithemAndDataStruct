package ArraysProblems;

// http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/

public class MaxRepeatingNumber {
	
	static int findMaxRepeatNumber(int[] array) {
		int max = -1;
		int index = -1;
		int k = array.length;
		for(int i = 0; i < k; i++) {
			array[array[i]%k] += k ; 
		}
		for(int i = 0; i < k; i++) {
			if(array[i] > max) {
				max = array[i];
				index = i;
			} 
		}
		return index;
	}
	
	public static void main(String[] args) {
		//int[] array = {2, 3, 3, 5, 3, 4, 1, 7};
		int[] array = {0,0,0,0,3,4,5,9,9,9};
		int num = MaxRepeatingNumber.findMaxRepeatNumber(array);
		System.out.println(num);
	}
}
