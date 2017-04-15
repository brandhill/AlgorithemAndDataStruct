package Arrays;

import java.util.Arrays;

public class SuffleArray {
	
	static void suffleArrays(int[] array) {
		int n = array.length;
		for(int i = 0; i < array.length; i++) {
			int x = (int) (Math.random() * (n-i));
//			System.out.println("x "+x);
			int r = i + x;
//			System.out.println("r "+r);
			int temp = array[r];
			array[r] = array[i];
			array[i] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		suffleArrays(array);
		System.out.println(Arrays.toString(array));
	}
}
