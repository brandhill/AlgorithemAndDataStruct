package VeryImportantQuestions;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArrayWithEqualProbability {
	
	static void ShuffleArray(int[] array) {
		
		Random rand = new Random();
		for(int i =0; i < array.length; i++) {
			int index = i + (Math.abs(rand.nextInt())%(array.length-i));
			swap(i,index,array);
		}
	}
	
	static void swap(int index1, int index2, int[] array) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		ShuffleArray(array);
		System.out.println(Arrays.toString(array));
	}
}
