package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.List;

// https://www.careercup.com/question?id=5725965217955840

// Incomplete
public class DivideTheArrayIntoEqualWeightBuckets {
	
	List<List<Integer>> divideArray(int[] input, int k) {
		
		int sum = 0;
		
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		if(sum%k!=0) {
			return null;
		}
		
		sum = sum/k;
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		int i = 0;
		int j = input.length-1;
		if(input[j]>sum)
			return null;
		while(input[j]==sum) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(input[j]);
			output.add(list);
		}
		
		return output;
	}
}
