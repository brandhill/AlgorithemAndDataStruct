package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsets {
	
	static List<List<Character>> findAllSubsets(char[] chars) {
		List<List<Character>> subsets = new ArrayList<List<Character>>();
		subsets.add(new ArrayList<Character>());
		findAllSubsetsHelper(chars,0,subsets);
		return subsets;
	}
	
	static void findAllSubsetsHelper(char[] str, int index, List<List<Character>> subsets) {
		if(index>=str.length)
			return;
		for(List<Character> list: subsets) {
			List<Character> temp = new ArrayList<Character>(list);
			temp.add(str[index]);
			subsets.add(temp);
		}
		findAllSubsetsHelper(str,index+1,subsets);
	}
	
	public static void main(String[] args) {
		char[] str = {'A','B','C'};
		System.out.println(findAllSubsets(str));
	}
}
