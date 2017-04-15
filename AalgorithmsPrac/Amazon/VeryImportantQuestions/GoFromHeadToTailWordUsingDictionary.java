package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GoFromHeadToTailWordUsingDictionary {
	public char[] chars ;
	
	void GoFromHeadToTailWordUsingDictionary() {
		chars = new char[26];
		for(int i = 97; i <=122; i++) {
			chars[i-97] = (char)i;
		}	
	}
	
			
	List<String> getPath(Set<String> dictionary, String start, String end) {
		List<String> output = new ArrayList<String>();
		if(start.length()!=end.length())
			return null;
		boolean[] check = new boolean[start.length()];
		getPathHelper(dictionary,start.toCharArray(),end.toCharArray(),output,check);
		System.out.println(output.size());
		if(output.get(output.size()-1).equals(end))
			return output;
		else
			return null;
	}
	
	void getPathHelper(Set<String> dictionary, char[] start, char[] end,List<String> output,boolean[] check) {
		if(checkIfEqual(start,end))
			return;
		for(int i = 0; i < start.length; i++) {
			if(check[i])
				continue;
			char temp = start[i];
			start[i] = end[i];
			String s = Arrays.toString(start);
			if(dictionary.contains(s)) {
				dictionary.remove(s);
				check[i] = true;
				output.add(s);
				getPathHelper(dictionary,start,end,output,check);
				return;
			}
			else{
				start[i] = temp;
			}
		}
		
		for(int i = 0; i < start.length; i++) {
			if(check[i])
				continue;
			char temp = start[i];
			for(int j = 0; j < chars.length; j++) {
				start[i] = chars[j];
				String s = Arrays.toString(start);
				if(dictionary.contains(s)) {
					dictionary.remove(s);
					check[i] = true;
					output.add(s);
					getPathHelper(dictionary,start,end,output,check);
					return;
				}
			}
			start[i] = temp;
		}
		
	}
	
	Boolean checkIfEqual(char[] s1, char[] s2) {
		for(int i = 0; i < s1.length; i++) {
			if(s1[i]!=s2[i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		GoFromHeadToTailWordUsingDictionary obj = new GoFromHeadToTailWordUsingDictionary();
	}
}
