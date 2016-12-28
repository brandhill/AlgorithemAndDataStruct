package ArraysProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonThreeSortedArray {
	
	//Elements not sorted
	// Time - O(m+n+k)
	// Space -O(m+n+k)
	public List<Integer> commonElements(int input1[], int input2[], int input3[]){
		
		if ( input1.length < 1 || input2.length < 1 || input3.length < 1) {
			return null;
		}
		
		Set<Integer> set1 = new HashSet<Integer>();
		for (int i = 0; i < input1.length; i++) {
			set1.add(input1[i]);
		}
		Set<Integer> set2 = new HashSet<Integer>();
		for (int i = 0; i < input2.length; i++) {
			if(set1.contains(input2[i])){
				set2.add(input2[i]);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < input3.length; i++) {
			if(set2.contains(input3[i])){
				list.add(input3[i]);
			}
		}
		return list;
	}
	
		//Elements not sorted
		// Time - O(m+n+k)
		public List<Integer> commonElements1(int input1[], int input2[], int input3[]){
			
			int i = 0;
			int j=0;
			int k=0;
			
			List<Integer> list = new ArrayList<Integer>();
			
			while( i < input1.length && j < input2.length && k < input3.length) {
				if(input1[i]==input2[j] && input1[i]==input3[k]) {
					list.add(input1[i]);
					i++;
					j++;
					k++;
				}
				else {
					int min = Math.min(input1[i], Math.min(input2[j], input3[k]));
					if(min == input1[i]){
						i++;
					}
					if(min == input2[j]){
						j++;
					}
					if(min == input3[k]){
						k++;
					}
				}
			}
			
			return list;
		}
	public static void main(String[] args) {
        //int input1[] = {1, 5, 10, 20, 40, 80};
        //int input2[] = {6, 7, 20, 80, 100};
        //int input3[] = {3, 4, 15, 20, 30, 70, 80, 120};
		int input1[] = {1, 5, 5,10};
        int input2[] = {3, 4, 5, 5, 10};
        int input3[] = {5, 5, 10, 20}
;
        CommonThreeSortedArray cts = new CommonThreeSortedArray();
        List<Integer> result = cts.commonElements1(input1, input2, input3);
        result.forEach(i -> System.out.print(i + " "));
	}
}
