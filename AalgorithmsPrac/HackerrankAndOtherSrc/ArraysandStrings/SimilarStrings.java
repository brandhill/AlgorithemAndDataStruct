package ArraysandStrings;

import java.util.Scanner;

public class SimilarStrings {

	static void findSimilarStrings(String s,String[] indexs){
		for(int i=0;i<indexs.length;i++){
			//System.out.println(i);
			// lookup String A
			String[] x = indexs[i].split(" ");
			String lookup = s.substring(Integer.valueOf(x[0])-1, Integer.valueOf(x[1]));
			int count = 0;
			//System.out.println("lookup "+lookup);
			for(int l=0;l<s.length()-lookup.length()+1;l++){
				//check String B - which is substring of actual string s
				String check = s.substring(l,l+lookup.length());
			//	System.out.println("check "+check);
				boolean flag = true;
				// this code is used to check if lookup(A) pattern is same check pattern(B)
				for(int j=0;j<=lookup.length()-1;j++){
					for(int k=j+1;k<lookup.length();k++){
						//if lookup pattern is same as check pattern
						if(lookup.charAt(j)==lookup.charAt(k)){
							//lookup chars are equal then check chars should be equal then (true) else false
							if(check.charAt(j)==check.charAt(k)){
								flag = true;
							}
							else{
								flag=false;
								break;
							}
						}
						//if lookup pattern is same as check pattern
						else if(!(lookup.charAt(j)==lookup.charAt(k))){
							//lookup chars are not equal then check chars should not be equal then (true) else false
							if(!(check.charAt(j)==check.charAt(k))){
								flag = true;
							}
							else{
								flag=false;
								break;
							}
						}
					}
					if(flag==false){
						break;
					}
				}
				//System.out.println(flag);
				if(flag==true)
					count++;
			}
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    String str = in.nextLine();
	    String s = in.nextLine();
	    String[] x = str.split(" ");
	    int strlen = Integer.valueOf(x[0]);
	    int lines = Integer.valueOf(x[1]);
	    String[] indexs = new String[lines];
	    for(int i=0;i<lines;i++){
	    	indexs[i] = in.nextLine();
	    }
	    SimilarStrings.findSimilarStrings(s, indexs);
	    
	}
	
	
}
