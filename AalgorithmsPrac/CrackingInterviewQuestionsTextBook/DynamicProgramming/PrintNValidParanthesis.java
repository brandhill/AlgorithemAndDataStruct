package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import GraphsDataStructures.mainclass;

public class PrintNValidParanthesis {
	
	static Set<String> printNParanthesis(int N) {
		
		Set<String> set;
		if(N==0) {
			set = new HashSet<String>();
			set.add("");
			return set;
		}
		else {
			set = printNParanthesis(N-1);
			Set<String> newSet = new HashSet<String>();
			for(String par : set) {
				//String par = str;
				for ( int j = -1; j <par.length(); j++) {
					if( j==-1 || par.charAt(j) == '(') {
						String newPar = insertParan(par,j);
						if(!newSet.contains(newPar))
							newSet.add(newPar);
					}
				}
			}
			return newSet;
		}
		
	}
	
	static String insertParan(String s,int index) {
		return s.substring(0, index+1) + "()" + s.substring(index+1);
	}
	
	public static void main(String[] args) {
		Set<String> L = PrintNValidParanthesis.printNParanthesis(3);
		System.out.println(L.toString());
	}
}
