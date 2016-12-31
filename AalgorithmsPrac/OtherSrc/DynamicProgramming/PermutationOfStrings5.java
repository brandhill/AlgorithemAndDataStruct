package DynamicProgramming;

import java.util.ArrayList;

import GraphsDataStructures.mainclass;

public class PermutationOfStrings5 {
	
	static ArrayList<String> findAllPermutations(String s,int index) {
		
		ArrayList<String> perms;
		String sub;
		if (s==null || s.isEmpty() || index == s.length()) {
			perms = new ArrayList<String>();
			perms.add("");
			sub = ""; 
		}
		else {
			perms = findAllPermutations(s,index+1);
			sub = s.substring(index,index+1);
		}
		
		ArrayList<String> newperms = new ArrayList<String>();
		for ( String p: perms) {
			int len = p.length();
			for ( int i =0 ;i <=len;i++) {
				String newstr = insertString(p,sub,i);
				//System.out.println(newstr);
				newperms.add(newstr);
			}
		}
		
		return newperms;
		
	}
	
	static String insertString(String s,String s1,int index) {
		String newString = s.substring(0, index)+s1+s.substring(index);
		return newString;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = PermutationOfStrings5.findAllPermutations("abc", 0);
		System.out.println(list.size());
		System.out.println(list.toString());
	}
}
