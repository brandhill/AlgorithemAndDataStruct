package ArraysandStrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class BearAndSteadyGene {
	Map<Character,Integer> map = new HashMap<Character,Integer>();
	StringBuffer find = new StringBuffer("");
	StringBuffer replace = new StringBuffer("");
	
	BearAndSteadyGene(){
		map.put('A', 0);
		map.put('C', 0);
		map.put('G', 0);
		map.put('T', 0);
	}
	
	void setReplacefind(int N){
		Iterator<Character> it = map.keySet().iterator();
		while(it.hasNext()){
			
			char c = it.next();
			System.out.println(c);
			int i = map.get(c);
			if(i<N/4){
				for(int j=1;j<=N/4-i;j++){
					replace.append(String.valueOf(c));
				}
			}
			else if(i>N/4){
				
				for(int j=1;j<=i-N/4;j++){
					find.append(String.valueOf(c));
				}
			}
		}
		
		
	}
	
	void replaceString(String S){
		int len = find.length();
		System.out.println("find "+find);
		//String find1 = sort(find.toString());
		//String find2 = sort(find.reverse().toString());
		while(len<S.length()){
			for(int i=0;i<S.length()-len;i++){
				String pat = sort(S.substring(i, i+len));
				String pat1 = sort((new StringBuffer(S.substring(i, i+len)).reverse().toString()));
				System.out.println("path "+pat);
				//System.out.println(pat.matches("(.*)"+find+"(.*)"));
				if(pat.matches("(.*)"+find+"(.*)") || pat1.matches("(.*)"+find+"(.*)")){
					System.out.println("Matched");
					pat = pat.replace(find, replace);
					System.out.println(S.substring(0, i)+pat+S.substring(i+len));
					System.out.println(pat.length());
					return;
				}
			}
			len++;
		}
		System.out.println("-1");
	}
	
	String sort(String S){
		char[] chars = S.toCharArray();
		Arrays.sort(chars);
		return String.valueOf(chars);
	}
	
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N = Integer.valueOf(in.nextLine()); 
	String S = in.nextLine();
	BearAndSteadyGene bear = new BearAndSteadyGene();
	char[] chars = S.toCharArray();
	for(int i=0;i<S.length();i++){
		//if(bear.map.containsKey(chars[i]))
			bear.map.put(chars[i],bear.map.get((chars)[i])+1);
	}
	bear.setReplacefind(N);
	bear.replaceString(S);
}
}
//GAAATAAAGCAA
//GCCTTGTAGCAA

//GCCTTGTAGCAATTAA
//GCCTTGCGGCAATTAA