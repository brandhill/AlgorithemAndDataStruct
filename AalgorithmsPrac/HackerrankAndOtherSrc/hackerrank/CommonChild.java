package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CommonChild {

	int GetChild(String s1,String s2){
		int max = 0;
		if(s1.trim().length()==0 || s2.trim().length()==0 || s1==null || s2==null)
			return max;
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		
		Set<Character> lookUp = new HashSet<Character>();
		for( int i = 0; i < s2.length(); i++) {
			lookUp.add(chars2[i]);
		}
		int count = 0;
		for( int k = 0; k <s1.length(); k++){
			int start = 0, len = 0 ;
			for( int i = k; i<s1.length(); i++) {
				
				if(lookUp.contains(chars1[i])) {
					for( int j = start; j<s2.length(); j++) {
						count++;
						if(chars2[j]==chars1[i] && j > start){
							System.out.println(chars1[i]+" "+i+" "+chars2[j]+" "+j);
							start = j;
							len++;
							break;
						}
					}
					
				}
			}
			max = Math.max(max, len);
			System.out.println(max);
			System.out.println("--------");
			
			
		}
		
		
		
		System.out.println(count);
		
		return max;
	}
	
	public static void main(String[] args) {
		CommonChild c = new CommonChild();
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		System.out.println(c.GetChild(s1, s2));
	}
	
}

//WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS
//DGCGTRMZZVUYXIC
