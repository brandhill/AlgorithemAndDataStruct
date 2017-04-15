package VeryImportantQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfStreamNumbersHasNumbersEqualToGivenSum {
	
	boolean checkIfSumExists(int[] stream, int sum) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < stream.length; i++) {
			if(stream[i]<=sum) {
				if(set.contains(sum-stream[i]))
					return true;
				else
					set.add(stream[i]);
			}
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		return false;
	}
}
