package VeryImportantQuestions;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
	
	static Set<String> getPermutations(String input) {
		char[] chars = input.toCharArray();
		Set<String> output = new HashSet<String>();
		output.add("");
		count c = new count();
		for(int i=0; i < chars.length; i++) {
			Set<String> temp = new HashSet<String>();
			for(String s: output) {
				for(int j=0; j<s.length();j++) {
					c.i += 1;
					String s1 = s.substring(0,j) + chars[i] + s.substring(j);
					temp.add(s1);
				}
				temp.add(s+chars[i]);
			}
			output = temp;
		}
		System.out.println(c.i);
		return output;
	}
	
	
	static Set<String> getPermutationsRecursively(String input) {
		char[] chars = input.toCharArray();
		Set<String> output = new HashSet<String>();
		count n = new count();
		n.i = 0;
		getPermutationsRecursivelyHelper(chars,0,input.length()-1,output,n);
		System.out.println("COunt "+n.i);
		return output;
	}
	
	private static void getPermutationsRecursivelyHelper(char[] input, int start, int end, Set<String> output, count n) {

		output.add(String.valueOf(input));
		for(int j = start; j < end; j++) {
		for(int i=j+1; i <=end; i++) {
			if(input[j]==input[i])
				continue;
			n.i += 1;
			swap(input,j,i);
			getPermutationsRecursivelyHelper(input,j+1,end,output,n);
			swap(input,j,i);
			}
		}
	}
	
	static Set<String> getPermutationsRecursively1(String input) {
		char[] chars = input.toCharArray();
		Set<String> output = new HashSet<String>();
		count n = new count();
		n.i = 0;
		getPermutationsRecursivelyHelper1(chars,0,input.length()-1,output,n);
		System.out.println("COunt "+n.i);
		return output;
	}
	
	private static void getPermutationsRecursivelyHelper1(char[] input, int start, int end, Set<String> output, count n) {

		output.add(String.valueOf(input));
		for(int i = start; i <= end; i++) {
			if(input[start]==input[end])
				continue;
			swap(input,start,i);
			n.i += 1;
//			System.out.println(String.valueOf(input)+" "+ n.i);
			getPermutationsRecursivelyHelper1(input,start+1,end,output,n);
			swap(input,start,i);
			}
	}
	
	private static void swap(char[] input,int index1, int index2) {
		char temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
	public static void main(String[] args) {
		System.out.println(getPermutationsRecursively1("abcde").size());
		System.out.println(getPermutationsRecursively("abcde").size());
		System.out.println(getPermutations("abcde").size());
	}
}


class count {
	int i;
}
