package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Identify all combinations where one words can be composed of two or more words of the same list, and print them.

public class WordList {
	
	
public static  List<List<String>> getAllValidCombinationSubStrings(String input, Set<String> dict) {
        
        List<List<String>> output = new ArrayList<List<String>>();
        getAllValidCombinationSubStringsHelper(input, 0, input.length(), dict, output, new ArrayList<String>());
        return output;
    }
    
    private static void getAllValidCombinationSubStringsHelper(String input, int start, int end, Set<String> dict, List<List<String>> output, List<String> list) {
        
        if(start==end) {
        	System.out.println(list);
            output.add(new ArrayList<String>(list));
        }
        
        for(int i= start; i<end; i++) {
            String subString = input.substring(start,i+1);
            if(dict.contains(subString)) {
                list.add(subString);
                getAllValidCombinationSubStringsHelper(input, i+1, input.length(),dict, output, list);
                list.remove(list.size()-1);           
            }
            
        }

    }
    
    public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("superhighway");
		dict.add("super");
		dict.add("highway");
		dict.add("high");
		dict.add("way");
		dict.add("superhigh");
		List<List<String>> output = getAllValidCombinationSubStrings("superhighway",dict);
		System.out.println(output);
	}
}
