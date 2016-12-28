package ArraysandStrings;

import java.util.Scanner;

public class CamelCase {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        char[] chars = s.toCharArray(); 
	        if(s.isEmpty())
	        	System.out.println(0);
	        else{
	        	int count = 1;
	        	for(int i=0; i<s.length();i++){
	        		if(chars[i]<97)
	        			count++;
	        	}
	        	System.out.println(count);
	        }
	    }
	
}
